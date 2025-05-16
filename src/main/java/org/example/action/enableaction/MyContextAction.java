package org.example.action.enableaction;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;


import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.diagnostic.Logger;

public class MyContextAction extends AnAction {
    private static final Logger logger = Logger.getInstance(MyContextAction.class);

    public MyContextAction() {
        super("Register");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        logger.info("Create and show the browser dialog");
    }

    // @Override
    // public @NotNull ActionUpdateThread getActionUpdateThread() {
    //     return ActionUpdateThread.BGT;
    // }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile[] files = e.getData(PlatformDataKeys.VIRTUAL_FILE_ARRAY);
        int fileCount = files != null ? files.length : 0;
        boolean enabled = project != null && fileCount == 1;
        logger.info("Enabled: " + enabled + " project: " + project + " files: " + fileCount);
        e.getPresentation().setEnabled(enabled);
        e.getPresentation().setVisible(true);
    }

}
