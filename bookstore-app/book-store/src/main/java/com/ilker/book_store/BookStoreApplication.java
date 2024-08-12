package com.ilker.book_store;

import com.ilker.book_store.model.Book;
import com.ilker.book_store.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
	private final BookRepository bookRepository;

    public BookStoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder().name("Kendime Düşünceler").
				price(35)
				.stock(12)
				.author("Marcus Aurelius")
				.build();

		Book book2 = Book.builder().name("Ahlak Mektupları")
				.price(45.20)
				.stock(25)
				.author("Seneca")
				.build();
		Book book3 = Book.builder().name("İnsanları Okumak")
				.price(126.15)
				.author("Jo-Ellan Dimitrus")
				.stock(17)
				.build();
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));

	}
}
