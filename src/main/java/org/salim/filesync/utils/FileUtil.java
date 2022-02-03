package org.salim.filesync.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Salim
 */
public class FileUtil {
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

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = inputStream.read(buffer, 0, 1024)) != -1) {
            messageDigest.update(buffer, 0, length);
        }
        inputStream.close();

        byte[] md5Bytes = messageDigest.digest();
        BigInteger result = new BigInteger(1, md5Bytes);
        return result.toString(16);
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
