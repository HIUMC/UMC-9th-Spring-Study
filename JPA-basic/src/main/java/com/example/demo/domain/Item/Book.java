package com.example.demo.domain.Item;

import com.example.demo.web.BookForm;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("B")
@Getter
public class Book extends Item {

    private String author;
    private String isbn;

    //==생성 메서드==//
    public static Book createBook(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.author = form.getAuthor();
        book.isbn = form.getIsbn();
        return book;
    }
}