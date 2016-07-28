package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceRootaccountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceRootaccountCriteria() {
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

        public Criteria andInstancerootaccountidIsNull() {
            addCriterion("instancerootaccountid is null");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidIsNotNull() {
            addCriterion("instancerootaccountid is not null");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidEqualTo(Long value) {
            addCriterion("instancerootaccountid =", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidNotEqualTo(Long value) {
            addCriterion("instancerootaccountid <>", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidGreaterThan(Long value) {
            addCriterion("instancerootaccountid >", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidGreaterThanOrEqualTo(Long value) {
            addCriterion("instancerootaccountid >=", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidLessThan(Long value) {
            addCriterion("instancerootaccountid <", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidLessThanOrEqualTo(Long value) {
            addCriterion("instancerootaccountid <=", value, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidIn(List<Long> values) {
            addCriterion("instancerootaccountid in", values, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidNotIn(List<Long> values) {
            addCriterion("instancerootaccountid not in", values, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidBetween(Long value1, Long value2) {
            addCriterion("instancerootaccountid between", value1, value2, "instancerootaccountid");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountidNotBetween(Long value1, Long value2) {
            addCriterion("instancerootaccountid not between", value1, value2, "instancerootaccountid");
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

        public Criteria andRootaccoutIsNull() {
            addCriterion("rootaccout is null");
            return (Criteria) this;
        }

        public Criteria andRootaccoutIsNotNull() {
            addCriterion("rootaccout is not null");
            return (Criteria) this;
        }

        public Criteria andRootaccoutEqualTo(String value) {
            addCriterion("rootaccout =", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutNotEqualTo(String value) {
            addCriterion("rootaccout <>", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutGreaterThan(String value) {
            addCriterion("rootaccout >", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutGreaterThanOrEqualTo(String value) {
            addCriterion("rootaccout >=", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutLessThan(String value) {
            addCriterion("rootaccout <", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutLessThanOrEqualTo(String value) {
            addCriterion("rootaccout <=", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutLike(String value) {
            addCriterion("rootaccout like", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutNotLike(String value) {
            addCriterion("rootaccout not like", value, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutIn(List<String> values) {
            addCriterion("rootaccout in", values, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutNotIn(List<String> values) {
            addCriterion("rootaccout not in", values, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutBetween(String value1, String value2) {
            addCriterion("rootaccout between", value1, value2, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootaccoutNotBetween(String value1, String value2) {
            addCriterion("rootaccout not between", value1, value2, "rootaccout");
            return (Criteria) this;
        }

        public Criteria andRootpasswordIsNull() {
            addCriterion("rootpassword is null");
            return (Criteria) this;
        }

        public Criteria andRootpasswordIsNotNull() {
            addCriterion("rootpassword is not null");
            return (Criteria) this;
        }

        public Criteria andRootpasswordEqualTo(String value) {
            addCriterion("rootpassword =", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordNotEqualTo(String value) {
            addCriterion("rootpassword <>", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordGreaterThan(String value) {
            addCriterion("rootpassword >", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("rootpassword >=", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordLessThan(String value) {
            addCriterion("rootpassword <", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordLessThanOrEqualTo(String value) {
            addCriterion("rootpassword <=", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordLike(String value) {
            addCriterion("rootpassword like", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordNotLike(String value) {
            addCriterion("rootpassword not like", value, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordIn(List<String> values) {
            addCriterion("rootpassword in", values, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordNotIn(List<String> values) {
            addCriterion("rootpassword not in", values, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordBetween(String value1, String value2) {
            addCriterion("rootpassword between", value1, value2, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andRootpasswordNotBetween(String value1, String value2) {
            addCriterion("rootpassword not between", value1, value2, "rootpassword");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerIsNull() {
            addCriterion("instancerootaccountbelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerIsNotNull() {
            addCriterion("instancerootaccountbelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerEqualTo(Long value) {
            addCriterion("instancerootaccountbelonger =", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerNotEqualTo(Long value) {
            addCriterion("instancerootaccountbelonger <>", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerGreaterThan(Long value) {
            addCriterion("instancerootaccountbelonger >", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instancerootaccountbelonger >=", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerLessThan(Long value) {
            addCriterion("instancerootaccountbelonger <", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerLessThanOrEqualTo(Long value) {
            addCriterion("instancerootaccountbelonger <=", value, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerIn(List<Long> values) {
            addCriterion("instancerootaccountbelonger in", values, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerNotIn(List<Long> values) {
            addCriterion("instancerootaccountbelonger not in", values, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerBetween(Long value1, Long value2) {
            addCriterion("instancerootaccountbelonger between", value1, value2, "instancerootaccountbelonger");
            return (Criteria) this;
        }

        public Criteria andInstancerootaccountbelongerNotBetween(Long value1, Long value2) {
            addCriterion("instancerootaccountbelonger not between", value1, value2, "instancerootaccountbelonger");
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