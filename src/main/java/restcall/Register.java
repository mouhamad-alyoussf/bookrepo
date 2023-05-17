package restcall;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;



    public class Register {
        private static final String API_auth = "http://localhost:8080/api/auth/";

        private String username;
        private String email;
        private String password;

        public Register() {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your username:");
            this.username = input.nextLine();
            System.out.println("Please enter your email address:");
            this.email = input.nextLine();
            System.out.println("Please enter your password:");
            this.password = input.nextLine();
            input.close();
        }


        public void authenticate() {
         try {



                String requestBody = "{ \"username\": \"" + this.username +"\", \"email\": \"" + this.email + "\", \"password\": \"" + this.password + "\" }";
                URL url = new URL(API_auth + "signup");
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


//                reader.close();
//             String responseJson = responseBuilder.toString();
//             user User = user.fromJson(responseJson);
//             System.out.println(responseJson);
//             System.out.println("Username:"+User.getUsername());
//             System.out.println("Email:"+User.getEmail());
//             System.out.println("Id:"+User.getId());
//             System.out.println("Role :"+User.getRoles());


             }
         catch (Exception e) {
            e.printStackTrace();
        }}
    }