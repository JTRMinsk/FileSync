package org.salim.filesync.db;

import org.junit.Test;
import org.salim.filesync.model.FileDescription;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class FileTrackerDAOTest {

    @Test
    public void addFileIntoTracker() throws SQLException, ClassNotFoundException {
        FileTrackerDAO fileTrackerDAO = new FileTrackerDAO();
        fileTrackerDAO.addFileIntoTracker(new FileDescription());
    }
}