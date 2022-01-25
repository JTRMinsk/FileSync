package org.salim.filesync.utils;

import org.junit.Test;

public class FtpUtilTest {

    @Test
    public void login() throws Exception{
        FtpUtil.listAllFolderNames("192.168.3.5", 22, "salim", "JFK181235", "/home/salim/ftp_root/backuproot");
    }
}