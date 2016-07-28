package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceBaseconfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceBaseconfigCriteria() {
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

        public Criteria andInstancebaseconfigidIsNull() {
            addCriterion("instancebaseconfigid is null");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidIsNotNull() {
            addCriterion("instancebaseconfigid is not null");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidEqualTo(Long value) {
            addCriterion("instancebaseconfigid =", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidNotEqualTo(Long value) {
            addCriterion("instancebaseconfigid <>", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidGreaterThan(Long value) {
            addCriterion("instancebaseconfigid >", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidGreaterThanOrEqualTo(Long value) {
            addCriterion("instancebaseconfigid >=", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidLessThan(Long value) {
            addCriterion("instancebaseconfigid <", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidLessThanOrEqualTo(Long value) {
            addCriterion("instancebaseconfigid <=", value, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidIn(List<Long> values) {
            addCriterion("instancebaseconfigid in", values, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidNotIn(List<Long> values) {
            addCriterion("instancebaseconfigid not in", values, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidBetween(Long value1, Long value2) {
            addCriterion("instancebaseconfigid between", value1, value2, "instancebaseconfigid");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigidNotBetween(Long value1, Long value2) {
            addCriterion("instancebaseconfigid not between", value1, value2, "instancebaseconfigid");
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

        public Criteria andInstancedatapathIsNull() {
            addCriterion("instancedatapath is null");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathIsNotNull() {
            addCriterion("instancedatapath is not null");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathEqualTo(String value) {
            addCriterion("instancedatapath =", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathNotEqualTo(String value) {
            addCriterion("instancedatapath <>", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathGreaterThan(String value) {
            addCriterion("instancedatapath >", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathGreaterThanOrEqualTo(String value) {
            addCriterion("instancedatapath >=", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathLessThan(String value) {
            addCriterion("instancedatapath <", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathLessThanOrEqualTo(String value) {
            addCriterion("instancedatapath <=", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathLike(String value) {
            addCriterion("instancedatapath like", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathNotLike(String value) {
            addCriterion("instancedatapath not like", value, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathIn(List<String> values) {
            addCriterion("instancedatapath in", values, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathNotIn(List<String> values) {
            addCriterion("instancedatapath not in", values, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathBetween(String value1, String value2) {
            addCriterion("instancedatapath between", value1, value2, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancedatapathNotBetween(String value1, String value2) {
            addCriterion("instancedatapath not between", value1, value2, "instancedatapath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathIsNull() {
            addCriterion("instancehomepath is null");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathIsNotNull() {
            addCriterion("instancehomepath is not null");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathEqualTo(String value) {
            addCriterion("instancehomepath =", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathNotEqualTo(String value) {
            addCriterion("instancehomepath <>", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathGreaterThan(String value) {
            addCriterion("instancehomepath >", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathGreaterThanOrEqualTo(String value) {
            addCriterion("instancehomepath >=", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathLessThan(String value) {
            addCriterion("instancehomepath <", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathLessThanOrEqualTo(String value) {
            addCriterion("instancehomepath <=", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathLike(String value) {
            addCriterion("instancehomepath like", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathNotLike(String value) {
            addCriterion("instancehomepath not like", value, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathIn(List<String> values) {
            addCriterion("instancehomepath in", values, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathNotIn(List<String> values) {
            addCriterion("instancehomepath not in", values, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathBetween(String value1, String value2) {
            addCriterion("instancehomepath between", value1, value2, "instancehomepath");
            return (Criteria) this;
        }

        public Criteria andInstancehomepathNotBetween(String value1, String value2) {
            addCriterion("instancehomepath not between", value1, value2, "instancehomepath");
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

        public Criteria andIpwhitelistIsNull() {
            addCriterion("ipwhitelist is null");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistIsNotNull() {
            addCriterion("ipwhitelist is not null");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistEqualTo(String value) {
            addCriterion("ipwhitelist =", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistNotEqualTo(String value) {
            addCriterion("ipwhitelist <>", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistGreaterThan(String value) {
            addCriterion("ipwhitelist >", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistGreaterThanOrEqualTo(String value) {
            addCriterion("ipwhitelist >=", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistLessThan(String value) {
            addCriterion("ipwhitelist <", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistLessThanOrEqualTo(String value) {
            addCriterion("ipwhitelist <=", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistLike(String value) {
            addCriterion("ipwhitelist like", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistNotLike(String value) {
            addCriterion("ipwhitelist not like", value, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistIn(List<String> values) {
            addCriterion("ipwhitelist in", values, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistNotIn(List<String> values) {
            addCriterion("ipwhitelist not in", values, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistBetween(String value1, String value2) {
            addCriterion("ipwhitelist between", value1, value2, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andIpwhitelistNotBetween(String value1, String value2) {
            addCriterion("ipwhitelist not between", value1, value2, "ipwhitelist");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerIsNull() {
            addCriterion("instancebaseconfigbelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerIsNotNull() {
            addCriterion("instancebaseconfigbelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerEqualTo(Long value) {
            addCriterion("instancebaseconfigbelonger =", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerNotEqualTo(Long value) {
            addCriterion("instancebaseconfigbelonger <>", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerGreaterThan(Long value) {
            addCriterion("instancebaseconfigbelonger >", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instancebaseconfigbelonger >=", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerLessThan(Long value) {
            addCriterion("instancebaseconfigbelonger <", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerLessThanOrEqualTo(Long value) {
            addCriterion("instancebaseconfigbelonger <=", value, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerIn(List<Long> values) {
            addCriterion("instancebaseconfigbelonger in", values, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerNotIn(List<Long> values) {
            addCriterion("instancebaseconfigbelonger not in", values, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerBetween(Long value1, Long value2) {
            addCriterion("instancebaseconfigbelonger between", value1, value2, "instancebaseconfigbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancebaseconfigbelongerNotBetween(Long value1, Long value2) {
            addCriterion("instancebaseconfigbelonger not between", value1, value2, "instancebaseconfigbelonger");
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