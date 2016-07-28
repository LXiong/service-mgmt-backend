package com.ai.paas.ipaas.rds.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RdsInstanceBaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public RdsInstanceBaseCriteria() {
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

        public Criteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (Criteria) this;
        }

        public Criteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceidEqualTo(Long value) {
            addCriterion("instanceid =", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotEqualTo(Long value) {
            addCriterion("instanceid <>", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThan(Long value) {
            addCriterion("instanceid >", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThanOrEqualTo(Long value) {
            addCriterion("instanceid >=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThan(Long value) {
            addCriterion("instanceid <", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThanOrEqualTo(Long value) {
            addCriterion("instanceid <=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidIn(List<Long> values) {
            addCriterion("instanceid in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotIn(List<Long> values) {
            addCriterion("instanceid not in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidBetween(Long value1, Long value2) {
            addCriterion("instanceid between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotBetween(Long value1, Long value2) {
            addCriterion("instanceid not between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryIsNull() {
            addCriterion("instancecategory is null");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryIsNotNull() {
            addCriterion("instancecategory is not null");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryEqualTo(String value) {
            addCriterion("instancecategory =", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryNotEqualTo(String value) {
            addCriterion("instancecategory <>", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryGreaterThan(String value) {
            addCriterion("instancecategory >", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryGreaterThanOrEqualTo(String value) {
            addCriterion("instancecategory >=", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryLessThan(String value) {
            addCriterion("instancecategory <", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryLessThanOrEqualTo(String value) {
            addCriterion("instancecategory <=", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryLike(String value) {
            addCriterion("instancecategory like", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryNotLike(String value) {
            addCriterion("instancecategory not like", value, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryIn(List<String> values) {
            addCriterion("instancecategory in", values, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryNotIn(List<String> values) {
            addCriterion("instancecategory not in", values, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryBetween(String value1, String value2) {
            addCriterion("instancecategory between", value1, value2, "instancecategory");
            return (Criteria) this;
        }

        public Criteria andInstancecategoryNotBetween(String value1, String value2) {
            addCriterion("instancecategory not between", value1, value2, "instancecategory");
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

        public Criteria andInstancelocationIsNull() {
            addCriterion("instancelocation is null");
            return (Criteria) this;
        }

        public Criteria andInstancelocationIsNotNull() {
            addCriterion("instancelocation is not null");
            return (Criteria) this;
        }

        public Criteria andInstancelocationEqualTo(String value) {
            addCriterion("instancelocation =", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationNotEqualTo(String value) {
            addCriterion("instancelocation <>", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationGreaterThan(String value) {
            addCriterion("instancelocation >", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationGreaterThanOrEqualTo(String value) {
            addCriterion("instancelocation >=", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationLessThan(String value) {
            addCriterion("instancelocation <", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationLessThanOrEqualTo(String value) {
            addCriterion("instancelocation <=", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationLike(String value) {
            addCriterion("instancelocation like", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationNotLike(String value) {
            addCriterion("instancelocation not like", value, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationIn(List<String> values) {
            addCriterion("instancelocation in", values, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationNotIn(List<String> values) {
            addCriterion("instancelocation not in", values, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationBetween(String value1, String value2) {
            addCriterion("instancelocation between", value1, value2, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancelocationNotBetween(String value1, String value2) {
            addCriterion("instancelocation not between", value1, value2, "instancelocation");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryIsNull() {
            addCriterion("instancemysqlcategory is null");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryIsNotNull() {
            addCriterion("instancemysqlcategory is not null");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryEqualTo(String value) {
            addCriterion("instancemysqlcategory =", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryNotEqualTo(String value) {
            addCriterion("instancemysqlcategory <>", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryGreaterThan(String value) {
            addCriterion("instancemysqlcategory >", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("instancemysqlcategory >=", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryLessThan(String value) {
            addCriterion("instancemysqlcategory <", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryLessThanOrEqualTo(String value) {
            addCriterion("instancemysqlcategory <=", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryLike(String value) {
            addCriterion("instancemysqlcategory like", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryNotLike(String value) {
            addCriterion("instancemysqlcategory not like", value, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryIn(List<String> values) {
            addCriterion("instancemysqlcategory in", values, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryNotIn(List<String> values) {
            addCriterion("instancemysqlcategory not in", values, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryBetween(String value1, String value2) {
            addCriterion("instancemysqlcategory between", value1, value2, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancemysqlcategoryNotBetween(String value1, String value2) {
            addCriterion("instancemysqlcategory not between", value1, value2, "instancemysqlcategory");
            return (Criteria) this;
        }

        public Criteria andInstancenameIsNull() {
            addCriterion("instancename is null");
            return (Criteria) this;
        }

        public Criteria andInstancenameIsNotNull() {
            addCriterion("instancename is not null");
            return (Criteria) this;
        }

        public Criteria andInstancenameEqualTo(String value) {
            addCriterion("instancename =", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameNotEqualTo(String value) {
            addCriterion("instancename <>", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameGreaterThan(String value) {
            addCriterion("instancename >", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameGreaterThanOrEqualTo(String value) {
            addCriterion("instancename >=", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameLessThan(String value) {
            addCriterion("instancename <", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameLessThanOrEqualTo(String value) {
            addCriterion("instancename <=", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameLike(String value) {
            addCriterion("instancename like", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameNotLike(String value) {
            addCriterion("instancename not like", value, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameIn(List<String> values) {
            addCriterion("instancename in", values, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameNotIn(List<String> values) {
            addCriterion("instancename not in", values, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameBetween(String value1, String value2) {
            addCriterion("instancename between", value1, value2, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenameNotBetween(String value1, String value2) {
            addCriterion("instancename not between", value1, value2, "instancename");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeIsNull() {
            addCriterion("instancenetworktype is null");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeIsNotNull() {
            addCriterion("instancenetworktype is not null");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeEqualTo(Integer value) {
            addCriterion("instancenetworktype =", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeNotEqualTo(Integer value) {
            addCriterion("instancenetworktype <>", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeGreaterThan(Integer value) {
            addCriterion("instancenetworktype >", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("instancenetworktype >=", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeLessThan(Integer value) {
            addCriterion("instancenetworktype <", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeLessThanOrEqualTo(Integer value) {
            addCriterion("instancenetworktype <=", value, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeIn(List<Integer> values) {
            addCriterion("instancenetworktype in", values, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeNotIn(List<Integer> values) {
            addCriterion("instancenetworktype not in", values, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeBetween(Integer value1, Integer value2) {
            addCriterion("instancenetworktype between", value1, value2, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancenetworktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("instancenetworktype not between", value1, value2, "instancenetworktype");
            return (Criteria) this;
        }

        public Criteria andInstancetagIsNull() {
            addCriterion("instancetag is null");
            return (Criteria) this;
        }

        public Criteria andInstancetagIsNotNull() {
            addCriterion("instancetag is not null");
            return (Criteria) this;
        }

        public Criteria andInstancetagEqualTo(String value) {
            addCriterion("instancetag =", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagNotEqualTo(String value) {
            addCriterion("instancetag <>", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagGreaterThan(String value) {
            addCriterion("instancetag >", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagGreaterThanOrEqualTo(String value) {
            addCriterion("instancetag >=", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagLessThan(String value) {
            addCriterion("instancetag <", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagLessThanOrEqualTo(String value) {
            addCriterion("instancetag <=", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagLike(String value) {
            addCriterion("instancetag like", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagNotLike(String value) {
            addCriterion("instancetag not like", value, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagIn(List<String> values) {
            addCriterion("instancetag in", values, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagNotIn(List<String> values) {
            addCriterion("instancetag not in", values, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagBetween(String value1, String value2) {
            addCriterion("instancetag between", value1, value2, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstancetagNotBetween(String value1, String value2) {
            addCriterion("instancetag not between", value1, value2, "instancetag");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeIsNull() {
            addCriterion("instanceusetype is null");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeIsNotNull() {
            addCriterion("instanceusetype is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeEqualTo(String value) {
            addCriterion("instanceusetype =", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeNotEqualTo(String value) {
            addCriterion("instanceusetype <>", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeGreaterThan(String value) {
            addCriterion("instanceusetype >", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeGreaterThanOrEqualTo(String value) {
            addCriterion("instanceusetype >=", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeLessThan(String value) {
            addCriterion("instanceusetype <", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeLessThanOrEqualTo(String value) {
            addCriterion("instanceusetype <=", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeLike(String value) {
            addCriterion("instanceusetype like", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeNotLike(String value) {
            addCriterion("instanceusetype not like", value, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeIn(List<String> values) {
            addCriterion("instanceusetype in", values, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeNotIn(List<String> values) {
            addCriterion("instanceusetype not in", values, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeBetween(String value1, String value2) {
            addCriterion("instanceusetype between", value1, value2, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andInstanceusetypeNotBetween(String value1, String value2) {
            addCriterion("instanceusetype not between", value1, value2, "instanceusetype");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerIsNull() {
            addCriterion("instanceimagebelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerIsNotNull() {
            addCriterion("instanceimagebelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerEqualTo(Long value) {
            addCriterion("instanceimagebelonger =", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerNotEqualTo(Long value) {
            addCriterion("instanceimagebelonger <>", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerGreaterThan(Long value) {
            addCriterion("instanceimagebelonger >", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instanceimagebelonger >=", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerLessThan(Long value) {
            addCriterion("instanceimagebelonger <", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerLessThanOrEqualTo(Long value) {
            addCriterion("instanceimagebelonger <=", value, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerIn(List<Long> values) {
            addCriterion("instanceimagebelonger in", values, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerNotIn(List<Long> values) {
            addCriterion("instanceimagebelonger not in", values, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerBetween(Long value1, Long value2) {
            addCriterion("instanceimagebelonger between", value1, value2, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceimagebelongerNotBetween(Long value1, Long value2) {
            addCriterion("instanceimagebelonger not between", value1, value2, "instanceimagebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerIsNull() {
            addCriterion("instanceresourcebelonger is null");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerIsNotNull() {
            addCriterion("instanceresourcebelonger is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerEqualTo(Long value) {
            addCriterion("instanceresourcebelonger =", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerNotEqualTo(Long value) {
            addCriterion("instanceresourcebelonger <>", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerGreaterThan(Long value) {
            addCriterion("instanceresourcebelonger >", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerGreaterThanOrEqualTo(Long value) {
            addCriterion("instanceresourcebelonger >=", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerLessThan(Long value) {
            addCriterion("instanceresourcebelonger <", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerLessThanOrEqualTo(Long value) {
            addCriterion("instanceresourcebelonger <=", value, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerIn(List<Long> values) {
            addCriterion("instanceresourcebelonger in", values, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerNotIn(List<Long> values) {
            addCriterion("instanceresourcebelonger not in", values, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerBetween(Long value1, Long value2) {
            addCriterion("instanceresourcebelonger between", value1, value2, "instanceresourcebelonger");
            return (Criteria) this;
        }

        public Criteria andInstanceresourcebelongerNotBetween(Long value1, Long value2) {
            addCriterion("instanceresourcebelonger not between", value1, value2, "instanceresourcebelonger");
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