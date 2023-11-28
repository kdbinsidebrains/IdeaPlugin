package org.kdb.inside.brains.psi;

import com.intellij.ide.IconProvider;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.ui.IconManager;
import com.intellij.ui.icons.RowIcon;
import com.intellij.util.BitUtil;
import icons.KdbIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static com.intellij.openapi.util.Iconable.ICON_FLAG_VISIBILITY;

public class QIconProvider extends IconProvider implements DumbAware {
    public static Icon getColumnIcon(@NotNull QTableColumn column) {
        return QPsiUtil.isKeyColumn(column) ? KdbIcons.Node.TableKeyColumn : KdbIcons.Node.TableValueColumn;
    }

    @Override
    public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {
        final boolean visibility = BitUtil.isSet(flags, ICON_FLAG_VISIBILITY);

        if (element instanceof QImport) {
            return KdbIcons.Node.Import;
        } else if (element instanceof QCommand) {
            return KdbIcons.Node.Command;
        } else if (element instanceof QContext) {
            return KdbIcons.Node.Context;
        } else if (element instanceof QSymbol) {
            return KdbIcons.Node.Symbol;
        } else if (element instanceof QTableColumn tbl) {
            return getColumnIcon(tbl);
        } else if (element instanceof QLambdaExpr) {
            return KdbIcons.Node.Lambda;
        } else if (element instanceof QAssignmentExpr assignment) {
            return getAssignmentIcon(assignment, visibility);
        } else if (element instanceof QVarDeclaration declaration) {
            return getIcon(declaration.getParent(), flags);
        }
        return null;
    }

    private Icon getAssignmentIcon(QAssignmentExpr assignment, boolean visibility) {
        final QExpression expression = assignment.getExpression();
        if (expression == null) {
            return null;
        }

        Icon i = getExpressionIcon(expression);
        if (visibility) {
            final RowIcon icon = IconManager.getInstance().createLayeredIcon(assignment, i, 0);
            icon.setIcon(getVisibilityIcon(assignment), 1);
            return icon;
        }
        return i;
    }

    private Icon getVisibilityIcon(QAssignmentExpr assignment) {
        return QPsiUtil.isGlobalDeclaration(assignment) ? KdbIcons.Node.PublicItem : KdbIcons.Node.PrivateItem;
    }

    private Icon getExpressionIcon(QExpression expression) {
        if (expression instanceof QLambdaExpr) {
            return KdbIcons.Node.Lambda;
        } else if (expression instanceof QTableExpr) {
            return KdbIcons.Node.Table;
        }
        return KdbIcons.Node.Variable;
    }
}
