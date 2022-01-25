package org.salim.filesync;

import org.salim.filesync.utils.FileUtil;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * @author Salim
 * BackupFolder/FetchFolder
 * 判断本机的系统类型，对应目录命名方式，以及默认的backup文件位置（最好能够读取各个硬盘的空间和剩余空间，性能参数等）
 * Backup位置的要求：
 * 1. 最好不要是系统盘
 * 2. 最好不要用系统盘所在的盘符
 * 3. 剩余空间健康
 *
 *
 * 首先，扫描备份目录（配置），列出所有文档，并计算哈希码，或者update时间
 * 逐个扫描 目标目录（本地、局域网）下的文件， 得到命名、改动时间，并计算哈希值
 * 创建对应目录的文件夹，并将对应文件放到文件夹下
 */
public class FileSynchronizationFunction {

    private static String backupFilePath = "C:\\Users\\Admin\\Desktop\\TEST";

    public static void main(String[] args) {
        System.getProperty("os.name");
        File[] disks = File.listRoots();
        for (File disk : disks) {
            System.out.println(disk.getAbsolutePath() + " has free space: " + disk.getFreeSpace() / 1024 / 1024 / 1024 + "GB" + " total space: " + disk.getTotalSpace() / 1024 / 1024 / 1024 + "GB");
        }

        List<File> subFolders = FileUtil.listAllSubFoldersInBackup(new File(backupFilePath));



        for (File subFolder : subFolders) {
            System.out.println(subFolder.getAbsolutePath());
        }
        Properties props = System.getProperties();
        System.out.println("默认的临时文件路径：    " + props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径：    " + props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
        System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
        System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
        System.out.println("文件分隔符：    " + props.getProperty("file.separator"));
        System.out.println("路径分隔符：    " + props.getProperty("path.separator"));
        System.out.println("行分隔符：    " + props.getProperty("line.separator"));
        System.out.println("用户的账户名称：    " + props.getProperty("user.name"));
        System.out.println("用户的主目录：    " + props.getProperty("user.home"));
        System.out.println("用户的当前工作目录：    " + props.getProperty("user.dir"));



    }

}
