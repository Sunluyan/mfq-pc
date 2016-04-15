package com.mfq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceBillExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("bill_no is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("bill_no =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("bill_no <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("bill_no >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("bill_no >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("bill_no <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("bill_no <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("bill_no like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("bill_no not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("bill_no in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("bill_no not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("bill_no between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("bill_no not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andAllPeriodIsNull() {
            addCriterion("all_period is null");
            return (Criteria) this;
        }

        public Criteria andAllPeriodIsNotNull() {
            addCriterion("all_period is not null");
            return (Criteria) this;
        }

        public Criteria andAllPeriodEqualTo(Integer value) {
            addCriterion("all_period =", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodNotEqualTo(Integer value) {
            addCriterion("all_period <>", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodGreaterThan(Integer value) {
            addCriterion("all_period >", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_period >=", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodLessThan(Integer value) {
            addCriterion("all_period <", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("all_period <=", value, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodIn(List<Integer> values) {
            addCriterion("all_period in", values, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodNotIn(List<Integer> values) {
            addCriterion("all_period not in", values, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodBetween(Integer value1, Integer value2) {
            addCriterion("all_period between", value1, value2, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andAllPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("all_period not between", value1, value2, "allPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodIsNull() {
            addCriterion("current_period is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodIsNotNull() {
            addCriterion("current_period is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodEqualTo(Integer value) {
            addCriterion("current_period =", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotEqualTo(Integer value) {
            addCriterion("current_period <>", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodGreaterThan(Integer value) {
            addCriterion("current_period >", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_period >=", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodLessThan(Integer value) {
            addCriterion("current_period <", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("current_period <=", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodIn(List<Integer> values) {
            addCriterion("current_period in", values, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotIn(List<Integer> values) {
            addCriterion("current_period not in", values, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodBetween(Integer value1, Integer value2) {
            addCriterion("current_period between", value1, value2, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("current_period not between", value1, value2, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andLateFeeIsNull() {
            addCriterion("late_fee is null");
            return (Criteria) this;
        }

        public Criteria andLateFeeIsNotNull() {
            addCriterion("late_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLateFeeEqualTo(Long value) {
            addCriterion("late_fee =", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeNotEqualTo(Long value) {
            addCriterion("late_fee <>", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeGreaterThan(Long value) {
            addCriterion("late_fee >", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("late_fee >=", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeLessThan(Long value) {
            addCriterion("late_fee <", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeLessThanOrEqualTo(Long value) {
            addCriterion("late_fee <=", value, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeIn(List<Long> values) {
            addCriterion("late_fee in", values, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeNotIn(List<Long> values) {
            addCriterion("late_fee not in", values, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeBetween(Long value1, Long value2) {
            addCriterion("late_fee between", value1, value2, "lateFee");
            return (Criteria) this;
        }

        public Criteria andLateFeeNotBetween(Long value1, Long value2) {
            addCriterion("late_fee not between", value1, value2, "lateFee");
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

        public Criteria andPayAtIsNull() {
            addCriterion("pay_at is null");
            return (Criteria) this;
        }

        public Criteria andPayAtIsNotNull() {
            addCriterion("pay_at is not null");
            return (Criteria) this;
        }

        public Criteria andPayAtEqualTo(Date value) {
            addCriterion("pay_at =", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtNotEqualTo(Date value) {
            addCriterion("pay_at <>", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtGreaterThan(Date value) {
            addCriterion("pay_at >", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_at >=", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtLessThan(Date value) {
            addCriterion("pay_at <", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtLessThanOrEqualTo(Date value) {
            addCriterion("pay_at <=", value, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtIn(List<Date> values) {
            addCriterion("pay_at in", values, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtNotIn(List<Date> values) {
            addCriterion("pay_at not in", values, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtBetween(Date value1, Date value2) {
            addCriterion("pay_at between", value1, value2, "payAt");
            return (Criteria) this;
        }

        public Criteria andPayAtNotBetween(Date value1, Date value2) {
            addCriterion("pay_at not between", value1, value2, "payAt");
            return (Criteria) this;
        }

        public Criteria andDueAtIsNull() {
            addCriterion("due_at is null");
            return (Criteria) this;
        }

        public Criteria andDueAtIsNotNull() {
            addCriterion("due_at is not null");
            return (Criteria) this;
        }

        public Criteria andDueAtEqualTo(Date value) {
            addCriterion("due_at =", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtNotEqualTo(Date value) {
            addCriterion("due_at <>", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtGreaterThan(Date value) {
            addCriterion("due_at >", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtGreaterThanOrEqualTo(Date value) {
            addCriterion("due_at >=", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtLessThan(Date value) {
            addCriterion("due_at <", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtLessThanOrEqualTo(Date value) {
            addCriterion("due_at <=", value, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtIn(List<Date> values) {
            addCriterion("due_at in", values, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtNotIn(List<Date> values) {
            addCriterion("due_at not in", values, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtBetween(Date value1, Date value2) {
            addCriterion("due_at between", value1, value2, "dueAt");
            return (Criteria) this;
        }

        public Criteria andDueAtNotBetween(Date value1, Date value2) {
            addCriterion("due_at not between", value1, value2, "dueAt");
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