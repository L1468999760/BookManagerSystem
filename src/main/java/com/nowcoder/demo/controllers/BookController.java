package com.nowcoder.demo.controllers;

import com.nowcoder.demo.model.Book;
import com.nowcoder.demo.model.User;
import com.nowcoder.demo.service.BookService;
import com.nowcoder.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    public BookService bookService;
    @Autowired
    public UserService userService;

    @RequestMapping(path={"/index"},method={RequestMethod.GET})
    public String bookList(Model model){
        User curUser = userService.getOnlineUser();
        if(curUser==null) {
            model.addAttribute("error","请先登录！");
            return "404";
        }
        else{
            model.addAttribute("username",curUser.getName());
            loadAllBooksView(model);
            return "book/books";
        }

    }

    @GetMapping(path="/books/add")
    public String addBook() { return "book/addbook";}

    @PostMapping(path="/books/add/do")
    public String doAddBook(
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("price") String price
    ){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBooks(book);
        return "redirect:/index";
    }

    @GetMapping(path="/books/{bookId:[0-9]+}/borrow")
    public String borrowBook(@PathVariable("bookId") int bookId){
        bookService.borrowBooks(bookId);
        return "redirect:/index";
    }

    @GetMapping(path="/books/{bookId:[0-9]+}/recover")
    public String recoverBook(@PathVariable("bookId") int bookId){
        bookService.recoverBooks(bookId);
        return "redirect:/index";
    }


    private void loadAllBooksView(Model model){
        model.addAttribute("books", bookService.getAllBooks());
    }
}
