package org.kdb.inside.brains.lang.annotation.impl;

import com.intellij.codeInsight.intention.AbstractIntentionAction;
import com.intellij.codeInspection.util.IntentionName;
import com.intellij.lang.annotation.AnnotationBuilder;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.kdb.inside.brains.lang.annotation.QElementAnnotator;
import org.kdb.inside.brains.lang.annotation.WriteIntentionAction;
import org.kdb.inside.brains.psi.*;

public class QTableAnnotator extends QElementAnnotator<QTableExpr> {
    public QTableAnnotator() {
        super(QTableExpr.class);
    }


    private static void validateTailSemicolon(PsiElement element, AnnotationHolder holder) {
        if (element == null) {
            return;
        }

        PsiElement semicolon = null;
        PsiElement child = QPsiUtil.getFirstNonWhitespaceAndCommentsChild(element);
        while (child != null) {
            final IElementType et = child.getNode().getElementType();
            if (et != QTypes.BRACKET_OPEN && et != QTypes.BRACKET_CLOSE) {
                if (et == QTypes.TABLE_COLUMN) {
                    validateMissedDeclarations(child, holder);
                }
                if (et == QTypes.SEMICOLON) {
                    if (semicolon != null) {
                        createSemicolonError(child, holder);
                    } else {
                        semicolon = child;
                    }
                } else {
                    semicolon = null;
                }
            }
            child = PsiTreeUtil.skipWhitespacesAndCommentsForward(child);
        }

        if (semicolon != null) {
            createSemicolonError(semicolon, holder);
        }
    }

    private static void validateMissedDeclarations(PsiElement column, AnnotationHolder holder) {
        final PsiElement child = column.getFirstChild();
        if (!(child instanceof QVarDeclaration)) {
            AnnotationBuilder builder = holder.newAnnotation(HighlightSeverity.WARNING, "Column declaration with a name").range(child);

            final PsiElement missedDeclaration = getMissedColumnDeclaration(child);
            if (missedDeclaration != null) {
                builder = builder.withFix(new WriteIntentionAction("Insert declaration colon", (project, editor, file) -> {
                            final TextRange range = missedDeclaration.getTextRange();
                            editor.getDocument().replaceString(range.getStartOffset(), range.getEndOffset(), ":");
                        })
                );
            }
            builder = builder.withFix(new WriteIntentionAction("Insert column name", (project, editor, file) -> {
                        final TextRange range = child.getTextRange();
                        editor.getDocument().replaceString(range.getStartOffset(), range.getStartOffset(), ":");
                        editor.getCaretModel().moveToOffset(range.getStartOffset());
                    })
            );
            builder.create();
        }
    }

    private static PsiElement getMissedColumnDeclaration(PsiElement firstChild) {
        if (!(firstChild instanceof QInvokeFunction invoke)) {
            return null;
        }

        final PsiElement first = QPsiUtil.getFirstNonWhitespaceAndCommentsChild(invoke);
        if (!(first instanceof QCustomFunction)) {
            return null;
        }

        final PsiElement second = QPsiUtil.getFirstNonWhitespaceAndCommentsChild(first);
        if (!(second instanceof QVarReference)) {
            return null;
        }
        return first.getNextSibling();
    }

    @Override
    protected void annotate(@NotNull QTableExpr element, @NotNull AnnotationHolder holder) {
        validateTailSemicolon(element, holder);
        validateTailSemicolon(element.getKeys(), holder);
        validateTailSemicolon(element.getValues(), holder);
    }

    private static void createSemicolonError(PsiElement el, AnnotationHolder holder) {
        holder.newAnnotation(HighlightSeverity.ERROR, "Tailing semicolon is not allowed in a table definition")
                .range(el)
                .withFix(new AbstractIntentionAction() {
                    @Override
                    public @IntentionName @NotNull String getText() {
                        return "Remove semicolon";
                    }

                    @Override
                    public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
                        el.delete();
                    }

                    @Override
                    public boolean startInWriteAction() {
                        return true;
                    }
                })
                .create();
    }
}
