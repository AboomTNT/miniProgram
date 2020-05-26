package com.example.miniprogram.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNull() {
            addCriterion("user_gender is null");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNotNull() {
            addCriterion("user_gender is not null");
            return (Criteria) this;
        }

        public Criteria andUserGenderEqualTo(String value) {
            addCriterion("user_gender =", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotEqualTo(String value) {
            addCriterion("user_gender <>", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThan(String value) {
            addCriterion("user_gender >", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThanOrEqualTo(String value) {
            addCriterion("user_gender >=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThan(String value) {
            addCriterion("user_gender <", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThanOrEqualTo(String value) {
            addCriterion("user_gender <=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLike(String value) {
            addCriterion("user_gender like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotLike(String value) {
            addCriterion("user_gender not like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderIn(List<String> values) {
            addCriterion("user_gender in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotIn(List<String> values) {
            addCriterion("user_gender not in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderBetween(String value1, String value2) {
            addCriterion("user_gender between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotBetween(String value1, String value2) {
            addCriterion("user_gender not between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIsNull() {
            addCriterion("user_avater is null");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIsNotNull() {
            addCriterion("user_avater is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvaterEqualTo(String value) {
            addCriterion("user_avater =", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotEqualTo(String value) {
            addCriterion("user_avater <>", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterGreaterThan(String value) {
            addCriterion("user_avater >", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterGreaterThanOrEqualTo(String value) {
            addCriterion("user_avater >=", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLessThan(String value) {
            addCriterion("user_avater <", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLessThanOrEqualTo(String value) {
            addCriterion("user_avater <=", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterLike(String value) {
            addCriterion("user_avater like", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotLike(String value) {
            addCriterion("user_avater not like", value, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterIn(List<String> values) {
            addCriterion("user_avater in", values, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotIn(List<String> values) {
            addCriterion("user_avater not in", values, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterBetween(String value1, String value2) {
            addCriterion("user_avater between", value1, value2, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserAvaterNotBetween(String value1, String value2) {
            addCriterion("user_avater not between", value1, value2, "userAvater");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("user_birthday is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("user_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("user_birthday =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("user_birthday <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("user_birthday >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_birthday >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("user_birthday <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_birthday <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("user_birthday in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("user_birthday not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_birthday between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_birthday not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("user_address is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("user_address is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("user_address =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("user_address <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("user_address >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("user_address >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("user_address <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("user_address <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("user_address like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("user_address not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("user_address in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("user_address not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("user_address between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("user_address not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserIdentityIsNull() {
            addCriterion("user_identity is null");
            return (Criteria) this;
        }

        public Criteria andUserIdentityIsNotNull() {
            addCriterion("user_identity is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdentityEqualTo(String value) {
            addCriterion("user_identity =", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityNotEqualTo(String value) {
            addCriterion("user_identity <>", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityGreaterThan(String value) {
            addCriterion("user_identity >", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("user_identity >=", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityLessThan(String value) {
            addCriterion("user_identity <", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityLessThanOrEqualTo(String value) {
            addCriterion("user_identity <=", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityLike(String value) {
            addCriterion("user_identity like", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityNotLike(String value) {
            addCriterion("user_identity not like", value, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityIn(List<String> values) {
            addCriterion("user_identity in", values, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityNotIn(List<String> values) {
            addCriterion("user_identity not in", values, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityBetween(String value1, String value2) {
            addCriterion("user_identity between", value1, value2, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserIdentityNotBetween(String value1, String value2) {
            addCriterion("user_identity not between", value1, value2, "userIdentity");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIsNull() {
            addCriterion("user_describe is null");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIsNotNull() {
            addCriterion("user_describe is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescribeEqualTo(String value) {
            addCriterion("user_describe =", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotEqualTo(String value) {
            addCriterion("user_describe <>", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeGreaterThan(String value) {
            addCriterion("user_describe >", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("user_describe >=", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLessThan(String value) {
            addCriterion("user_describe <", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLessThanOrEqualTo(String value) {
            addCriterion("user_describe <=", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeLike(String value) {
            addCriterion("user_describe like", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotLike(String value) {
            addCriterion("user_describe not like", value, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeIn(List<String> values) {
            addCriterion("user_describe in", values, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotIn(List<String> values) {
            addCriterion("user_describe not in", values, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeBetween(String value1, String value2) {
            addCriterion("user_describe between", value1, value2, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserDescribeNotBetween(String value1, String value2) {
            addCriterion("user_describe not between", value1, value2, "userDescribe");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserWxIsNull() {
            addCriterion("user_wx is null");
            return (Criteria) this;
        }

        public Criteria andUserWxIsNotNull() {
            addCriterion("user_wx is not null");
            return (Criteria) this;
        }

        public Criteria andUserWxEqualTo(String value) {
            addCriterion("user_wx =", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxNotEqualTo(String value) {
            addCriterion("user_wx <>", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxGreaterThan(String value) {
            addCriterion("user_wx >", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxGreaterThanOrEqualTo(String value) {
            addCriterion("user_wx >=", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxLessThan(String value) {
            addCriterion("user_wx <", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxLessThanOrEqualTo(String value) {
            addCriterion("user_wx <=", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxLike(String value) {
            addCriterion("user_wx like", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxNotLike(String value) {
            addCriterion("user_wx not like", value, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxIn(List<String> values) {
            addCriterion("user_wx in", values, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxNotIn(List<String> values) {
            addCriterion("user_wx not in", values, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxBetween(String value1, String value2) {
            addCriterion("user_wx between", value1, value2, "userWx");
            return (Criteria) this;
        }

        public Criteria andUserWxNotBetween(String value1, String value2) {
            addCriterion("user_wx not between", value1, value2, "userWx");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbg.generated do_not_delete_during_merge Sun May 24 19:51:25 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbg.generated Sun May 24 19:51:25 CST 2020
     */
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