package restcall;

import com.SPRING.spring.jwt.mongodb.models.BOOK;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;


public   class  adminMethed extends userMethed {
    private static final String BASE_URL = "http://localhost:8080/api/v1/bookss";

    public static void AddNewBook(String token) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the published date (yyyy-MM-dd): ");
        String publishedDate = scanner.nextLine();

        System.out.print("Enter the thumbnail URL: ");
        String thumbnailUrl = scanner.nextLine();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        BOOK newBook = new BOOK();
        newBook.setTitle(title);
        newBook.setPublishedDate(publishedDate);
        newBook.setThumbanilUrl(thumbnailUrl);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BOOK> request = new HttpEntity<>(newBook, headers);
        ResponseEntity<BOOK> response = restTemplate.exchange(
                BASE_URL + "/add",
                HttpMethod.POST,
                request,
                BOOK.class
        );

        System.out.println("New book created: " + response.getBody());
    }
    public static void deleteBookById(String token) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the book to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Void> response = restTemplate.exchange(
                BASE_URL + "/delete/" + bookId,
                HttpMethod.DELETE,
                request,
                Void.class
        );

        System.out.println("Book deleted with status code: " + response.getStatusCodeValue());
    }
    public static void updateBookById(String token) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the book to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter the updated title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the updated published date (yyyy-MM-dd): ");
        String publishedDate = scanner.nextLine();

        System.out.print("Enter the updated thumbnail URL: ");
        String thumbnailUrl = scanner.nextLine();

        BOOK updatedBook = new BOOK();
        updatedBook.setTitle(title);
        updatedBook.setPublishedDate(publishedDate);
        updatedBook.setThumbanilUrl(thumbnailUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BOOK> request = new HttpEntity<>(updatedBook, headers);
        ResponseEntity<Void> response = restTemplate.exchange(BASE_URL + "/update/" + bookId, HttpMethod.PUT, request, Void.class);
        System.out.println("Book updated with status code: " + response.getStatusCodeValue());
    }


}
