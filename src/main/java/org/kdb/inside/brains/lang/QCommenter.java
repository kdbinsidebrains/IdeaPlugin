package org.kdb.inside.brains.lang;

import com.intellij.lang.Commenter;

public final class QCommenter implements Commenter {
    @Override
    public String getLineCommentPrefix() {
        return "/";
    }

    @Override
    public String getBlockCommentPrefix() {
        return "/\n";
    }

    @Override
    public String getBlockCommentSuffix() {
        return "\n\\";
    }

    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    public boolean blockCommentRequiresFullLineSelection() {
        return true;
    }
}
