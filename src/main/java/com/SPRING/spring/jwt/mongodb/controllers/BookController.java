package com.SPRING.spring.jwt.mongodb.controllers;



import com.SPRING.spring.jwt.mongodb.repository.BookRepository;
import com.SPRING.spring.jwt.mongodb.Service.BookService;
import com.SPRING.spring.jwt.mongodb.models.BOOK;
import com.SPRING.spring.jwt.mongodb.exeption.BookCollectionExeption;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1/bookss")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookrepo;


    @GetMapping("/sort")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<BOOK>> getAllBooks(
            @RequestParam(value = "sortBy", required = false) String sortBy) {
        try {
            List<BOOK> books;
            if (sortBy == null) {
                books = bookrepo.findAll();
            } else {
                Sort sort = Sort.by(sortBy);
                books = bookrepo.findAll(sort);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getSingelbook(@PathVariable("id") ObjectId id) {
        Optional<BOOK> bookOptional = bookrepo.findById(id);
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("BOOK not fount with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllBooks() {
        bookrepo.findAll();
        List<BOOK> books = bookService.getAllBook();
        return new ResponseEntity<>(books, books.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

    @PostMapping("/add")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addBook(@RequestBody BOOK book) {
        try {
            bookService.createBook(book);
            return new ResponseEntity<BOOK>(book, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (BookCollectionExeption e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> updateById(@PathVariable("id") ObjectId id, @RequestBody BOOK book) {
        Optional<BOOK> bookOptional = bookrepo.findById(id);
        if (bookOptional.isPresent()) {
            BOOK bookSave = bookOptional.get();
            bookSave.setPublishedDate(book.getPublishedDate() != null ? book.getPublishedDate() : bookSave.getPublishedDate());
            bookSave.setTitle(book.getTitle() != null ? book.getTitle() : bookSave.getTitle());
            bookSave.setThumbanilUrl(book.getThumbanilUrl() != null ? book.getThumbanilUrl() : bookSave.getThumbanilUrl());
            bookSave.setLongDescription(book.getLongDescription() != null ? book.getLongDescription() : bookSave.getLongDescription());
            bookSave.setCategories(book.getCategories() != null ? book.getCategories() : bookSave.getCategories());
            bookrepo.save(bookSave);
            return new ResponseEntity<>(bookSave, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("BOOK NOT FOUNT WITH ID" + id, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delet/{id}")
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable("id") ObjectId id) {
        try {
            bookrepo.deleteById(id);
            return new ResponseEntity<>("Successfully deleted with id " + id, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filterBytitle/{title}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<BOOK>> getBooksByTitle(@PathVariable String title) {
        return new ResponseEntity<List<BOOK>>(bookService.getBookByTitle(title), HttpStatus.OK);

    }

    @GetMapping("/filterBycategory/{category}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<BOOK>> getBooksByCategory(@PathVariable String category) {
        List<BOOK> books = bookService.getBooksByCategory(category);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
    }
    @GetMapping("/page")
    public Page<BOOK>listbookpage(Pageable p){
        return  bookrepo.findAll(p);
    }
}
