package com.SPRING.spring.jwt.mongodb.controllers;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.SPRING.spring.jwt.mongodb.Service.BookService;
import com.SPRING.spring.jwt.mongodb.exeption.BookCollectionExeption;
import com.SPRING.spring.jwt.mongodb.models.BOOK;
import com.SPRING.spring.jwt.mongodb.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import javax.validation.ConstraintViolationException;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#getAllBooks()}
     */
    @Test
    void testGetAllBooks7() throws Exception {
        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("?");
        book.setLongDescription("?");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("?");
        book.setStatus("?");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());

        ArrayList<BOOK> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookService.getAllBook()).thenReturn(bookList);
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"_id\":{\"timestamp\":1684303875,\"date\":1684303875000},\"id\":1,\"title\":\"Dr\",\"isbn\":\"?\",\"pageCount\":3,"
                                        + "\"publishedDate\":\"2020-03-01\",\"thumbanilUrl\":\"https://example.org/example\",\"shortDescription\":\"?\","
                                        + "\"longDescription\":\"?\",\"status\":\"?\",\"authors\":[],\"categories\":[]}]"));
    }

    /**
     * Method under test: {@link BookController#getSingelbook(ObjectId)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSingelbook() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        BookController bookController = new BookController();
        bookController.getSingelbook(ObjectId.get());
    }

    /**
     * Method under test: {@link BookController#getSingelbook(ObjectId)}
     */
    @Test
    void testGetSingelbook2() throws Exception {
        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("Isbn");
        book.setLongDescription("Long Description");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("Short Description");
        book.setStatus("Status");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());
        Optional<BOOK> ofResult = Optional.of(book);
        when(bookRepository.findById(Mockito.<ObjectId>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/{id}", ObjectId.get());
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"_id\":{\"timestamp\":1684303943,\"date\":1684303943000},\"id\":1,\"title\":\"Dr\",\"isbn\":\"Isbn\",\"pageCount\":3"
                                        + ",\"publishedDate\":\"2020-03-01\",\"thumbanilUrl\":\"https://example.org/example\",\"shortDescription\":\"Short"
                                        + " Description\",\"longDescription\":\"Long Description\",\"status\":\"Status\",\"authors\":[],\"categories\":[]}"));
    }

    /**
     * Method under test: {@link BookController#updateById(ObjectId, BOOK)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        BookController bookController = new BookController();
        ObjectId id = ObjectId.get();

        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("Isbn");
        book.setLongDescription("Long Description");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("Short Description");
        book.setStatus("Status");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());
        bookController.updateById(id, book);
    }

    /**
     * Method under test: {@link BookController#updateById(ObjectId, BOOK)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateById2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        BookController bookController = new BookController();
        ObjectId id = ObjectId.get();
        BOOK book = mock(BOOK.class);
        doNothing().when(book).setAuthors(Mockito.<List<String>>any());
        doNothing().when(book).setCategories(Mockito.<List<String>>any());
        doNothing().when(book).setId(anyInt());
        doNothing().when(book).setIsbn(Mockito.<String>any());
        doNothing().when(book).setLongDescription(Mockito.<String>any());
        doNothing().when(book).setPageCount(anyInt());
        doNothing().when(book).setPublishedDate(Mockito.<String>any());
        doNothing().when(book).setShortDescription(Mockito.<String>any());
        doNothing().when(book).setStatus(Mockito.<String>any());
        doNothing().when(book).setThumbanilUrl(Mockito.<String>any());
        doNothing().when(book).setTitle(Mockito.<String>any());
        doNothing().when(book).set_id(Mockito.<ObjectId>any());
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("Isbn");
        book.setLongDescription("Long Description");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("Short Description");
        book.setStatus("Status");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());
        bookController.updateById(id, book);
    }

    /**
     * Method under test: {@link BookController#addBook(BOOK)}
     */
    @Test
    void testAddBook() throws Exception {
        doThrow(new ConstraintViolationException(new HashSet<>())).when(bookService).createBook(Mockito.<BOOK>any());

        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("Isbn");
        book.setLongDescription("Long Description");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("Short Description");
        book.setStatus("Status");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/bookss/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(422))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    /**
     * Method under test: {@link BookController#deleteById(ObjectId)}
     */
    @Test
    void testDeleteById() throws Exception {
        doThrow(new ConstraintViolationException(new HashSet<>())).when(bookRepository)
                .deleteById(Mockito.<ObjectId>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/bookss/delet/{id}",
                ObjectId.get());
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    /**
     * Method under test: {@link BookController#getBooksByCategory(String)}
     */
    @Test
    void testGetBooksByCategory() throws Exception {
        when(bookService.getBooksByCategory(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/bookss/filterBycategory/{category}", "Category");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link BookController#getBooksByCategory(String)}
     */
    @Test
    void testGetBooksByCategory2() throws Exception {
        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("?");
        book.setLongDescription("?");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("?");
        book.setStatus("?");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());

        ArrayList<BOOK> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookService.getBooksByCategory(Mockito.<String>any())).thenReturn(bookList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/bookss/filterBycategory/{category}", "Category");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"_id\":{\"timestamp\":1684303924,\"date\":1684303924000},\"id\":1,\"title\":\"Dr\",\"isbn\":\"?\",\"pageCount\":3,"
                                        + "\"publishedDate\":\"2020-03-01\",\"thumbanilUrl\":\"https://example.org/example\",\"shortDescription\":\"?\","
                                        + "\"longDescription\":\"?\",\"status\":\"?\",\"authors\":[],\"categories\":[]}]"));
    }

    /**
     * Method under test: {@link BookController#listbookpage(Pageable)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testListbookpage() {

        (new BookController()).listbookpage(null);
    }

    /**
     * Method under test: {@link BookController#addBook(BOOK)}
     */
    @Test
    void testAddBook2() throws Exception {
        doThrow(new BookCollectionExeption("Not all who wander are lost")).when(bookService)
                .createBook(Mockito.<BOOK>any());

        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("Isbn");
        book.setLongDescription("Long Description");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("Short Description");
        book.setStatus("Status");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/bookss/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(409))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Not all who wander are lost"));
    }

    /**
     * Method under test: {@link BookController#getAllBooks()}
     */
    @Test
    void testGetAllBooks() throws Exception {
        when(bookService.getAllBook()).thenReturn(new ArrayList<>());
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getAllBooks()}
     */
    @Test
    void testGetAllBooks2() throws Exception {
        BOOK book = new BOOK();
        book.setAuthors(new ArrayList<>());
        book.setCategories(new ArrayList<>());
        book.setId(1);
        book.setIsbn("?");
        book.setLongDescription("?");
        book.setPageCount(3);
        book.setPublishedDate("2020-03-01");
        book.setShortDescription("?");
        book.setStatus("?");
        book.setThumbanilUrl("https://example.org/example");
        book.setTitle("Dr");
        book.set_id(ObjectId.get());

        ArrayList<BOOK> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookService.getAllBook()).thenReturn(bookList);
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"_id\":{\"timestamp\":1684296136,\"date\":1684296136000},\"id\":1,\"title\":\"Dr\",\"isbn\":\"?\",\"pageCount\":3,"
                                        + "\"publishedDate\":\"2020-03-01\",\"thumbanilUrl\":\"https://example.org/example\",\"shortDescription\":\"?\","
                                        + "\"longDescription\":\"?\",\"status\":\"?\",\"authors\":[],\"categories\":[]}]"));
    }

    /**
     * Method under test: {@link BookController#getAllBooks(String)}
     */
    @Test
    void testGetAllBooks3() throws Exception {
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/sort");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getAllBooks(String)}
     */
    @Test
    void testGetAllBooks4() throws Exception {
        when(bookRepository.findAll(Mockito.<Sort>any())).thenReturn(new ArrayList<>());
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/sort")
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getAllBooks(String)}
     */
    @Test
    void testGetAllBooks5() throws Exception {
        when(bookRepository.findAll(Mockito.<Sort>any())).thenReturn(new ArrayList<>());
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/sort")
                .param("sortBy", "");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link BookController#getAllBooks(String)}
     */
    @Test
    void testGetAllBooks6() throws Exception {
        when(bookRepository.findAll(Mockito.<Sort>any())).thenThrow(new ConstraintViolationException(new HashSet<>()));
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/sort")
                .param("sortBy", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link BookController#getBooksByTitle(String)}
     */
    @Test
    void testGetBooksByTitle() throws Exception {
        when(bookService.getBookByTitle(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookss/filterBytitle/{title}",
                "Dr");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

