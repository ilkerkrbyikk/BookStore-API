package com.ilker.book_store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookOrder")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;
    private List<Integer> bookList;
    private double totalPrice;




}
