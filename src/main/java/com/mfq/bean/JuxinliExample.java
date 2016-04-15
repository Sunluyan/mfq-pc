package com.mfq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JuxinliExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JuxinliExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTaobaoIsNull() {
            addCriterion("taobao is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoIsNotNull() {
            addCriterion("taobao is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoEqualTo(String value) {
            addCriterion("taobao =", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoNotEqualTo(String value) {
            addCriterion("taobao <>", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoGreaterThan(String value) {
            addCriterion("taobao >", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoGreaterThanOrEqualTo(String value) {
            addCriterion("taobao >=", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoLessThan(String value) {
            addCriterion("taobao <", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoLessThanOrEqualTo(String value) {
            addCriterion("taobao <=", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoLike(String value) {
            addCriterion("taobao like", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoNotLike(String value) {
            addCriterion("taobao not like", value, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoIn(List<String> values) {
            addCriterion("taobao in", values, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoNotIn(List<String> values) {
            addCriterion("taobao not in", values, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoBetween(String value1, String value2) {
            addCriterion("taobao between", value1, value2, "taobao");
            return (Criteria) this;
        }

        public Criteria andTaobaoNotBetween(String value1, String value2) {
            addCriterion("taobao not between", value1, value2, "taobao");
            return (Criteria) this;
        }

        public Criteria andJdIsNull() {
            addCriterion("jd is null");
            return (Criteria) this;
        }

        public Criteria andJdIsNotNull() {
            addCriterion("jd is not null");
            return (Criteria) this;
        }

        public Criteria andJdEqualTo(String value) {
            addCriterion("jd =", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdNotEqualTo(String value) {
            addCriterion("jd <>", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdGreaterThan(String value) {
            addCriterion("jd >", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdGreaterThanOrEqualTo(String value) {
            addCriterion("jd >=", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdLessThan(String value) {
            addCriterion("jd <", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdLessThanOrEqualTo(String value) {
            addCriterion("jd <=", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdLike(String value) {
            addCriterion("jd like", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdNotLike(String value) {
            addCriterion("jd not like", value, "jd");
            return (Criteria) this;
        }

        public Criteria andJdIn(List<String> values) {
            addCriterion("jd in", values, "jd");
            return (Criteria) this;
        }

        public Criteria andJdNotIn(List<String> values) {
            addCriterion("jd not in", values, "jd");
            return (Criteria) this;
        }

        public Criteria andJdBetween(String value1, String value2) {
            addCriterion("jd between", value1, value2, "jd");
            return (Criteria) this;
        }

        public Criteria andJdNotBetween(String value1, String value2) {
            addCriterion("jd not between", value1, value2, "jd");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordIsNull() {
            addCriterion("taobao_password is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordIsNotNull() {
            addCriterion("taobao_password is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordEqualTo(String value) {
            addCriterion("taobao_password =", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordNotEqualTo(String value) {
            addCriterion("taobao_password <>", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordGreaterThan(String value) {
            addCriterion("taobao_password >", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("taobao_password >=", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordLessThan(String value) {
            addCriterion("taobao_password <", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordLessThanOrEqualTo(String value) {
            addCriterion("taobao_password <=", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordLike(String value) {
            addCriterion("taobao_password like", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordNotLike(String value) {
            addCriterion("taobao_password not like", value, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordIn(List<String> values) {
            addCriterion("taobao_password in", values, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordNotIn(List<String> values) {
            addCriterion("taobao_password not in", values, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordBetween(String value1, String value2) {
            addCriterion("taobao_password between", value1, value2, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andTaobaoPasswordNotBetween(String value1, String value2) {
            addCriterion("taobao_password not between", value1, value2, "taobaoPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordIsNull() {
            addCriterion("jd_password is null");
            return (Criteria) this;
        }

        public Criteria andJdPasswordIsNotNull() {
            addCriterion("jd_password is not null");
            return (Criteria) this;
        }

        public Criteria andJdPasswordEqualTo(String value) {
            addCriterion("jd_password =", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordNotEqualTo(String value) {
            addCriterion("jd_password <>", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordGreaterThan(String value) {
            addCriterion("jd_password >", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("jd_password >=", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordLessThan(String value) {
            addCriterion("jd_password <", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordLessThanOrEqualTo(String value) {
            addCriterion("jd_password <=", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordLike(String value) {
            addCriterion("jd_password like", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordNotLike(String value) {
            addCriterion("jd_password not like", value, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordIn(List<String> values) {
            addCriterion("jd_password in", values, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordNotIn(List<String> values) {
            addCriterion("jd_password not in", values, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordBetween(String value1, String value2) {
            addCriterion("jd_password between", value1, value2, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andJdPasswordNotBetween(String value1, String value2) {
            addCriterion("jd_password not between", value1, value2, "jdPassword");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordIsNull() {
            addCriterion("mobile_password is null");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordIsNotNull() {
            addCriterion("mobile_password is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordEqualTo(String value) {
            addCriterion("mobile_password =", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordNotEqualTo(String value) {
            addCriterion("mobile_password <>", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordGreaterThan(String value) {
            addCriterion("mobile_password >", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_password >=", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordLessThan(String value) {
            addCriterion("mobile_password <", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordLessThanOrEqualTo(String value) {
            addCriterion("mobile_password <=", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordLike(String value) {
            addCriterion("mobile_password like", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordNotLike(String value) {
            addCriterion("mobile_password not like", value, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordIn(List<String> values) {
            addCriterion("mobile_password in", values, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordNotIn(List<String> values) {
            addCriterion("mobile_password not in", values, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordBetween(String value1, String value2) {
            addCriterion("mobile_password between", value1, value2, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andMobilePasswordNotBetween(String value1, String value2) {
            addCriterion("mobile_password not between", value1, value2, "mobilePassword");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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