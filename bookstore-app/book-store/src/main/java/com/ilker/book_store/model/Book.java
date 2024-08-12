package com.ilker.book_store.model;

import jakarta.persistence.*;
import lombok.*;

@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String author;
    private double price;
    private int stock;

}
