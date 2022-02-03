package org.salim.filesync.utils;

import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileUtilTest {

    @Test
    public void listAllSubFoldersInBackup() {
        List<File> files = FileUtil.listAllSubFilesInBackup(new File("C:\\Users\\Admin\\Desktop\\TEST")); // All sub-folders will be listed
        System.out.println(files.toString());
    }
}