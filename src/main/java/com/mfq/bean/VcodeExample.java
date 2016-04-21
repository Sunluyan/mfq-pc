package com.mfq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VcodeExample() {
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

        public Criteria andVcodeIsNull() {
            addCriterion("vcode is null");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNotNull() {
            addCriterion("vcode is not null");
            return (Criteria) this;
        }

        public Criteria andVcodeEqualTo(String value) {
            addCriterion("vcode =", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotEqualTo(String value) {
            addCriterion("vcode <>", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThan(String value) {
            addCriterion("vcode >", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThanOrEqualTo(String value) {
            addCriterion("vcode >=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThan(String value) {
            addCriterion("vcode <", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThanOrEqualTo(String value) {
            addCriterion("vcode <=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLike(String value) {
            addCriterion("vcode like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotLike(String value) {
            addCriterion("vcode not like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeIn(List<String> values) {
            addCriterion("vcode in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotIn(List<String> values) {
            addCriterion("vcode not in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeBetween(String value1, String value2) {
            addCriterion("vcode between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotBetween(String value1, String value2) {
            addCriterion("vcode not between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andEmkeyIsNull() {
            addCriterion("emkey is null");
            return (Criteria) this;
        }

        public Criteria andEmkeyIsNotNull() {
            addCriterion("emkey is not null");
            return (Criteria) this;
        }

        public Criteria andEmkeyEqualTo(String value) {
            addCriterion("emkey =", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyNotEqualTo(String value) {
            addCriterion("emkey <>", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyGreaterThan(String value) {
            addCriterion("emkey >", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyGreaterThanOrEqualTo(String value) {
            addCriterion("emkey >=", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyLessThan(String value) {
            addCriterion("emkey <", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyLessThanOrEqualTo(String value) {
            addCriterion("emkey <=", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyLike(String value) {
            addCriterion("emkey like", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyNotLike(String value) {
            addCriterion("emkey not like", value, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyIn(List<String> values) {
            addCriterion("emkey in", values, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyNotIn(List<String> values) {
            addCriterion("emkey not in", values, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyBetween(String value1, String value2) {
            addCriterion("emkey between", value1, value2, "emkey");
            return (Criteria) this;
        }

        public Criteria andEmkeyNotBetween(String value1, String value2) {
            addCriterion("emkey not between", value1, value2, "emkey");
            return (Criteria) this;
        }

        public Criteria andExpireAtIsNull() {
            addCriterion("expire_at is null");
            return (Criteria) this;
        }

        public Criteria andExpireAtIsNotNull() {
            addCriterion("expire_at is not null");
            return (Criteria) this;
        }

        public Criteria andExpireAtEqualTo(Date value) {
            addCriterion("expire_at =", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotEqualTo(Date value) {
            addCriterion("expire_at <>", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtGreaterThan(Date value) {
            addCriterion("expire_at >", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_at >=", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtLessThan(Date value) {
            addCriterion("expire_at <", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtLessThanOrEqualTo(Date value) {
            addCriterion("expire_at <=", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtIn(List<Date> values) {
            addCriterion("expire_at in", values, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotIn(List<Date> values) {
            addCriterion("expire_at not in", values, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtBetween(Date value1, Date value2) {
            addCriterion("expire_at between", value1, value2, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotBetween(Date value1, Date value2) {
            addCriterion("expire_at not between", value1, value2, "expireAt");
            return (Criteria) this;
        }

        public Criteria andResendAtIsNull() {
            addCriterion("resend_at is null");
            return (Criteria) this;
        }

        public Criteria andResendAtIsNotNull() {
            addCriterion("resend_at is not null");
            return (Criteria) this;
        }

        public Criteria andResendAtEqualTo(Date value) {
            addCriterion("resend_at =", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtNotEqualTo(Date value) {
            addCriterion("resend_at <>", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtGreaterThan(Date value) {
            addCriterion("resend_at >", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtGreaterThanOrEqualTo(Date value) {
            addCriterion("resend_at >=", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtLessThan(Date value) {
            addCriterion("resend_at <", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtLessThanOrEqualTo(Date value) {
            addCriterion("resend_at <=", value, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtIn(List<Date> values) {
            addCriterion("resend_at in", values, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtNotIn(List<Date> values) {
            addCriterion("resend_at not in", values, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtBetween(Date value1, Date value2) {
            addCriterion("resend_at between", value1, value2, "resendAt");
            return (Criteria) this;
        }

        public Criteria andResendAtNotBetween(Date value1, Date value2) {
            addCriterion("resend_at not between", value1, value2, "resendAt");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIsNull() {
            addCriterion("retry_time is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIsNotNull() {
            addCriterion("retry_time is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeEqualTo(Integer value) {
            addCriterion("retry_time =", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotEqualTo(Integer value) {
            addCriterion("retry_time <>", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeGreaterThan(Integer value) {
            addCriterion("retry_time >", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_time >=", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeLessThan(Integer value) {
            addCriterion("retry_time <", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeLessThanOrEqualTo(Integer value) {
            addCriterion("retry_time <=", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIn(List<Integer> values) {
            addCriterion("retry_time in", values, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotIn(List<Integer> values) {
            addCriterion("retry_time not in", values, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeBetween(Integer value1, Integer value2) {
            addCriterion("retry_time between", value1, value2, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_time not between", value1, value2, "retryTime");
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

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Integer value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Integer value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Integer value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Integer value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Integer value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Integer> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Integer> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Integer value1, Integer value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
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