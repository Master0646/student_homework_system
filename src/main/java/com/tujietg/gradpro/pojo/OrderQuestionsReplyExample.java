package com.tujietg.gradpro.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQuestionsReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderQuestionsReplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIsNull() {
            addCriterion("history_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIsNotNull() {
            addCriterion("history_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdEqualTo(String value) {
            addCriterion("history_id =", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotEqualTo(String value) {
            addCriterion("history_id <>", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThan(String value) {
            addCriterion("history_id >", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("history_id >=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThan(String value) {
            addCriterion("history_id <", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThanOrEqualTo(String value) {
            addCriterion("history_id <=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLike(String value) {
            addCriterion("history_id like", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotLike(String value) {
            addCriterion("history_id not like", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIn(List<String> values) {
            addCriterion("history_id in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotIn(List<String> values) {
            addCriterion("history_id not in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdBetween(String value1, String value2) {
            addCriterion("history_id between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotBetween(String value1, String value2) {
            addCriterion("history_id not between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkIsNull() {
            addCriterion("identity_mark is null");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkIsNotNull() {
            addCriterion("identity_mark is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkEqualTo(Integer value) {
            addCriterion("identity_mark =", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkNotEqualTo(Integer value) {
            addCriterion("identity_mark <>", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkGreaterThan(Integer value) {
            addCriterion("identity_mark >", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("identity_mark >=", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkLessThan(Integer value) {
            addCriterion("identity_mark <", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkLessThanOrEqualTo(Integer value) {
            addCriterion("identity_mark <=", value, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkIn(List<Integer> values) {
            addCriterion("identity_mark in", values, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkNotIn(List<Integer> values) {
            addCriterion("identity_mark not in", values, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkBetween(Integer value1, Integer value2) {
            addCriterion("identity_mark between", value1, value2, "identityMark");
            return (Criteria) this;
        }

        public Criteria andIdentityMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("identity_mark not between", value1, value2, "identityMark");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsIsNull() {
            addCriterion("status_questions is null");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsIsNotNull() {
            addCriterion("status_questions is not null");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsEqualTo(String value) {
            addCriterion("status_questions =", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsNotEqualTo(String value) {
            addCriterion("status_questions <>", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsGreaterThan(String value) {
            addCriterion("status_questions >", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsGreaterThanOrEqualTo(String value) {
            addCriterion("status_questions >=", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsLessThan(String value) {
            addCriterion("status_questions <", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsLessThanOrEqualTo(String value) {
            addCriterion("status_questions <=", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsLike(String value) {
            addCriterion("status_questions like", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsNotLike(String value) {
            addCriterion("status_questions not like", value, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsIn(List<String> values) {
            addCriterion("status_questions in", values, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsNotIn(List<String> values) {
            addCriterion("status_questions not in", values, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsBetween(String value1, String value2) {
            addCriterion("status_questions between", value1, value2, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andStatusQuestionsNotBetween(String value1, String value2) {
            addCriterion("status_questions not between", value1, value2, "statusQuestions");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyIsNull() {
            addCriterion("teacher_reply is null");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyIsNotNull() {
            addCriterion("teacher_reply is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyEqualTo(String value) {
            addCriterion("teacher_reply =", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyNotEqualTo(String value) {
            addCriterion("teacher_reply <>", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyGreaterThan(String value) {
            addCriterion("teacher_reply >", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_reply >=", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyLessThan(String value) {
            addCriterion("teacher_reply <", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyLessThanOrEqualTo(String value) {
            addCriterion("teacher_reply <=", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyLike(String value) {
            addCriterion("teacher_reply like", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyNotLike(String value) {
            addCriterion("teacher_reply not like", value, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyIn(List<String> values) {
            addCriterion("teacher_reply in", values, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyNotIn(List<String> values) {
            addCriterion("teacher_reply not in", values, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyBetween(String value1, String value2) {
            addCriterion("teacher_reply between", value1, value2, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andTeacherReplyNotBetween(String value1, String value2) {
            addCriterion("teacher_reply not between", value1, value2, "teacherReply");
            return (Criteria) this;
        }

        public Criteria andQuestTimeIsNull() {
            addCriterion("quest_time is null");
            return (Criteria) this;
        }

        public Criteria andQuestTimeIsNotNull() {
            addCriterion("quest_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuestTimeEqualTo(Date value) {
            addCriterion("quest_time =", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeNotEqualTo(Date value) {
            addCriterion("quest_time <>", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeGreaterThan(Date value) {
            addCriterion("quest_time >", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("quest_time >=", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeLessThan(Date value) {
            addCriterion("quest_time <", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeLessThanOrEqualTo(Date value) {
            addCriterion("quest_time <=", value, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeIn(List<Date> values) {
            addCriterion("quest_time in", values, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeNotIn(List<Date> values) {
            addCriterion("quest_time not in", values, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeBetween(Date value1, Date value2) {
            addCriterion("quest_time between", value1, value2, "questTime");
            return (Criteria) this;
        }

        public Criteria andQuestTimeNotBetween(Date value1, Date value2) {
            addCriterion("quest_time not between", value1, value2, "questTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}