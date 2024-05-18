package org.gfg.jbdlMinor.controller;
import java.util.List;
import org.gfg.jbdlMinor.model.Book;
import org.gfg.jbdlMinor.model.FilterType;
import org.gfg.jbdlMinor.model.Operator;
import org.gfg.jbdlMinor.request.BookCreateRequest;
import org.gfg.jbdlMinor.response.GenericResponse;
import org.gfg.jbdlMinor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody BookCreateRequest bookCreateRequest){
        return bookService.createBook(bookCreateRequest);
    }

    @GetMapping("/filter")
    public ResponseEntity<GenericResponse<List<Book>>> filter(@RequestParam("filterBy") FilterType filterBy,
                                                            @RequestParam("operator") Operator operator,
                                                            @RequestParam("value") String value){
        List<Book> list = bookService.filter(filterBy,operator,value);
        GenericResponse<List<Book>> response = new GenericResponse<>(list, "success","","200");
        ResponseEntity entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }
}
