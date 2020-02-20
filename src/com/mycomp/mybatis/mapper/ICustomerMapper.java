package com.mycomp.mybatis.mapper;

/*
 * 使用Mybatis的mapper动态代理的形式开发Dao;
 * 不需要自己去实现接口;
 *
 * 要求:
 * 1. namespace必须和Mapper接口类路径一致 (Customer.xml中mapper标签的namespace属性);
 * 2. id必须和Mapper接口方法名一致; (Customer.xml中select、insert等标签的id属性);
 * 3. parameterType必须和接口方法参数类型一致; (Customer.xml中select、insert等标签的parameterType属性);
 * 4. resultType必须和接口方法返回值类型一致; (Customer.xml中select、insert等标签的resultType属性);
 */

import com.mycomp.mybatis.domain.Customer;

import java.util.List;

public interface ICustomerMapper {

    // 根据cust_id查询客户
    Customer queryCustomerById(Integer cust_id);

    // 查询所有的用户
    List<Customer> queryAllCustomer();

    // 根据名字模糊查询
    List<Customer> queryCustomerByName(String name);

    // 添加一个客户
    void insertCustomer(Customer customer);

    // 更新一个客户信息
    void updateCustomer(Customer customer);

    // 删除一个客户
    void deleteCustomer(Customer customer);
}
