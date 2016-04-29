package com.mfq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
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

        public Criteria andIdFrontIsNull() {
            addCriterion("id_front is null");
            return (Criteria) this;
        }

        public Criteria andIdFrontIsNotNull() {
            addCriterion("id_front is not null");
            return (Criteria) this;
        }

        public Criteria andIdFrontEqualTo(String value) {
            addCriterion("id_front =", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontNotEqualTo(String value) {
            addCriterion("id_front <>", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontGreaterThan(String value) {
            addCriterion("id_front >", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontGreaterThanOrEqualTo(String value) {
            addCriterion("id_front >=", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontLessThan(String value) {
            addCriterion("id_front <", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontLessThanOrEqualTo(String value) {
            addCriterion("id_front <=", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontLike(String value) {
            addCriterion("id_front like", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontNotLike(String value) {
            addCriterion("id_front not like", value, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontIn(List<String> values) {
            addCriterion("id_front in", values, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontNotIn(List<String> values) {
            addCriterion("id_front not in", values, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontBetween(String value1, String value2) {
            addCriterion("id_front between", value1, value2, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdFrontNotBetween(String value1, String value2) {
            addCriterion("id_front not between", value1, value2, "idFront");
            return (Criteria) this;
        }

        public Criteria andIdBackIsNull() {
            addCriterion("id_back is null");
            return (Criteria) this;
        }

        public Criteria andIdBackIsNotNull() {
            addCriterion("id_back is not null");
            return (Criteria) this;
        }

        public Criteria andIdBackEqualTo(String value) {
            addCriterion("id_back =", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackNotEqualTo(String value) {
            addCriterion("id_back <>", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackGreaterThan(String value) {
            addCriterion("id_back >", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackGreaterThanOrEqualTo(String value) {
            addCriterion("id_back >=", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackLessThan(String value) {
            addCriterion("id_back <", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackLessThanOrEqualTo(String value) {
            addCriterion("id_back <=", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackLike(String value) {
            addCriterion("id_back like", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackNotLike(String value) {
            addCriterion("id_back not like", value, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackIn(List<String> values) {
            addCriterion("id_back in", values, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackNotIn(List<String> values) {
            addCriterion("id_back not in", values, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackBetween(String value1, String value2) {
            addCriterion("id_back between", value1, value2, "idBack");
            return (Criteria) this;
        }

        public Criteria andIdBackNotBetween(String value1, String value2) {
            addCriterion("id_back not between", value1, value2, "idBack");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andIdWithHandIsNull() {
            addCriterion("id_with_hand is null");
            return (Criteria) this;
        }

        public Criteria andIdWithHandIsNotNull() {
            addCriterion("id_with_hand is not null");
            return (Criteria) this;
        }

        public Criteria andIdWithHandEqualTo(String value) {
            addCriterion("id_with_hand =", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandNotEqualTo(String value) {
            addCriterion("id_with_hand <>", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandGreaterThan(String value) {
            addCriterion("id_with_hand >", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandGreaterThanOrEqualTo(String value) {
            addCriterion("id_with_hand >=", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandLessThan(String value) {
            addCriterion("id_with_hand <", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandLessThanOrEqualTo(String value) {
            addCriterion("id_with_hand <=", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandLike(String value) {
            addCriterion("id_with_hand like", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandNotLike(String value) {
            addCriterion("id_with_hand not like", value, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandIn(List<String> values) {
            addCriterion("id_with_hand in", values, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandNotIn(List<String> values) {
            addCriterion("id_with_hand not in", values, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandBetween(String value1, String value2) {
            addCriterion("id_with_hand between", value1, value2, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andIdWithHandNotBetween(String value1, String value2) {
            addCriterion("id_with_hand not between", value1, value2, "idWithHand");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIsNull() {
            addCriterion("school_provice is null");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIsNotNull() {
            addCriterion("school_provice is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceEqualTo(String value) {
            addCriterion("school_provice =", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotEqualTo(String value) {
            addCriterion("school_provice <>", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceGreaterThan(String value) {
            addCriterion("school_provice >", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceGreaterThanOrEqualTo(String value) {
            addCriterion("school_provice >=", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLessThan(String value) {
            addCriterion("school_provice <", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLessThanOrEqualTo(String value) {
            addCriterion("school_provice <=", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceLike(String value) {
            addCriterion("school_provice like", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotLike(String value) {
            addCriterion("school_provice not like", value, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceIn(List<String> values) {
            addCriterion("school_provice in", values, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotIn(List<String> values) {
            addCriterion("school_provice not in", values, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceBetween(String value1, String value2) {
            addCriterion("school_provice between", value1, value2, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolProviceNotBetween(String value1, String value2) {
            addCriterion("school_provice not between", value1, value2, "schoolProvice");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIsNull() {
            addCriterion("school_city is null");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIsNotNull() {
            addCriterion("school_city is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolCityEqualTo(String value) {
            addCriterion("school_city =", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotEqualTo(String value) {
            addCriterion("school_city <>", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityGreaterThan(String value) {
            addCriterion("school_city >", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityGreaterThanOrEqualTo(String value) {
            addCriterion("school_city >=", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLessThan(String value) {
            addCriterion("school_city <", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLessThanOrEqualTo(String value) {
            addCriterion("school_city <=", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityLike(String value) {
            addCriterion("school_city like", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotLike(String value) {
            addCriterion("school_city not like", value, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityIn(List<String> values) {
            addCriterion("school_city in", values, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotIn(List<String> values) {
            addCriterion("school_city not in", values, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityBetween(String value1, String value2) {
            addCriterion("school_city between", value1, value2, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolCityNotBetween(String value1, String value2) {
            addCriterion("school_city not between", value1, value2, "schoolCity");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }

        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNull() {
            addCriterion("family_name is null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIsNotNull() {
            addCriterion("family_name is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyNameEqualTo(String value) {
            addCriterion("family_name =", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotEqualTo(String value) {
            addCriterion("family_name <>", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThan(String value) {
            addCriterion("family_name >", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameGreaterThanOrEqualTo(String value) {
            addCriterion("family_name >=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThan(String value) {
            addCriterion("family_name <", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLessThanOrEqualTo(String value) {
            addCriterion("family_name <=", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameLike(String value) {
            addCriterion("family_name like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotLike(String value) {
            addCriterion("family_name not like", value, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameIn(List<String> values) {
            addCriterion("family_name in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotIn(List<String> values) {
            addCriterion("family_name not in", values, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameBetween(String value1, String value2) {
            addCriterion("family_name between", value1, value2, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyNameNotBetween(String value1, String value2) {
            addCriterion("family_name not between", value1, value2, "familyName");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileIsNull() {
            addCriterion("family_mobile is null");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileIsNotNull() {
            addCriterion("family_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileEqualTo(String value) {
            addCriterion("family_mobile =", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileNotEqualTo(String value) {
            addCriterion("family_mobile <>", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileGreaterThan(String value) {
            addCriterion("family_mobile >", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileGreaterThanOrEqualTo(String value) {
            addCriterion("family_mobile >=", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileLessThan(String value) {
            addCriterion("family_mobile <", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileLessThanOrEqualTo(String value) {
            addCriterion("family_mobile <=", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileLike(String value) {
            addCriterion("family_mobile like", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileNotLike(String value) {
            addCriterion("family_mobile not like", value, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileIn(List<String> values) {
            addCriterion("family_mobile in", values, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileNotIn(List<String> values) {
            addCriterion("family_mobile not in", values, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileBetween(String value1, String value2) {
            addCriterion("family_mobile between", value1, value2, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andFamilyMobileNotBetween(String value1, String value2) {
            addCriterion("family_mobile not between", value1, value2, "familyMobile");
            return (Criteria) this;
        }

        public Criteria andWechatNoIsNull() {
            addCriterion("wechat_no is null");
            return (Criteria) this;
        }

        public Criteria andWechatNoIsNotNull() {
            addCriterion("wechat_no is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNoEqualTo(String value) {
            addCriterion("wechat_no =", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotEqualTo(String value) {
            addCriterion("wechat_no <>", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoGreaterThan(String value) {
            addCriterion("wechat_no >", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_no >=", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLessThan(String value) {
            addCriterion("wechat_no <", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLessThanOrEqualTo(String value) {
            addCriterion("wechat_no <=", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoLike(String value) {
            addCriterion("wechat_no like", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotLike(String value) {
            addCriterion("wechat_no not like", value, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoIn(List<String> values) {
            addCriterion("wechat_no in", values, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotIn(List<String> values) {
            addCriterion("wechat_no not in", values, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoBetween(String value1, String value2) {
            addCriterion("wechat_no between", value1, value2, "wechatNo");
            return (Criteria) this;
        }

        public Criteria andWechatNoNotBetween(String value1, String value2) {
            addCriterion("wechat_no not between", value1, value2, "wechatNo");
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

        public Criteria andXuexinwangIsNull() {
            addCriterion("xuexinwang is null");
            return (Criteria) this;
        }

        public Criteria andXuexinwangIsNotNull() {
            addCriterion("xuexinwang is not null");
            return (Criteria) this;
        }

        public Criteria andXuexinwangEqualTo(String value) {
            addCriterion("xuexinwang =", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangNotEqualTo(String value) {
            addCriterion("xuexinwang <>", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangGreaterThan(String value) {
            addCriterion("xuexinwang >", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangGreaterThanOrEqualTo(String value) {
            addCriterion("xuexinwang >=", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangLessThan(String value) {
            addCriterion("xuexinwang <", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangLessThanOrEqualTo(String value) {
            addCriterion("xuexinwang <=", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangLike(String value) {
            addCriterion("xuexinwang like", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangNotLike(String value) {
            addCriterion("xuexinwang not like", value, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangIn(List<String> values) {
            addCriterion("xuexinwang in", values, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangNotIn(List<String> values) {
            addCriterion("xuexinwang not in", values, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangBetween(String value1, String value2) {
            addCriterion("xuexinwang between", value1, value2, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andXuexinwangNotBetween(String value1, String value2) {
            addCriterion("xuexinwang not between", value1, value2, "xuexinwang");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
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