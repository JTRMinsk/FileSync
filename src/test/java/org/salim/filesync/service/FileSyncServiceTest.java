package org.salim.filesync.service;

import org.junit.Test;

public class FileSyncServiceTest {

    @Test
    public void readFileListIntoDb() {
        FileSyncService fileSyncService = new FileSyncService();
        fileSyncService.readFileListIntoDb();
    }
}