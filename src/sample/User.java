package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {

        private String name;
        private String email;
        private int pass;
        private String forget_pass;


        private String ID;
        //private  //ArrayList<Category> category_user=new ArrayList<>();
        public User(String name, String email, int pass, String ID,String forget_pass) {
            this.name = name;
            this.email = email;
            this.pass = pass;
            this.ID = ID;
            this.forget_pass = forget_pass;

        }

        //ArrayList<Category> category_user =new ArrayList<>();
        public ArrayList<book> books_user =new ArrayList<>();
        public ArrayList<String> ls_books =new ArrayList<>();
        public  ArrayList<book> General_Book_List =new ArrayList<>();
        public  ArrayList<book> Borrowed_Book =new ArrayList<>();

        public ObservableList List_ALL_Books= FXCollections.observableArrayList();
        public ObservableList List_General= FXCollections.observableArrayList();





        public  ArrayList<book> getGeneral_Book_List() {
            return General_Book_List;
        }

        public  void setGeneral_Book_List(ArrayList<book> general_Book_List) {
            General_Book_List = general_Book_List;
        }

        public  ArrayList<book> getBooks_user() {
            return books_user;
        }

        public void setBooks_user(ArrayList<book> books_user) {
            this.books_user = books_user;
        }

//    public  void setBooks_user(ArrayList<book> books_user) {
//        User.books_user = books_user;
//    }



        /*public static ArrayList<book> getBooks_user() {
            return books_user;
        }
        */
   /* public static void setBooks_user(ArrayList<book> books_user) {
        User.books_user = books_user;
    }
    */
        public String getForget_pass() {
            return forget_pass;
        }

        public void setForget_pass(String forget_pass) {
            this.forget_pass = forget_pass;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }



        public int getPass() {
            return pass;
        }

        public void setPass(int pass) {
            this.pass = pass;
        }
        public String getID() {
            return ID;
        }
        public void setID(String ID) {
            this.ID = ID;
        }

        public User() {

        }

    public ArrayList<String> getLs_books() {
        return ls_books;
    }

    public void setLs_books(ArrayList<String> ls_books) {
        this.ls_books = ls_books;
    }
}


