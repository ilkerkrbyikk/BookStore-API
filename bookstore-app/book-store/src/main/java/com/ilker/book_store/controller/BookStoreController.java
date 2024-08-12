package com.ilker.book_store.controller;

import com.ilker.book_store.dto.BookOrderRequest;
import com.ilker.book_store.model.Book;
import com.ilker.book_store.model.Order;
import com.ilker.book_store.service.BookService;
import com.ilker.book_store.service.OrderService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {

        this.orderService = orderService;
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }
    @PostMapping()
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }
}
