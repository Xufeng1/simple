package com.spring.simple.model;

import java.util.Date;

public class DiffFile {
    private Integer id;

    private Date diffTime;

    private String sourceFile;

    private String targetFile;

    private String difference;

    private String sourceFileName;

    private String targetFileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiffTime() {
        return diffTime;
    }

    public void setDiffTime(Date diffTime) {
        this.diffTime = diffTime;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile == null ? null : sourceFile.trim();
    }

    public String getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile == null ? null : targetFile.trim();
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference == null ? null : difference.trim();
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName == null ? null : sourceFileName.trim();
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName == null ? null : targetFileName.trim();
    }
}