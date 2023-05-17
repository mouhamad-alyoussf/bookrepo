package restcall;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static restcall.userMethed.scanner;


public class SignIn {
        private static final String API_auth = "http://localhost:8080/api/auth";
        private String username;
        private String password;

        public SignIn() {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your username:");
            this.username = input.nextLine();
            System.out.println("Please enter your password:");
            this.password = input.nextLine();

        }

        public void authenticate() {
            try {
                String requestBody = "{ \"username\": \"" + this.username + "\", \"password\": \"" + this.password + "\" }";
                URL url = new URL(API_auth + "/signin");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(requestBody);
                writer.flush();
                writer.close();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                reader.close();

                String responseJson = responseBuilder.toString();
                System.out.println(responseJson);
                user User = user.fromJson(responseJson);
                System.out.println("Username:"+User.getUsername());
                System.out.println("Email:"+User.getEmail());
                System.out.println("Id:"+User.getId());
                System.out.println("Role :"+User.getRoles());
                if (User.getRoles().contains("ROLE_USER")) {
                    {


                        System.out.println("Welcome to the library!");
                        System.out.println("You can do the following:");
                        System.out.println("1. Sort books by sortingParam");
                        System.out.println("2. Filter books by category or title");
                        System.out.println("3. View all books");
                        System.out.println("4. View a specific book by ID");
                        System.out.println("Please enter your choice (1-5):");
                        userMethed userr=new userMethed();
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice){
                            case 1:
                            {   System.out.println("1. Sort books by title");
                                System.out.println("2. sorting by pagenumber");
                                System.out.println("3.sorting by by ID");
                                System.out.println("Please enter your choice (1-4):");
                                  int num=scanner.nextInt();
                                  String sortingparm="";
                                switch (num){
                                    case 1:{sortingparm="title";
                                    break;}
                                    case 2:{sortingparm="pageCount";
                                    break;}
                                    case 3:{sortingparm="id";
                                        break;}
                                }
                              userr.sortAllBooks(User.getAccessToken(),sortingparm);
                                break;
                            }
                            case 2:
                            {
                                System.out.println("1. filtring  books by title");
                                System.out.println("2. filtring  by categories");
                                System.out.println("Please enter your choice (1 or 2):");
                                int num=scanner.nextInt();
                                scanner.nextLine();

                                switch (num) {
                                    case 1: {
                                        System.out.println("enter the tittle please :");
                                      String   filterparam = scanner.nextLine();
                                        userr.filterBytitle(User.getAccessToken(), filterparam);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("enter the categories please :");
                                      String  filterparam = scanner.nextLine();
                                        userr.filterBycatecory(User.getAccessToken(), filterparam);
                                        break;
                                    }

                                }break;
                            }
                            case 3:
                            {
                                userr.getAllBooks(User.getAccessToken());
                                break;
                            }
                            case 4:
                            {  scanner.nextLine();
                                System.out.println("Enter the id :");
                               String id = scanner.nextLine();
                               userr.getBookById(id,User.getAccessToken());
                                break;
                            }
                        }
                    }

                }
                else if (User.getRoles().contains("ROLE_ADMIN"))
                {
                    {


                        System.out.println("Welcome to the library!");
                        System.out.println("You can do the following:");
                        System.out.println("1. Sort books by sortingParam");
                        System.out.println("2. Filter books by category or title");
                        System.out.println("3. View all books");
                        System.out.println("4. View a specific book by ID");
                        System.out.println("5. Delete a specific book by ID");
                        System.out.println("6. Update a specific book by ID");
                        System.out.println("7. add a new book ");
                        System.out.println("Please enter your choice (1-7):");
                        userMethed userr=new userMethed();
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice){
                            case 1:
                            {
                                System.out.println("1. Sort books by title");
                                System.out.println("2. sorting by pagenumber");
                                System.out.println("3.sorting by by ID");
                                System.out.println("Please enter your choice (1-5):");
                                int num=scanner.nextInt();
                                String sortingparm="";
                                switch (num){
                                    case 1:{sortingparm="title";
                                        break;}
                                    case 2:{sortingparm="pageCount";
                                        break;}
                                    case 3:{sortingparm="id";
                                        break;}
                                }
                                userr.sortAllBooks(User.getAccessToken(),sortingparm);
                                break;
                            }
                            case 2:
                            {
                                System.out.println("1. filtring  books by title");
                                System.out.println("2. filtring  by categories");
                                System.out.println("Please enter your choice (1 or 2):");
                                int num=scanner.nextInt();
                                scanner.nextLine();

                                switch (num) {
                                    case 1: {
                                        System.out.println("enter the tittle please :");
                                        String   filterparam = scanner.nextLine();
                                        userr.filterBytitle(User.getAccessToken(), filterparam);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("enter the categories please :");
                                        String  filterparam = scanner.nextLine();
                                        userr.filterBycatecory(User.getAccessToken(), filterparam);
                                        break;
                                    }

                                }break;
                            }
                            case 3:
                            {
                                userr.getAllBooks(User.getAccessToken());
                                break;
                            }
                            case 4:
                            {  scanner.nextLine();
                                System.out.println("Enter the id :");
                                String id = scanner.nextLine();
                                userr.getBookById(id,User.getAccessToken());
                                break;
                            } case  5:
                            {
                                adminMethed.deleteBookById(User.getAccessToken());
                                break;
                            } case 6:
                            {
                                adminMethed.updateBookById(User.getAccessToken());
                                break;
                            } case 7:{
                                adminMethed.AddNewBook(User.getAccessToken());
                               break;
                            }

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
