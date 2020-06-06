package edu.au.cc.gallery.tool;
import java.util.*;
public class S3ACLAdmin {

    /**
     * this program is simulates a rudimentary database management system.
     */


        public static class user{
            public String userName;
            public String password;
            public String fullName;

            public user(String userNameIn, String passwordIn, String fullNameIn){
                userName = userNameIn;
                password = passwordIn;
                fullName = fullNameIn;
            }
            public user(String userNameIn){
                userName = userNameIn;
            }
            public String toString(){
                return String.format("%10s %10s %10s", userName, password, fullName);
            }

            //getter and setters
            public void setFullName(String newName){
                fullName = newName;
            }

            public void setPassword(String newPassword){
                password = newPassword;
            }

            public String getPassword(){
                return password;
            }

        }





        public static void main(String[] args){
            ArrayList<user> userList = new ArrayList<>();
            String userNameIn;
            String passwordIn;
            String fullNameIn;


            do {
                System.out.println("1 = List User");
                System.out.println("2 = Add User");
                System.out.println("3 = Edit User");
                System.out.println("4 = Delete User");
                System.out.println("5 = Quit Program");

                System.out.println("Enter Desired Option");

                Scanner scan = new Scanner(System.in);
                //parses input, convert to int
                String input = scan.nextLine();
                int option = Integer.parseInt(input);


                switch (option) {

                    //returns list of users
                    case 1:

                        System.out.println("Username    Password    Full Name");
                        System.out.println("----------------------------------");


                        for(int i = 0; i < userList.size(); i++) {
                            System.out.println(userList.get(i).toString()); //returns class instead of test list
                            System.out.println();
                        }
                        break;


                    //add user function
                    case 2:
                        System.out.println("Enter Username: ");
                        userNameIn = scan.nextLine();
                        boolean duplicateFound = false;
                        //check for duplicate name
                        for(int i = 0; i < userList.size(); i++) {
                            if (userList.get(i).userName.equals(userNameIn)) {
                                System.out.println("Error: user with username " + userNameIn + " already exists");
                                duplicateFound = true;
                                break;
                            }

                        }
                        if (duplicateFound) {
                            break;
                        }

                        System.out.println("Enter password: ");
                        passwordIn = scan.nextLine();
                        System.out.println("Enter full name");
                        fullNameIn = scan.nextLine();

                        //add object to list
                        user User = new user(userNameIn, passwordIn, fullNameIn);
                        userList.add(User);
                        break;


                    //edit user function
                    case 3:
                        System.out.println("Enter Username of User to edit");
                        userNameIn = scan.nextLine();
                        boolean nameFound = false;
                        for(int i = 0; i < userList.size(); i++) {

                            if (userList.get(i).userName.equals(userNameIn)) {

                                System.out.println("Enter new password");
                                userList.get(i).setPassword(scan.nextLine());

                                System.out.println("Enter Full Name");
                                userList.get(i).setFullName(scan.nextLine());
                                nameFound = true;
                                break;

                            }


                        }

                        if (!nameFound) {
                            System.out.println("invalid username");

                        }
                        break;



                    //delete function
                    case 4:
                        System.out.println("Enter username to delete: ");
                        userNameIn = scan.nextLine();
                        for(int i = 0; i < userList.size(); i++){
                            if (userList.get(i).userName.equals(userNameIn)){
                                String temp;
                                System.out.println("are you sure you want to delete " + userNameIn + "? Y/N");
                                temp = scan.nextLine().toUpperCase();
                                if (temp.equals("Y")) {
                                    userList.remove(i);
                                    System.out.println("Deleted.");

                                }
                                break;
                            }
                        }

                        break;
                    //exit function
                    case 5:
                        System.out.println("Later, Nerd.");
                        System.exit(0);
                }


            } while(true);
        }









}
