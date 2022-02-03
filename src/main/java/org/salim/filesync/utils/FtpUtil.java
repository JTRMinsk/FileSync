package org.salim.filesync.utils;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @author Salim
 *
 */
public class FtpUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);



    public static List<String> listAllFolderNames(String host, int port, String username, final String password, String dir) {
        List<String> list = new ArrayList<String>();
        ChannelSftp sftp = null;
        Channel channel = null;
        Session sshSession = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            LOG.debug("Session connected!");
            channel = sshSession.openChannel("sftp");
            channel.connect();
            LOG.debug("Channel connected!");
            //协议为SFTP
            sftp = (ChannelSftp) channel;
            Vector<?> vector = sftp.ls(dir);
            for (Object item:vector) {
                //得到的文件单位是lsEntry
                ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) item;
                SftpATTRS sftpATTRS = entry.getAttrs();
                if (".".equalsIgnoreCase(entry.getFilename()) || "..".equalsIgnoreCase(entry.getFilename())) {

                } else {
                    LOG.info("Got {}, with name: {}, with detail: {}",sftpATTRS.getPermissionsString().startsWith("d") ? "FOLDER" : "FILE" , entry.getFilename(), sftpATTRS);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception during FTP file search", e);
        } finally {
            closeChannel(sftp);
            closeChannel(channel);
            closeSession(sshSession);
        }
        return list;
    }

    private static void closeChannel(Channel channel) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
    }

    private static void closeSession(Session session) {
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

}
