package com.spring.simple.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiffFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiffFileExample() {
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

        public Criteria andDiffTimeIsNull() {
            addCriterion("diff_time is null");
            return (Criteria) this;
        }

        public Criteria andDiffTimeIsNotNull() {
            addCriterion("diff_time is not null");
            return (Criteria) this;
        }

        public Criteria andDiffTimeEqualTo(Date value) {
            addCriterion("diff_time =", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeNotEqualTo(Date value) {
            addCriterion("diff_time <>", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeGreaterThan(Date value) {
            addCriterion("diff_time >", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("diff_time >=", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeLessThan(Date value) {
            addCriterion("diff_time <", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeLessThanOrEqualTo(Date value) {
            addCriterion("diff_time <=", value, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeIn(List<Date> values) {
            addCriterion("diff_time in", values, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeNotIn(List<Date> values) {
            addCriterion("diff_time not in", values, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeBetween(Date value1, Date value2) {
            addCriterion("diff_time between", value1, value2, "diffTime");
            return (Criteria) this;
        }

        public Criteria andDiffTimeNotBetween(Date value1, Date value2) {
            addCriterion("diff_time not between", value1, value2, "diffTime");
            return (Criteria) this;
        }

        public Criteria andSourceFileIsNull() {
            addCriterion("source_file is null");
            return (Criteria) this;
        }

        public Criteria andSourceFileIsNotNull() {
            addCriterion("source_file is not null");
            return (Criteria) this;
        }

        public Criteria andSourceFileEqualTo(String value) {
            addCriterion("source_file =", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileNotEqualTo(String value) {
            addCriterion("source_file <>", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileGreaterThan(String value) {
            addCriterion("source_file >", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileGreaterThanOrEqualTo(String value) {
            addCriterion("source_file >=", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileLessThan(String value) {
            addCriterion("source_file <", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileLessThanOrEqualTo(String value) {
            addCriterion("source_file <=", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileLike(String value) {
            addCriterion("source_file like", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileNotLike(String value) {
            addCriterion("source_file not like", value, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileIn(List<String> values) {
            addCriterion("source_file in", values, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileNotIn(List<String> values) {
            addCriterion("source_file not in", values, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileBetween(String value1, String value2) {
            addCriterion("source_file between", value1, value2, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andSourceFileNotBetween(String value1, String value2) {
            addCriterion("source_file not between", value1, value2, "sourceFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileIsNull() {
            addCriterion("target_file is null");
            return (Criteria) this;
        }

        public Criteria andTargetFileIsNotNull() {
            addCriterion("target_file is not null");
            return (Criteria) this;
        }

        public Criteria andTargetFileEqualTo(String value) {
            addCriterion("target_file =", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileNotEqualTo(String value) {
            addCriterion("target_file <>", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileGreaterThan(String value) {
            addCriterion("target_file >", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileGreaterThanOrEqualTo(String value) {
            addCriterion("target_file >=", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileLessThan(String value) {
            addCriterion("target_file <", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileLessThanOrEqualTo(String value) {
            addCriterion("target_file <=", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileLike(String value) {
            addCriterion("target_file like", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileNotLike(String value) {
            addCriterion("target_file not like", value, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileIn(List<String> values) {
            addCriterion("target_file in", values, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileNotIn(List<String> values) {
            addCriterion("target_file not in", values, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileBetween(String value1, String value2) {
            addCriterion("target_file between", value1, value2, "targetFile");
            return (Criteria) this;
        }

        public Criteria andTargetFileNotBetween(String value1, String value2) {
            addCriterion("target_file not between", value1, value2, "targetFile");
            return (Criteria) this;
        }

        public Criteria andDifferenceIsNull() {
            addCriterion("difference is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceIsNotNull() {
            addCriterion("difference is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceEqualTo(String value) {
            addCriterion("difference =", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotEqualTo(String value) {
            addCriterion("difference <>", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceGreaterThan(String value) {
            addCriterion("difference >", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceGreaterThanOrEqualTo(String value) {
            addCriterion("difference >=", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceLessThan(String value) {
            addCriterion("difference <", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceLessThanOrEqualTo(String value) {
            addCriterion("difference <=", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceLike(String value) {
            addCriterion("difference like", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotLike(String value) {
            addCriterion("difference not like", value, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceIn(List<String> values) {
            addCriterion("difference in", values, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotIn(List<String> values) {
            addCriterion("difference not in", values, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceBetween(String value1, String value2) {
            addCriterion("difference between", value1, value2, "difference");
            return (Criteria) this;
        }

        public Criteria andDifferenceNotBetween(String value1, String value2) {
            addCriterion("difference not between", value1, value2, "difference");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameIsNull() {
            addCriterion("source_file_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameIsNotNull() {
            addCriterion("source_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameEqualTo(String value) {
            addCriterion("source_file_name =", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameNotEqualTo(String value) {
            addCriterion("source_file_name <>", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameGreaterThan(String value) {
            addCriterion("source_file_name >", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_file_name >=", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameLessThan(String value) {
            addCriterion("source_file_name <", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameLessThanOrEqualTo(String value) {
            addCriterion("source_file_name <=", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameLike(String value) {
            addCriterion("source_file_name like", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameNotLike(String value) {
            addCriterion("source_file_name not like", value, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameIn(List<String> values) {
            addCriterion("source_file_name in", values, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameNotIn(List<String> values) {
            addCriterion("source_file_name not in", values, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameBetween(String value1, String value2) {
            addCriterion("source_file_name between", value1, value2, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andSourceFileNameNotBetween(String value1, String value2) {
            addCriterion("source_file_name not between", value1, value2, "sourceFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameIsNull() {
            addCriterion("target_file_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameIsNotNull() {
            addCriterion("target_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameEqualTo(String value) {
            addCriterion("target_file_name =", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameNotEqualTo(String value) {
            addCriterion("target_file_name <>", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameGreaterThan(String value) {
            addCriterion("target_file_name >", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_file_name >=", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameLessThan(String value) {
            addCriterion("target_file_name <", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameLessThanOrEqualTo(String value) {
            addCriterion("target_file_name <=", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameLike(String value) {
            addCriterion("target_file_name like", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameNotLike(String value) {
            addCriterion("target_file_name not like", value, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameIn(List<String> values) {
            addCriterion("target_file_name in", values, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameNotIn(List<String> values) {
            addCriterion("target_file_name not in", values, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameBetween(String value1, String value2) {
            addCriterion("target_file_name between", value1, value2, "targetFileName");
            return (Criteria) this;
        }

        public Criteria andTargetFileNameNotBetween(String value1, String value2) {
            addCriterion("target_file_name not between", value1, value2, "targetFileName");
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