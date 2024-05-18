package org.gfg.jbdlMinor.service;

import org.gfg.jbdlMinor.model.*;
import org.gfg.jbdlMinor.repository.AuthorRepository;
import org.gfg.jbdlMinor.repository.BookRepository;
import org.gfg.jbdlMinor.request.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(BookCreateRequest bookCreateRequest) {
        Author authorFromDB = authorRepository.findByEmail(bookCreateRequest.getAuthorEmail());

        if(authorFromDB == null){
            //create a row in author as well
            authorFromDB = authorRepository.save(bookCreateRequest.toAuthor());
        }
        //create a row in book
        Book book = bookCreateRequest.toBook();
        book.setAuthor(authorFromDB);
        return bookRepository.save(book);

    }

    public List<Book> filter(FilterType filterBy, Operator operator, String value) {
        switch (operator){
            case EQUALS :
                switch (filterBy){
                    case BOOK_NO :
                        return bookRepository.findByBookNo(value);
                    case AUTHOR_NAME:
                        return bookRepository.findByAuthorName(value);
                    case COST:
                        return bookRepository.findByCost(Integer.valueOf(value));
                    case BOOKTYPE:
                        return bookRepository.findByType(BookType.valueOf(value));
                }
            case LESS_THAN:
                switch (filterBy){
                    case COST:
                        return bookRepository.findByCostLessThan(Integer.valueOf(value));
                }
            default:
                return new ArrayList<>();
        }
    }

    public void saveUpdate(Book book){
        bookRepository.save(book);
    }
}
