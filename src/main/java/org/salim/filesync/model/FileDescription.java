package org.salim.filesync.model;

/**
 * @author Salim
 */
public class FileDescription {
    private String fileName;
    private String filePath;
    private String fileHash;
    private String fileSize;
    private String sourceMachine;
    private Integer sourceMachineId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String getSourceMachine() {
        return sourceMachine;
    }

    public void setSourceMachine(String sourceMachine) {
        this.sourceMachine = sourceMachine;
    }

    public Integer getSourceMachineId() {
        return sourceMachineId;
    }

    public void setSourceMachineId(Integer sourceMachineId) {
        this.sourceMachineId = sourceMachineId;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FileDescription{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileHash='" + fileHash + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", sourceMachine='" + sourceMachine + '\'' +
                ", sourceMachineId=" + sourceMachineId +
                '}';
    }
}
