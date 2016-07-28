package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceStatusCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceStatusCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andInstancestatusidIsNull() {
            addCriterion("instancestatusid is null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidIsNotNull() {
            addCriterion("instancestatusid is not null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidEqualTo(Long value) {
            addCriterion("instancestatusid =", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidNotEqualTo(Long value) {
            addCriterion("instancestatusid <>", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidGreaterThan(Long value) {
            addCriterion("instancestatusid >", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidGreaterThanOrEqualTo(Long value) {
            addCriterion("instancestatusid >=", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidLessThan(Long value) {
            addCriterion("instancestatusid <", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidLessThanOrEqualTo(Long value) {
            addCriterion("instancestatusid <=", value, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidIn(List<Long> values) {
            addCriterion("instancestatusid in", values, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidNotIn(List<Long> values) {
            addCriterion("instancestatusid not in", values, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidBetween(Long value1, Long value2) {
            addCriterion("instancestatusid between", value1, value2, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancestatusidNotBetween(Long value1, Long value2) {
            addCriterion("instancestatusid not between", value1, value2, "instancestatusid");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeIsNull() {
            addCriterion("instancecreatetime is null");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeIsNotNull() {
            addCriterion("instancecreatetime is not null");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeEqualTo(Timestamp value) {
            addCriterion("instancecreatetime =", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeNotEqualTo(Timestamp value) {
            addCriterion("instancecreatetime <>", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeGreaterThan(Timestamp value) {
            addCriterion("instancecreatetime >", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("instancecreatetime >=", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeLessThan(Timestamp value) {
            addCriterion("instancecreatetime <", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("instancecreatetime <=", value, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeIn(List<Timestamp> values) {
            addCriterion("instancecreatetime in", values, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeNotIn(List<Timestamp> values) {
            addCriterion("instancecreatetime not in", values, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("instancecreatetime between", value1, value2, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancecreatetimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("instancecreatetime not between", value1, value2, "instancecreatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeIsNull() {
            addCriterion("instancelastupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeIsNotNull() {
            addCriterion("instancelastupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeEqualTo(Timestamp value) {
            addCriterion("instancelastupdatetime =", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeNotEqualTo(Timestamp value) {
            addCriterion("instancelastupdatetime <>", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeGreaterThan(Timestamp value) {
            addCriterion("instancelastupdatetime >", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("instancelastupdatetime >=", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeLessThan(Timestamp value) {
            addCriterion("instancelastupdatetime <", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("instancelastupdatetime <=", value, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeIn(List<Timestamp> values) {
            addCriterion("instancelastupdatetime in", values, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeNotIn(List<Timestamp> values) {
            addCriterion("instancelastupdatetime not in", values, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("instancelastupdatetime between", value1, value2, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancelastupdatetimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("instancelastupdatetime not between", value1, value2, "instancelastupdatetime");
            return (Criteria) this;
        }

        public Criteria andInstancestatusIsNull() {
            addCriterion("instancestatus is null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusIsNotNull() {
            addCriterion("instancestatus is not null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusEqualTo(Integer value) {
            addCriterion("instancestatus =", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusNotEqualTo(Integer value) {
            addCriterion("instancestatus <>", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusGreaterThan(Integer value) {
            addCriterion("instancestatus >", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("instancestatus >=", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusLessThan(Integer value) {
            addCriterion("instancestatus <", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusLessThanOrEqualTo(Integer value) {
            addCriterion("instancestatus <=", value, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusIn(List<Integer> values) {
            addCriterion("instancestatus in", values, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusNotIn(List<Integer> values) {
            addCriterion("instancestatus not in", values, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusBetween(Integer value1, Integer value2) {
            addCriterion("instancestatus between", value1, value2, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("instancestatus not between", value1, value2, "instancestatus");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerIsNull() {
            addCriterion("instancestatusbelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerIsNotNull() {
            addCriterion("instancestatusbelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerEqualTo(Long value) {
            addCriterion("instancestatusbelonger =", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerNotEqualTo(Long value) {
            addCriterion("instancestatusbelonger <>", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerGreaterThan(Long value) {
            addCriterion("instancestatusbelonger >", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instancestatusbelonger >=", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerLessThan(Long value) {
            addCriterion("instancestatusbelonger <", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerLessThanOrEqualTo(Long value) {
            addCriterion("instancestatusbelonger <=", value, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerIn(List<Long> values) {
            addCriterion("instancestatusbelonger in", values, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerNotIn(List<Long> values) {
            addCriterion("instancestatusbelonger not in", values, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerBetween(Long value1, Long value2) {
            addCriterion("instancestatusbelonger between", value1, value2, "instancestatusbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancestatusbelongerNotBetween(Long value1, Long value2) {
            addCriterion("instancestatusbelonger not between", value1, value2, "instancestatusbelonger");
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