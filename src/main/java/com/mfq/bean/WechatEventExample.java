package com.mfq.bean;

import java.util.ArrayList;
import java.util.List;

public class WechatEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatEventExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("event_id is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("event_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(Integer value) {
            addCriterion("event_id =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(Integer value) {
            addCriterion("event_id <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(Integer value) {
            addCriterion("event_id >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_id >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(Integer value) {
            addCriterion("event_id <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(Integer value) {
            addCriterion("event_id <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<Integer> values) {
            addCriterion("event_id in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<Integer> values) {
            addCriterion("event_id not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(Integer value1, Integer value2) {
            addCriterion("event_id between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(Integer value1, Integer value2) {
            addCriterion("event_id not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdIsNull() {
            addCriterion("image_media_id is null");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdIsNotNull() {
            addCriterion("image_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdEqualTo(String value) {
            addCriterion("image_media_id =", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdNotEqualTo(String value) {
            addCriterion("image_media_id <>", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdGreaterThan(String value) {
            addCriterion("image_media_id >", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_media_id >=", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdLessThan(String value) {
            addCriterion("image_media_id <", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdLessThanOrEqualTo(String value) {
            addCriterion("image_media_id <=", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdLike(String value) {
            addCriterion("image_media_id like", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdNotLike(String value) {
            addCriterion("image_media_id not like", value, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdIn(List<String> values) {
            addCriterion("image_media_id in", values, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdNotIn(List<String> values) {
            addCriterion("image_media_id not in", values, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdBetween(String value1, String value2) {
            addCriterion("image_media_id between", value1, value2, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andImageMediaIdNotBetween(String value1, String value2) {
            addCriterion("image_media_id not between", value1, value2, "imageMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdIsNull() {
            addCriterion("media_media_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdIsNotNull() {
            addCriterion("media_media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdEqualTo(String value) {
            addCriterion("media_media_id =", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdNotEqualTo(String value) {
            addCriterion("media_media_id <>", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdGreaterThan(String value) {
            addCriterion("media_media_id >", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("media_media_id >=", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdLessThan(String value) {
            addCriterion("media_media_id <", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdLessThanOrEqualTo(String value) {
            addCriterion("media_media_id <=", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdLike(String value) {
            addCriterion("media_media_id like", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdNotLike(String value) {
            addCriterion("media_media_id not like", value, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdIn(List<String> values) {
            addCriterion("media_media_id in", values, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdNotIn(List<String> values) {
            addCriterion("media_media_id not in", values, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdBetween(String value1, String value2) {
            addCriterion("media_media_id between", value1, value2, "mediaMediaId");
            return (Criteria) this;
        }

        public Criteria andMediaMediaIdNotBetween(String value1, String value2) {
            addCriterion("media_media_id not between", value1, value2, "mediaMediaId");
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