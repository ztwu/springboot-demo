package com.song.repository;

import com.song.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Song on 2017/2/15.
 * User表操作接口
 */
@Repository
public interface UserRepositoty extends JpaRepository<User,Long>{

    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name") String name);

    //利用原生的SQL进行插入操作
    @Query(value = "insert into tbl_user(name,password) value(?1,?2)", nativeQuery = true)
    @Modifying
    //SpringDataJPA自定义SQL时需要在对应的接口或者调用接口的地方添加事务注解@Transactional，来开启事务自动化管理
    @Transactional
    public void insertUser(String name,String password);

    User findByName(@Param("name") String name);

    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);

}
