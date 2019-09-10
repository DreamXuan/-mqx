package com.exam.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysfunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysfunctionExample() {
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

        public Criteria andFunidIsNull() {
            addCriterion("FUNID is null");
            return (Criteria) this;
        }

        public Criteria andFunidIsNotNull() {
            addCriterion("FUNID is not null");
            return (Criteria) this;
        }

        public Criteria andFunidEqualTo(Integer value) {
            addCriterion("FUNID =", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotEqualTo(Integer value) {
            addCriterion("FUNID <>", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidGreaterThan(Integer value) {
            addCriterion("FUNID >", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUNID >=", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidLessThan(Integer value) {
            addCriterion("FUNID <", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidLessThanOrEqualTo(Integer value) {
            addCriterion("FUNID <=", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidIn(List<Integer> values) {
            addCriterion("FUNID in", values, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotIn(List<Integer> values) {
            addCriterion("FUNID not in", values, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidBetween(Integer value1, Integer value2) {
            addCriterion("FUNID between", value1, value2, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotBetween(Integer value1, Integer value2) {
            addCriterion("FUNID not between", value1, value2, "funid");
            return (Criteria) this;
        }

        public Criteria andFunnameIsNull() {
            addCriterion("FUNNAME is null");
            return (Criteria) this;
        }

        public Criteria andFunnameIsNotNull() {
            addCriterion("FUNNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFunnameEqualTo(String value) {
            addCriterion("FUNNAME =", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotEqualTo(String value) {
            addCriterion("FUNNAME <>", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameGreaterThan(String value) {
            addCriterion("FUNNAME >", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameGreaterThanOrEqualTo(String value) {
            addCriterion("FUNNAME >=", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLessThan(String value) {
            addCriterion("FUNNAME <", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLessThanOrEqualTo(String value) {
            addCriterion("FUNNAME <=", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLike(String value) {
            addCriterion("FUNNAME like", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotLike(String value) {
            addCriterion("FUNNAME not like", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameIn(List<String> values) {
            addCriterion("FUNNAME in", values, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotIn(List<String> values) {
            addCriterion("FUNNAME not in", values, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameBetween(String value1, String value2) {
            addCriterion("FUNNAME between", value1, value2, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotBetween(String value1, String value2) {
            addCriterion("FUNNAME not between", value1, value2, "funname");
            return (Criteria) this;
        }

        public Criteria andFunurlIsNull() {
            addCriterion("FUNURL is null");
            return (Criteria) this;
        }

        public Criteria andFunurlIsNotNull() {
            addCriterion("FUNURL is not null");
            return (Criteria) this;
        }

        public Criteria andFunurlEqualTo(String value) {
            addCriterion("FUNURL =", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotEqualTo(String value) {
            addCriterion("FUNURL <>", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlGreaterThan(String value) {
            addCriterion("FUNURL >", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlGreaterThanOrEqualTo(String value) {
            addCriterion("FUNURL >=", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLessThan(String value) {
            addCriterion("FUNURL <", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLessThanOrEqualTo(String value) {
            addCriterion("FUNURL <=", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLike(String value) {
            addCriterion("FUNURL like", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotLike(String value) {
            addCriterion("FUNURL not like", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlIn(List<String> values) {
            addCriterion("FUNURL in", values, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotIn(List<String> values) {
            addCriterion("FUNURL not in", values, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlBetween(String value1, String value2) {
            addCriterion("FUNURL between", value1, value2, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotBetween(String value1, String value2) {
            addCriterion("FUNURL not between", value1, value2, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunpidIsNull() {
            addCriterion("FUNPID is null");
            return (Criteria) this;
        }

        public Criteria andFunpidIsNotNull() {
            addCriterion("FUNPID is not null");
            return (Criteria) this;
        }

        public Criteria andFunpidEqualTo(Integer value) {
            addCriterion("FUNPID =", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidNotEqualTo(Integer value) {
            addCriterion("FUNPID <>", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidGreaterThan(Integer value) {
            addCriterion("FUNPID >", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUNPID >=", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidLessThan(Integer value) {
            addCriterion("FUNPID <", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidLessThanOrEqualTo(Integer value) {
            addCriterion("FUNPID <=", value, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidIn(List<Integer> values) {
            addCriterion("FUNPID in", values, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidNotIn(List<Integer> values) {
            addCriterion("FUNPID not in", values, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidBetween(Integer value1, Integer value2) {
            addCriterion("FUNPID between", value1, value2, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunpidNotBetween(Integer value1, Integer value2) {
            addCriterion("FUNPID not between", value1, value2, "funpid");
            return (Criteria) this;
        }

        public Criteria andFunstateIsNull() {
            addCriterion("FUNSTATE is null");
            return (Criteria) this;
        }

        public Criteria andFunstateIsNotNull() {
            addCriterion("FUNSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andFunstateEqualTo(Integer value) {
            addCriterion("FUNSTATE =", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateNotEqualTo(Integer value) {
            addCriterion("FUNSTATE <>", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateGreaterThan(Integer value) {
            addCriterion("FUNSTATE >", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUNSTATE >=", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateLessThan(Integer value) {
            addCriterion("FUNSTATE <", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateLessThanOrEqualTo(Integer value) {
            addCriterion("FUNSTATE <=", value, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateIn(List<Integer> values) {
            addCriterion("FUNSTATE in", values, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateNotIn(List<Integer> values) {
            addCriterion("FUNSTATE not in", values, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateBetween(Integer value1, Integer value2) {
            addCriterion("FUNSTATE between", value1, value2, "funstate");
            return (Criteria) this;
        }

        public Criteria andFunstateNotBetween(Integer value1, Integer value2) {
            addCriterion("FUNSTATE not between", value1, value2, "funstate");
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