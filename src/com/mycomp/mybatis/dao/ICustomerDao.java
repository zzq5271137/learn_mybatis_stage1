package com.mycomp.mybatis.dao;

import com.mycomp.mybatis.domain.Customer;

import java.util.List;

/*
 * 传统模式开发Dao: 定义接口
 */

public interface ICustomerDao {

    Customer getCustomerById(Integer cust_id);

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
