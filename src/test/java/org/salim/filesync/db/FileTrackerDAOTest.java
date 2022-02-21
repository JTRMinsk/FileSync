package org.salim.filesync.db;

import org.junit.Test;
import org.salim.filesync.model.FileDescription;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class FileTrackerDAOTest {

    @Test
    public void addFileIntoTracker() throws SQLException, ClassNotFoundException {
        FileTrackerDAO fileTrackerDAO = new FileTrackerDAO();
        FileDescription fd = new FileDescription();
        fd.setFileHash("test empty");
        fd.setFileName("test empty");
        fd.setFilePath("test empty");
        fd.setFileSize("test empty");
        fd.setSourceMachine("test empty");
        fileTrackerDAO.addFileIntoTracker(fd);
    }
}