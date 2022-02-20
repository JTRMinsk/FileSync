package org.salim.filesync.db;

import org.salim.filesync.model.FileDescription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Salim
 */
public class FileTrackerDAO {

    private String dbType = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String dbOperator = "ftpfilemanager";
    private String dbPassword = "181235";
    private String schema = "filemanage";

    public void addFileIntoTracker(FileDescription fileDescription) throws ClassNotFoundException, SQLException {
        Class.forName(dbType);
        Connection connection = DriverManager.getConnection(dbAddress + schema, dbOperator, dbPassword);

        Statement sql = connection.createStatement();

    }


}
