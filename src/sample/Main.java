package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    static Adminstrator adminstrator = new Adminstrator("dan@dan.com","dan");
    static ArrayList<User> members = new ArrayList<>();
    public static ObservableList List_ALL_User= FXCollections.observableArrayList();
    //static ArrayList<Category> categories = new ArrayList<>();

    static User logged_user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
      Thread t=new Thread(new multithreads());
        t.setDaemon(true);
        t.start();

    }
}
