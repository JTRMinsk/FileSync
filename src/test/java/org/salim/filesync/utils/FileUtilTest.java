package org.salim.filesync.utils;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class FileUtilTest {

    @Test
    public void listAllSubFoldersInBackup() throws NoSuchAlgorithmException, IOException {
        List<File> files = FileUtil.listAllSubFilesInBackup(new File("C:\\Users\\Admin\\Desktop\\TEST")); // All sub-folders will be listed
        FileUtil.getAllFileHash(files);
        //just changing name will not update hash
        //duplicate will have same hash
    }
}