package org.salim.filesync.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Admin
 * 本机信息获取
 * backup 文件夹遍历
 * 文档信息计算获取
 *
 * 一般对Util类有什么要求？log？ 是否用到其他类？
 */
public class BackupUtils {

    public static String getFileHash (InputStream inputStream) throws IOException, NoSuchAlgorithmException {
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

}
