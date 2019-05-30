package com.ssm.study.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public OrderDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
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
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIsNull() {
            addCriterion("orders_id is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIsNotNull() {
            addCriterion("orders_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersIdEqualTo(Integer value) {
            addCriterion("orders_id =", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotEqualTo(Integer value) {
            addCriterion("orders_id <>", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThan(Integer value) {
            addCriterion("orders_id >", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orders_id >=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThan(Integer value) {
            addCriterion("orders_id <", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdLessThanOrEqualTo(Integer value) {
            addCriterion("orders_id <=", value, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdIn(List<Integer> values) {
            addCriterion("orders_id in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotIn(List<Integer> values) {
            addCriterion("orders_id not in", values, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdBetween(Integer value1, Integer value2) {
            addCriterion("orders_id between", value1, value2, "ordersId");
            return (Criteria) this;
        }

        public Criteria andOrdersIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orders_id not between", value1, value2, "ordersId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNull() {
            addCriterion("items_id is null");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNotNull() {
            addCriterion("items_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemsIdEqualTo(Integer value) {
            addCriterion("items_id =", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotEqualTo(Integer value) {
            addCriterion("items_id <>", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThan(Integer value) {
            addCriterion("items_id >", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("items_id >=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThan(Integer value) {
            addCriterion("items_id <", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThanOrEqualTo(Integer value) {
            addCriterion("items_id <=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIn(List<Integer> values) {
            addCriterion("items_id in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotIn(List<Integer> values) {
            addCriterion("items_id not in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdBetween(Integer value1, Integer value2) {
            addCriterion("items_id between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("items_id not between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsNumIsNull() {
            addCriterion("items_num is null");
            return (Criteria) this;
        }

        public Criteria andItemsNumIsNotNull() {
            addCriterion("items_num is not null");
            return (Criteria) this;
        }

        public Criteria andItemsNumEqualTo(Integer value) {
            addCriterion("items_num =", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotEqualTo(Integer value) {
            addCriterion("items_num <>", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumGreaterThan(Integer value) {
            addCriterion("items_num >", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("items_num >=", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumLessThan(Integer value) {
            addCriterion("items_num <", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumLessThanOrEqualTo(Integer value) {
            addCriterion("items_num <=", value, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumIn(List<Integer> values) {
            addCriterion("items_num in", values, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotIn(List<Integer> values) {
            addCriterion("items_num not in", values, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumBetween(Integer value1, Integer value2) {
            addCriterion("items_num between", value1, value2, "itemsNum");
            return (Criteria) this;
        }

        public Criteria andItemsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("items_num not between", value1, value2, "itemsNum");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table orderdetail
     *
     * @mbggenerated do_not_delete_during_merge Wed May 23 15:09:39 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table orderdetail
     *
     * @mbggenerated Wed May 23 15:09:39 CST 2018
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