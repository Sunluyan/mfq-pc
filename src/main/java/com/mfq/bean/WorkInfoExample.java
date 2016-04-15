package com.mfq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkInfoExample() {
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

        public Criteria andVisitingCardIsNull() {
            addCriterion("visiting_card is null");
            return (Criteria) this;
        }

        public Criteria andVisitingCardIsNotNull() {
            addCriterion("visiting_card is not null");
            return (Criteria) this;
        }

        public Criteria andVisitingCardEqualTo(String value) {
            addCriterion("visiting_card =", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardNotEqualTo(String value) {
            addCriterion("visiting_card <>", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardGreaterThan(String value) {
            addCriterion("visiting_card >", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardGreaterThanOrEqualTo(String value) {
            addCriterion("visiting_card >=", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardLessThan(String value) {
            addCriterion("visiting_card <", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardLessThanOrEqualTo(String value) {
            addCriterion("visiting_card <=", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardLike(String value) {
            addCriterion("visiting_card like", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardNotLike(String value) {
            addCriterion("visiting_card not like", value, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardIn(List<String> values) {
            addCriterion("visiting_card in", values, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardNotIn(List<String> values) {
            addCriterion("visiting_card not in", values, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardBetween(String value1, String value2) {
            addCriterion("visiting_card between", value1, value2, "visitingCard");
            return (Criteria) this;
        }

        public Criteria andVisitingCardNotBetween(String value1, String value2) {
            addCriterion("visiting_card not between", value1, value2, "visitingCard");
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundIsNull() {
            addCriterion("academic_background is null");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundIsNotNull() {
            addCriterion("academic_background is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundEqualTo(String value) {
            addCriterion("academic_background =", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundNotEqualTo(String value) {
            addCriterion("academic_background <>", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundGreaterThan(String value) {
            addCriterion("academic_background >", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("academic_background >=", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundLessThan(String value) {
            addCriterion("academic_background <", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundLessThanOrEqualTo(String value) {
            addCriterion("academic_background <=", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundLike(String value) {
            addCriterion("academic_background like", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundNotLike(String value) {
            addCriterion("academic_background not like", value, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundIn(List<String> values) {
            addCriterion("academic_background in", values, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundNotIn(List<String> values) {
            addCriterion("academic_background not in", values, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundBetween(String value1, String value2) {
            addCriterion("academic_background between", value1, value2, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andAcademicBackgroundNotBetween(String value1, String value2) {
            addCriterion("academic_background not between", value1, value2, "academicBackground");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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