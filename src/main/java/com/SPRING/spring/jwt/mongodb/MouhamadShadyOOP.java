package com.SPRING.spring.jwt.mongodb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import restcall.Register;
import restcall.SignIn;

@SpringBootApplication
public class MouhamadShadyOOP {


	private static final String API_auth="http://localhost:8080/api/auth";
	private static final String BASE_URL = "http://localhost:8080/api/v1/bookss";
	public static void main(String[] args) {
		SpringApplication.run(MouhamadShadyOOP.class, args);
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome!");
		String option;
		do{
			System.out.println("Do you want to sign in or register?");
			System.out.print("Enter 's' for sign in or 'r' for register or 'q' for quit : ");
			 option= input.nextLine();

				if (option.equalsIgnoreCase("s")) {
					SignIn signIn = new SignIn();
					signIn.authenticate();
				} else if (option.equalsIgnoreCase("r")) {
					Register register = new Register();
					register.authenticate();
					System.out.println("Registration complete. Please sign in.");
				}
			} while(!option.equalsIgnoreCase("q"));
//		SpringApplication.run(SpringBootSecurityJwtMongodbApplication.class, args);
//		BOOK newBook = new BOOK();
//		newBook.setTitle("My New Book");
//		newBook.setPublishedDate("2022-01-01");
//		newBook.setThumbanilUrl("https://example.com/my-new-book-thumbnail.jpg");
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<List<BOOK>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<BOOK>>(){});
//		List<BOOK> books = responseEntity.getBody();
//
//		ResponseEntity<BOOK> response = restTemplate.postForEntity(
//				BASE_URL + "/add",
//				newBook,
//				BOOK.class
//		);
//
//		System.out.println("New book created: " + response.getBody());
//
//		// get a single book by ID
//		String bookId = "6458418ef00aa49dec607ebf";
//		response = restTemplate.getForEntity(
//				BASE_URL + "/" + bookId,
//				BOOK.class
//		);
//
//		System.out.println("Book with ID " + bookId + ": " + response.getBody());
//
//		// update an existing book by ID
//		BOOK updatedBook = response.getBody();
//
//		updatedBook.setPublishedDate("2023-01-01");
//		updatedBook.setCategories(Arrays.asList("Fiction", "Sci-Fi"));
//
//		restTemplate.put(
//				BASE_URL + "/update/" + bookId,
//				updatedBook
//		);  // delete a book by ID
//
//		System.out.println("lolll");
//		// get all books sorted by title
//		response = restTemplate.getForEntity(
//				BASE_URL + "/sort?sortBy=title",
//				BOOK.class
//		);
//
//		System.out.println("All books sorted by title: " + response.getBody());
//
//		// delete a book by ID
//		restTemplate.delete(
//				BASE_URL + "/delet/" + bookId
//		);
//
//		System.out.println("Book with ID " + bookId + " deleted.");
//	}
		}
	}


