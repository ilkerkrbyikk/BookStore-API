package com.ilker.book_store.service;

import com.ilker.book_store.model.Book;
import com.ilker.book_store.model.Order;
import com.ilker.book_store.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final BookService bookService;
    private final OrderRepository orderRepository;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .bookList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);
    }
}

