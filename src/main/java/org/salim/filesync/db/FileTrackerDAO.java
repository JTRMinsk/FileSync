package org.salim.filesync.db;

import org.salim.filesync.model.FileDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Salim
 */
public class FileTrackerDAO {
    private static final Logger LOG = LoggerFactory.getLogger(FileTrackerDAO.class);

    private String dbType = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://192.168.196.214:3306/";
    private String dbOperator = "ftpfilemanager";
    private String dbPassword = "181235";
    private String schema = "filemanage";
    private String fileTableName = "target_files";

    public void addFileIntoTracker(FileDescription fileDescription) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            Class.forName(dbType);
            connection = DriverManager.getConnection(dbAddress + schema, dbOperator, dbPassword);

            Statement sql = connection.createStatement();
            String command = "insert into " + "`" + fileTableName + "`" +
                    " (`file_name`, `file_path`, `file_hash`, `source_mechine`, `file_size`) " +
                    "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\");";
            command = String.format(command,
                    fileDescription.getFileName(),
                    fileDescription.getFilePath(),
                    fileDescription.getFileHash(),
                    fileDescription.getSourceMachine(),
                    fileDescription.getFileSize());

            sql.executeUpdate(command);
            connection.close();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<FileDescription> checkFileTracker() throws SQLException {


        return null;
    }


}
