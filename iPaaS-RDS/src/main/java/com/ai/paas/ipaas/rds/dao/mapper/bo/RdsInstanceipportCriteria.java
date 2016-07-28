package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceipportCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceipportCriteria() {
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

        public Criteria andInstanceipportidIsNull() {
            addCriterion("instanceipportid is null");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidIsNotNull() {
            addCriterion("instanceipportid is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidEqualTo(Long value) {
            addCriterion("instanceipportid =", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidNotEqualTo(Long value) {
            addCriterion("instanceipportid <>", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidGreaterThan(Long value) {
            addCriterion("instanceipportid >", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidGreaterThanOrEqualTo(Long value) {
            addCriterion("instanceipportid >=", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidLessThan(Long value) {
            addCriterion("instanceipportid <", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidLessThanOrEqualTo(Long value) {
            addCriterion("instanceipportid <=", value, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidIn(List<Long> values) {
            addCriterion("instanceipportid in", values, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidNotIn(List<Long> values) {
            addCriterion("instanceipportid not in", values, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidBetween(Long value1, Long value2) {
            addCriterion("instanceipportid between", value1, value2, "instanceipportid");
            return (Criteria) this;
        }

        public Criteria andInstanceipportidNotBetween(Long value1, Long value2) {
            addCriterion("instanceipportid not between", value1, value2, "instanceipportid");
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

        public Criteria andInstanceipIsNull() {
            addCriterion("instanceip is null");
            return (Criteria) this;
        }

        public Criteria andInstanceipIsNotNull() {
            addCriterion("instanceip is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceipEqualTo(String value) {
            addCriterion("instanceip =", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipNotEqualTo(String value) {
            addCriterion("instanceip <>", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipGreaterThan(String value) {
            addCriterion("instanceip >", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipGreaterThanOrEqualTo(String value) {
            addCriterion("instanceip >=", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipLessThan(String value) {
            addCriterion("instanceip <", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipLessThanOrEqualTo(String value) {
            addCriterion("instanceip <=", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipLike(String value) {
            addCriterion("instanceip like", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipNotLike(String value) {
            addCriterion("instanceip not like", value, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipIn(List<String> values) {
            addCriterion("instanceip in", values, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipNotIn(List<String> values) {
            addCriterion("instanceip not in", values, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipBetween(String value1, String value2) {
            addCriterion("instanceip between", value1, value2, "instanceip");
            return (Criteria) this;
        }

        public Criteria andInstanceipNotBetween(String value1, String value2) {
            addCriterion("instanceip not between", value1, value2, "instanceip");
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

        public Criteria andInstanceurlIsNull() {
            addCriterion("instanceurl is null");
            return (Criteria) this;
        }

        public Criteria andInstanceurlIsNotNull() {
            addCriterion("instanceurl is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceurlEqualTo(String value) {
            addCriterion("instanceurl =", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlNotEqualTo(String value) {
            addCriterion("instanceurl <>", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlGreaterThan(String value) {
            addCriterion("instanceurl >", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlGreaterThanOrEqualTo(String value) {
            addCriterion("instanceurl >=", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlLessThan(String value) {
            addCriterion("instanceurl <", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlLessThanOrEqualTo(String value) {
            addCriterion("instanceurl <=", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlLike(String value) {
            addCriterion("instanceurl like", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlNotLike(String value) {
            addCriterion("instanceurl not like", value, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlIn(List<String> values) {
            addCriterion("instanceurl in", values, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlNotIn(List<String> values) {
            addCriterion("instanceurl not in", values, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlBetween(String value1, String value2) {
            addCriterion("instanceurl between", value1, value2, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andInstanceurlNotBetween(String value1, String value2) {
            addCriterion("instanceurl not between", value1, value2, "instanceurl");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerIsNull() {
            addCriterion("instanceipportbelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerIsNotNull() {
            addCriterion("instanceipportbelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerEqualTo(Long value) {
            addCriterion("instanceipportbelonger =", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerNotEqualTo(Long value) {
            addCriterion("instanceipportbelonger <>", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerGreaterThan(Long value) {
            addCriterion("instanceipportbelonger >", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instanceipportbelonger >=", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerLessThan(Long value) {
            addCriterion("instanceipportbelonger <", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerLessThanOrEqualTo(Long value) {
            addCriterion("instanceipportbelonger <=", value, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerIn(List<Long> values) {
            addCriterion("instanceipportbelonger in", values, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerNotIn(List<Long> values) {
            addCriterion("instanceipportbelonger not in", values, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerBetween(Long value1, Long value2) {
            addCriterion("instanceipportbelonger between", value1, value2, "instanceipportbelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceipportbelongerNotBetween(Long value1, Long value2) {
            addCriterion("instanceipportbelonger not between", value1, value2, "instanceipportbelonger");
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