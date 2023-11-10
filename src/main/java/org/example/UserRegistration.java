package org.example;
//User Registration and Login using Java Methods
//What to do: Create methods for registering a new user and logging in.
// Store username and password in a hashmap.
//Expected: Two separate methods, one for registration and one for login.
// New users should be stored in memory for now.
import java.util.*;

public class UserRegistration {

    private HashMap< String, String > userLoginDetails = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the User Name : ");

        String userInput = scanner.nextLine();

        System.out.println("Enter the password : ");

        String password = scanner.nextLine();

        userRegistration("user1" , "abc1234");


        loginUser(userInput , password);


    }

    public static void userRegistration(String username , String password){

        if(!userLoginDetails.containsKey(username)) {
            userLoginDetails.put(username, password);

            System.out.println("User Registration sucessful ! ");
        }
        else {

            System.out.println("User already exists. User Registration failed ! ");
        }

    }


    public static void loginUser(String username , String password){

        if(userLoginDetails.containsKey(username)){
            userLoginDetails.put(username , password);

            System.out.println("User logged in !");
        }
        else {
            System.out.println(" Incorrect username or password ");
        }

    }

}
