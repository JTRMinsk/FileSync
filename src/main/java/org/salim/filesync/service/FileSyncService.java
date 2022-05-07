package org.salim.filesync.service;

import org.salim.filesync.db.FileTrackerDAO;
import org.salim.filesync.model.FileDescription;
import org.salim.filesync.utils.FtpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FileSyncService {
    private static final Logger LOG = LoggerFactory.getLogger(FileSyncService.class);

    public void readFileListIntoDb() {
        List<FileDescription> fileDescriptions = FtpUtil.listAllRemoteSubFiles(
                "192.168.196.214",
                22,
                "salim",
                "JFK181235",
                "/home/salim/ftp_root/backuproot");
        FileTrackerDAO fileTrackerDAO = new FileTrackerDAO();
        for (FileDescription fileDescription : fileDescriptions) {
            try {
                fileTrackerDAO.addFileIntoTracker(fileDescription);
            } catch (Exception e) {
                LOG.error("Error during insert: {}, for file:{}", e.getMessage(), fileDescription);
            }
        }

    }

}
