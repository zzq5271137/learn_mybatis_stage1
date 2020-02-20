package com.mycomp.mybatis.test;

import com.mycomp.mybatis.dao.CustomerDaoImpl;
import com.mycomp.mybatis.dao.ICustomerDao;
import com.mycomp.mybatis.domain.Customer;
import com.mycomp.mybatis.mapper.ICustomerMapper;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {

    /*
     * 测试传统的Dao
     */
    @Test
    public void test1() {
        ICustomerDao customerDao = new CustomerDaoImpl();
        List<Customer> allCustomers = customerDao.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println(customer);
        }
    }

    /*
     * 测试Mybatis开发的Dao
     */
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 通过getMapper()获得mapper(需要传入你创建的那个mapper接口的字节码)
        ICustomerMapper mapper = sqlSession.getMapper(ICustomerMapper.class);

        List<Customer> allCustomer = mapper.queryAllCustomer();
        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

}
