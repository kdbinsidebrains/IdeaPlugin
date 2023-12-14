package org.kdb.inside.brains.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.kdb.inside.brains.psi.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    private static final boolean COLLAPSED_BY_DEFAULT = false;

    private static final FoldingDescriptor[] EMPTY_ARRAY = new FoldingDescriptor[0];

    @NotNull
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        final Collection<QTableExpr> tables = PsiTreeUtil.findChildrenOfType(root, QTableExpr.class);
        final Collection<QLambdaExpr> lambdas = PsiTreeUtil.findChildrenOfType(root, QLambdaExpr.class);
        if (lambdas.isEmpty() && tables.isEmpty()) {
            return EMPTY_ARRAY;
        }
        return Stream.concat(tables.stream(), lambdas.stream()).map(l -> new FoldingDescriptor(l, l.getTextRange())).toArray(FoldingDescriptor[]::new);
    }

    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        final PsiElement psi = node.getPsi();
        if (psi instanceof QLambdaExpr lambda) {
            return "{" + Optional.of(lambda).map(QLambdaExpr::getParameters).map(QParameters::getVariables).map(Collection::stream).map(v -> "[" + v.map(QVariable::getQualifiedName).collect(Collectors.joining(";")) + "]").orElse("") + "...}";
        } else if (psi instanceof QTableExpr tbl) {
            return "([" + getColumnsCount(tbl.getKeys()) + "]" + getColumnsCount(tbl.getValues()) + ")";
        }
        return "...";
    }

    @NotNull
    private String getColumnsCount(QTableColumns columns) {
        return columns == null ? "" : " " + columns.getColumns().size() + " ";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return COLLAPSED_BY_DEFAULT;
    }
}
