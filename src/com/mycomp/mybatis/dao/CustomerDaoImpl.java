package com.mycomp.mybatis.dao;

import com.mycomp.mybatis.domain.Customer;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 * 传统模式开发Dao: 自己实现接口
 */

public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public Customer getCustomerById(Integer cust_id) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById", cust_id);
        sqlSession.close();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> allCustomers = sqlSession.selectList("queryAllCustomer");
        sqlSession.close();
        return allCustomers;
    }

    @Override
    public void addCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.insert("insertCustomer", customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.update("updateCustomer", customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        SqlSession sqlSession = MybatisUtils.openSession();
        sqlSession.delete("deleteCustomer", customer);
        sqlSession.commit();
        sqlSession.close();
    }
}
