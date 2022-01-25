package org.salim.filesync.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Salim
 */
public class FileUtil {

    public static List<File> listAllSubFoldersInBackup (File backupFolder) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isFile();
            }
        };
        List<File> backupFiles = Arrays.asList(backupFolder.listFiles(filter));

        return backupFiles;
    }
}
