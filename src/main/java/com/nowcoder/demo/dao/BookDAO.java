package com.nowcoder.demo.dao;

import com.nowcoder.demo.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface BookDAO {
    String table_name = " book ";
    String insert_field = " name, author, price ";
    String select_field = " id, status, " + insert_field;

    @Select("select * from book")
    public List<Book> selectAll();


    @Insert({"insert into", table_name, "(", insert_field,
            ") values (#{name},#{author},#{price})"})
    int addBook(Book book);

    @Update({"update ", table_name, " set status=#{status} where id=#{id}"})
    void updateBookStatus(@Param("id") int id, @Param("status") int status);

    @Delete({"delete * from book where id=#{id}"})
    void deleteBook(@Param("id") int id);
}
