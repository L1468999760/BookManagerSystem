package com.nowcoder.demo.dao;

import com.nowcoder.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface UserDAO {
    String table_name = " user ";
    String insert_field = " name, email, password ";
    String select_field = " id, " + insert_field;

    @Insert({"insert into", table_name, "(", insert_field,
            ") values (#{name},#{email},#{password})"})
    void addUser(User user);

    @Select({"select", select_field, "from", table_name, "where id=#{id}"})
    User selectById(int id);

    @Select({"select", select_field, "from", table_name, "where name=#{name}"})
    User selectByName(String name);

    @Select({"select", select_field, "from", table_name, "where email=#{email}"})
    User selectByEmail(String email);

    @Update({"update", table_name, "set password=#{password} where email=#{email}"})
    void updatePassword(String email,String password);

    @Select("select * from user where email=#{email}")
    User containsUser(String email);

    @Select("select * from user where isOnline=1")
    User isOnline();

    @Update("update user set isOnline=1 where email=#{email}")
    void updateOnline(String email);

    @Update("update user set isOnline=0 where email=#{email}")
    void updateDeline(String email);

}
