package com.mycomp.mybatis.test;

import com.mycomp.mybatis.domain.Customer;
import com.mycomp.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/*
 * Mybatis的基本增删改查
 */

public class MyTest1 {

    /*
     * 根据cust_id查询客户
     */
    @Test
    public void test1() {
        // 从工具类中获取session(相当于JDBC中的connection)
        SqlSession sqlSession = MybatisUtils.openSession();

        // 执行sql
        // 第一个参数是Customer.xml中的statement的id
        // 第二个参数是执行sql需要的参数
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);
        System.out.println(customer);

        // 关闭session
        sqlSession.close();
    }

    /*
     * 查询所有的用户
     */
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        List<Customer> allCustomers = sqlSession.selectList("queryAllCustomer");
        for (Customer customer : allCustomers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    /*
     * 模糊查询, 查询所有姓李的用户
     */
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 使用${}, 详见Customer.xml
        // List<Customer> allCustomers = sqlSession.selectList("queryCustomerByName", "李");

        // 使用#{}, 详见Customer.xml
        List<Customer> allCustomers = sqlSession.selectList("queryCustomerByName", "%李%");

        for (Customer customer : allCustomers) {
            System.out.println(customer);
        }

        sqlSession.close();
    }

    /*
     * 添加一个客户
     */
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.openSession();

        Customer customer = new Customer();
        customer.setCust_name("zzqgo");
        customer.setCust_profession("无敌");
        customer.setCust_phone("18251903130");
        customer.setEmail("zzq@gmail.com");
        System.out.println("插入前没有id: " + customer);

        // 当要改动数据库当中的记录时, 执行sql时要自己提交事务
        sqlSession.insert("insertCustomer", customer);
        sqlSession.commit();
        System.out.println("插入后获取插入的id: " + customer);

        sqlSession.close();
    }

    /*
     * 更新一个客户信息
     */
    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 先查询再改; 也可以自己新建一个(new的对象里边必须要有id);
        Customer customer = sqlSession.selectOne("queryCustomerById", 14);
        customer.setCust_name("zzq233");
        sqlSession.update("updateCustomer", customer);

        sqlSession.commit();
        sqlSession.close();
    }

    /*
     * 删除一个客户
     */
    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.openSession();

        // 先查再删
        Customer customer = sqlSession.selectOne("queryCustomerById", 14);
        sqlSession.delete("deleteCustomer", customer);

        sqlSession.commit();
        sqlSession.close();
    }

}
