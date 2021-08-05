package com.nowcoder.demo.service;

import com.nowcoder.demo.dao.BookDAO;
import com.nowcoder.demo.model.Book;
import com.nowcoder.demo.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.selectAll();
    }
    //添加图书
    public int addBooks(Book book) {return bookDAO.addBook(book);}
    //借图书
    public void borrowBooks(int id) { bookDAO.updateBookStatus(id, BookStatusEnum.BORROW.getValue());}
    //还书
    public void recoverBooks(int id) { bookDAO.updateBookStatus(id,BookStatusEnum.NORMAL.getValue());}
    //删除图书
    public void deleteBooks(int id) { bookDAO.deleteBook(id);}
    //推荐图书
    public void recommendBooks(int id) { bookDAO.updateBookStatus(id,BookStatusEnum.RECOMMENDED.getValue());}
}
