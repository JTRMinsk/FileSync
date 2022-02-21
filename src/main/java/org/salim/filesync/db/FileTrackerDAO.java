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
    private String dbAddress = "jdbc:mysql://192.168.3.5:3306/";
    private String dbOperator = "ftpfilemanager";
    private String dbPassword = "181235";
    private String schema = "filemanage";
    private String fileTableName = "target_files";

    public void addFileIntoTracker(FileDescription fileDescription) throws ClassNotFoundException, SQLException {
        Class.forName(dbType);
        Connection connection = DriverManager.getConnection(dbAddress + schema, dbOperator, dbPassword);

        Statement sql = connection.createStatement();
        String command = "insert into " + "`" + fileTableName + "`" +
                        " (`file_name`, `file_path`,`file_hash`) " +
                        "values (\"test\", \"test\", \"test\");";

        sql.executeUpdate(command);
        connection.close();
    }


}
