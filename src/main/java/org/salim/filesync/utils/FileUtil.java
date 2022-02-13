package org.salim.filesync.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Salim
 */
public class FileUtil extends BackupUtils{
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public static List<File> listAllSubFilesInBackup(File backupFolder) {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isFile();
            }
        };
        List<File> backupFiles = Arrays.asList(backupFolder.listFiles(filter));

        return backupFiles;
    }

    public static String getFileHash (File file) throws NoSuchAlgorithmException, IOException {
        if (!file.exists() || !file.isFile()) {
            LOG.error("Can not start calculate md5 for file:{}", file);
            return null;
        }

        FileInputStream inputStream = new FileInputStream(file);

        return getFileHash(inputStream);
    }

    public static void getAllFileHash(List<File> folders) throws NoSuchAlgorithmException, IOException {
        for (File file : folders) {
            if (file.isFile()) {
                LOG.info("Got file hash, file:{}, hash:{}", file, getFileHash(file));
            } else {
                getAllFileHash(Arrays.asList(file.listFiles()));
            }
        }
    }

}
