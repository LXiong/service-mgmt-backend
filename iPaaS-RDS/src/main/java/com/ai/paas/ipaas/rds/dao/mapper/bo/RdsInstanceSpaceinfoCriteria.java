package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceSpaceinfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceSpaceinfoCriteria() {
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

        public Criteria andInstancespaceinfoidIsNull() {
            addCriterion("instancespaceinfoid is null");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidIsNotNull() {
            addCriterion("instancespaceinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidEqualTo(Long value) {
            addCriterion("instancespaceinfoid =", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidNotEqualTo(Long value) {
            addCriterion("instancespaceinfoid <>", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidGreaterThan(Long value) {
            addCriterion("instancespaceinfoid >", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidGreaterThanOrEqualTo(Long value) {
            addCriterion("instancespaceinfoid >=", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidLessThan(Long value) {
            addCriterion("instancespaceinfoid <", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidLessThanOrEqualTo(Long value) {
            addCriterion("instancespaceinfoid <=", value, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidIn(List<Long> values) {
            addCriterion("instancespaceinfoid in", values, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidNotIn(List<Long> values) {
            addCriterion("instancespaceinfoid not in", values, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidBetween(Long value1, Long value2) {
            addCriterion("instancespaceinfoid between", value1, value2, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfoidNotBetween(Long value1, Long value2) {
            addCriterion("instancespaceinfoid not between", value1, value2, "instancespaceinfoid");
            return (Criteria) this;
        }

        public Criteria andCpuIsNull() {
            addCriterion("cpu is null");
            return (Criteria) this;
        }

        public Criteria andCpuIsNotNull() {
            addCriterion("cpu is not null");
            return (Criteria) this;
        }

        public Criteria andCpuEqualTo(String value) {
            addCriterion("cpu =", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotEqualTo(String value) {
            addCriterion("cpu <>", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThan(String value) {
            addCriterion("cpu >", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThanOrEqualTo(String value) {
            addCriterion("cpu >=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThan(String value) {
            addCriterion("cpu <", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThanOrEqualTo(String value) {
            addCriterion("cpu <=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLike(String value) {
            addCriterion("cpu like", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotLike(String value) {
            addCriterion("cpu not like", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuIn(List<String> values) {
            addCriterion("cpu in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotIn(List<String> values) {
            addCriterion("cpu not in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuBetween(String value1, String value2) {
            addCriterion("cpu between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotBetween(String value1, String value2) {
            addCriterion("cpu not between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andDbversionIsNull() {
            addCriterion("dbversion is null");
            return (Criteria) this;
        }

        public Criteria andDbversionIsNotNull() {
            addCriterion("dbversion is not null");
            return (Criteria) this;
        }

        public Criteria andDbversionEqualTo(String value) {
            addCriterion("dbversion =", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionNotEqualTo(String value) {
            addCriterion("dbversion <>", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionGreaterThan(String value) {
            addCriterion("dbversion >", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionGreaterThanOrEqualTo(String value) {
            addCriterion("dbversion >=", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionLessThan(String value) {
            addCriterion("dbversion <", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionLessThanOrEqualTo(String value) {
            addCriterion("dbversion <=", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionLike(String value) {
            addCriterion("dbversion like", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionNotLike(String value) {
            addCriterion("dbversion not like", value, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionIn(List<String> values) {
            addCriterion("dbversion in", values, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionNotIn(List<String> values) {
            addCriterion("dbversion not in", values, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionBetween(String value1, String value2) {
            addCriterion("dbversion between", value1, value2, "dbversion");
            return (Criteria) this;
        }

        public Criteria andDbversionNotBetween(String value1, String value2) {
            addCriterion("dbversion not between", value1, value2, "dbversion");
            return (Criteria) this;
        }

        public Criteria andExternalstorageIsNull() {
            addCriterion("externalstorage is null");
            return (Criteria) this;
        }

        public Criteria andExternalstorageIsNotNull() {
            addCriterion("externalstorage is not null");
            return (Criteria) this;
        }

        public Criteria andExternalstorageEqualTo(Double value) {
            addCriterion("externalstorage =", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageNotEqualTo(Double value) {
            addCriterion("externalstorage <>", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageGreaterThan(Double value) {
            addCriterion("externalstorage >", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageGreaterThanOrEqualTo(Double value) {
            addCriterion("externalstorage >=", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageLessThan(Double value) {
            addCriterion("externalstorage <", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageLessThanOrEqualTo(Double value) {
            addCriterion("externalstorage <=", value, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageIn(List<Double> values) {
            addCriterion("externalstorage in", values, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageNotIn(List<Double> values) {
            addCriterion("externalstorage not in", values, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageBetween(Double value1, Double value2) {
            addCriterion("externalstorage between", value1, value2, "externalstorage");
            return (Criteria) this;
        }

        public Criteria andExternalstorageNotBetween(Double value1, Double value2) {
            addCriterion("externalstorage not between", value1, value2, "externalstorage");
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

        public Criteria andInternalstorageIsNull() {
            addCriterion("internalstorage is null");
            return (Criteria) this;
        }

        public Criteria andInternalstorageIsNotNull() {
            addCriterion("internalstorage is not null");
            return (Criteria) this;
        }

        public Criteria andInternalstorageEqualTo(Double value) {
            addCriterion("internalstorage =", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageNotEqualTo(Double value) {
            addCriterion("internalstorage <>", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageGreaterThan(Double value) {
            addCriterion("internalstorage >", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageGreaterThanOrEqualTo(Double value) {
            addCriterion("internalstorage >=", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageLessThan(Double value) {
            addCriterion("internalstorage <", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageLessThanOrEqualTo(Double value) {
            addCriterion("internalstorage <=", value, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageIn(List<Double> values) {
            addCriterion("internalstorage in", values, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageNotIn(List<Double> values) {
            addCriterion("internalstorage not in", values, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageBetween(Double value1, Double value2) {
            addCriterion("internalstorage between", value1, value2, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andInternalstorageNotBetween(Double value1, Double value2) {
            addCriterion("internalstorage not between", value1, value2, "internalstorage");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberIsNull() {
            addCriterion("maxconnectnumber is null");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberIsNotNull() {
            addCriterion("maxconnectnumber is not null");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberEqualTo(Integer value) {
            addCriterion("maxconnectnumber =", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberNotEqualTo(Integer value) {
            addCriterion("maxconnectnumber <>", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberGreaterThan(Integer value) {
            addCriterion("maxconnectnumber >", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxconnectnumber >=", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberLessThan(Integer value) {
            addCriterion("maxconnectnumber <", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberLessThanOrEqualTo(Integer value) {
            addCriterion("maxconnectnumber <=", value, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberIn(List<Integer> values) {
            addCriterion("maxconnectnumber in", values, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberNotIn(List<Integer> values) {
            addCriterion("maxconnectnumber not in", values, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberBetween(Integer value1, Integer value2) {
            addCriterion("maxconnectnumber between", value1, value2, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxconnectnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("maxconnectnumber not between", value1, value2, "maxconnectnumber");
            return (Criteria) this;
        }

        public Criteria andMaxiopsIsNull() {
            addCriterion("maxiops is null");
            return (Criteria) this;
        }

        public Criteria andMaxiopsIsNotNull() {
            addCriterion("maxiops is not null");
            return (Criteria) this;
        }

        public Criteria andMaxiopsEqualTo(String value) {
            addCriterion("maxiops =", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsNotEqualTo(String value) {
            addCriterion("maxiops <>", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsGreaterThan(String value) {
            addCriterion("maxiops >", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsGreaterThanOrEqualTo(String value) {
            addCriterion("maxiops >=", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsLessThan(String value) {
            addCriterion("maxiops <", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsLessThanOrEqualTo(String value) {
            addCriterion("maxiops <=", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsLike(String value) {
            addCriterion("maxiops like", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsNotLike(String value) {
            addCriterion("maxiops not like", value, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsIn(List<String> values) {
            addCriterion("maxiops in", values, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsNotIn(List<String> values) {
            addCriterion("maxiops not in", values, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsBetween(String value1, String value2) {
            addCriterion("maxiops between", value1, value2, "maxiops");
            return (Criteria) this;
        }

        public Criteria andMaxiopsNotBetween(String value1, String value2) {
            addCriterion("maxiops not between", value1, value2, "maxiops");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageIsNull() {
            addCriterion("usedexternalstorage is null");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageIsNotNull() {
            addCriterion("usedexternalstorage is not null");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageEqualTo(Double value) {
            addCriterion("usedexternalstorage =", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageNotEqualTo(Double value) {
            addCriterion("usedexternalstorage <>", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageGreaterThan(Double value) {
            addCriterion("usedexternalstorage >", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageGreaterThanOrEqualTo(Double value) {
            addCriterion("usedexternalstorage >=", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageLessThan(Double value) {
            addCriterion("usedexternalstorage <", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageLessThanOrEqualTo(Double value) {
            addCriterion("usedexternalstorage <=", value, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageIn(List<Double> values) {
            addCriterion("usedexternalstorage in", values, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageNotIn(List<Double> values) {
            addCriterion("usedexternalstorage not in", values, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageBetween(Double value1, Double value2) {
            addCriterion("usedexternalstorage between", value1, value2, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedexternalstorageNotBetween(Double value1, Double value2) {
            addCriterion("usedexternalstorage not between", value1, value2, "usedexternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageIsNull() {
            addCriterion("usedinternalstorage is null");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageIsNotNull() {
            addCriterion("usedinternalstorage is not null");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageEqualTo(Double value) {
            addCriterion("usedinternalstorage =", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageNotEqualTo(Double value) {
            addCriterion("usedinternalstorage <>", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageGreaterThan(Double value) {
            addCriterion("usedinternalstorage >", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageGreaterThanOrEqualTo(Double value) {
            addCriterion("usedinternalstorage >=", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageLessThan(Double value) {
            addCriterion("usedinternalstorage <", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageLessThanOrEqualTo(Double value) {
            addCriterion("usedinternalstorage <=", value, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageIn(List<Double> values) {
            addCriterion("usedinternalstorage in", values, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageNotIn(List<Double> values) {
            addCriterion("usedinternalstorage not in", values, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageBetween(Double value1, Double value2) {
            addCriterion("usedinternalstorage between", value1, value2, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andUsedinternalstorageNotBetween(Double value1, Double value2) {
            addCriterion("usedinternalstorage not between", value1, value2, "usedinternalstorage");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerIsNull() {
            addCriterion("instancespaceinfobelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerIsNotNull() {
            addCriterion("instancespaceinfobelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerEqualTo(Long value) {
            addCriterion("instancespaceinfobelonger =", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerNotEqualTo(Long value) {
            addCriterion("instancespaceinfobelonger <>", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerGreaterThan(Long value) {
            addCriterion("instancespaceinfobelonger >", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instancespaceinfobelonger >=", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerLessThan(Long value) {
            addCriterion("instancespaceinfobelonger <", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerLessThanOrEqualTo(Long value) {
            addCriterion("instancespaceinfobelonger <=", value, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerIn(List<Long> values) {
            addCriterion("instancespaceinfobelonger in", values, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerNotIn(List<Long> values) {
            addCriterion("instancespaceinfobelonger not in", values, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerBetween(Long value1, Long value2) {
            addCriterion("instancespaceinfobelonger between", value1, value2, "instancespaceinfobelonger");
            return (Criteria) this;
        }

        public Criteria andInstancespaceinfobelongerNotBetween(Long value1, Long value2) {
            addCriterion("instancespaceinfobelonger not between", value1, value2, "instancespaceinfobelonger");
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