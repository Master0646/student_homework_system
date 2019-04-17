package com.tujietg.gradpro.pojo;

import java.util.Date;

public class OrderQuestionsReply {
    private Integer id;

    private String historyId;

    private Integer identityMark;

    private String statusQuestions;

    private String teacherReply;

    private Date questTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId == null ? null : historyId.trim();
    }

    public Integer getIdentityMark() {
        return identityMark;
    }

    public void setIdentityMark(Integer identityMark) {
        this.identityMark = identityMark;
    }

    public String getStatusQuestions() {
        return statusQuestions;
    }

    public void setStatusQuestions(String statusQuestions) {
        this.statusQuestions = statusQuestions == null ? null : statusQuestions.trim();
    }

    public String getTeacherReply() {
        return teacherReply;
    }

    public void setTeacherReply(String teacherReply) {
        this.teacherReply = teacherReply == null ? null : teacherReply.trim();
    }

    public Date getQuestTime() {
        return questTime;
    }

    public void setQuestTime(Date questTime) {
        this.questTime = questTime;
    }
}