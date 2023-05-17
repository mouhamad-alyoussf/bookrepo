package restcall;

import com.SPRING.spring.jwt.mongodb.models.BOOK;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class userMethed{

    public  static Scanner scanner = new Scanner(System.in);
    public void getBookById(String bookId, String token) {
        try {
            String API_books = "http://localhost:8080/api/v1/bookss";
            URL urll = new URL(API_books + "/" + bookId);
            HttpURLConnection connn = (HttpURLConnection) urll.openConnection();
            connn.setRequestMethod("GET");
            connn.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader reeader = new BufferedReader(new InputStreamReader(connn.getInputStream()));
            StringBuilder reesponseBuilder = new StringBuilder();
            String lline;
            while ((lline = reeader.readLine()) != null) {
                reesponseBuilder.append(lline);
            }
            reeader.close();

            String reesponseJson = reesponseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BOOK book = objectMapper.readValue(reesponseJson, BOOK.class);
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author(s): " + book.getAuthors());
            System.out.println("Description: " + book.getLongDescription());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getAllBooks(String token){
        try {
            String API_books = "http://localhost:8080/api/v1/bookss";
            URL url = new URL(API_books);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BOOK[] books = objectMapper.readValue(responseJson, BOOK[].class);
            for (BOOK book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author(s): " + book.getAuthors());
                System.out.println("Description: " + book.getLongDescription());
            }

        } catch (Exception e) {

        }

    }
    public void sortAllBooks(String token,String sortingparm){
        try {
            String API_books = "http://localhost:8080/api/v1/bookss/sort?sortBy=";
            URL urll = new URL(API_books+sortingparm);
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BOOK[] books = objectMapper.readValue(responseJson, BOOK[].class);
            for (BOOK book : books) {
                System.out.println("id2 :"+book.getId());
                System.out.println("PageCount:"+book.getPageCount());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author(s): " + book.getAuthors());
                System.out.println("Description: " + book.getLongDescription());
            }

        } catch (Exception e) {

        }

    }
    public void filterBytitle(String token, String filterparam) {
        try {
            String API_books = "http://localhost:8080/api/v1/bookss/filterBytitle/";
            URL urll = new URL(API_books+filterparam);
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BOOK[] books = objectMapper.readValue(responseJson, BOOK[].class);
            for (BOOK book : books) {
                System.out.println("id2 :"+book.getId());
                System.out.println("PageCount:"+book.getPageCount());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author(s): " + book.getAuthors());
                System.out.println("Description: " + book.getLongDescription());
            }

        } catch (Exception e) {

        }

    }
    public void filterBycatecory(String token, String filterparam){
        try {
            String API_books = "http://localhost:8080/api/v1/bookss/filterBycategory/";
            URL urll = new URL(API_books+filterparam);
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            String responseJson = responseBuilder.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BOOK[] books = objectMapper.readValue(responseJson, BOOK[].class);
            for (BOOK book : books) {
                System.out.println("id2 :"+book.getId());
                System.out.println("PageCount:"+book.getPageCount());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author(s): " + book.getAuthors());
                System.out.println("Description: " + book.getLongDescription());
            }

        } catch (Exception e) {

        }

    }
}