package sample;

import java.util.ArrayList;

public class book {
    private String name;
    private String pub;
    private String desc;
    private String borrowing=null;
    private int Duration_of_Request;
    private String Duration_of_Accepting_Time;

    //situation   status


    public static ArrayList<Category> categories =new ArrayList<>();
    public static ArrayList<wt> writer =new ArrayList <>();
    public static ArrayList<String> translator=new ArrayList<>();
    public  ArrayList<String> Requests =new ArrayList<>();
    public  ArrayList<String> Requests_Duration =new ArrayList<>();






    /*
    private ArrayList<wt> writter =new ArrayList<>();
    private ArrayList<String> translator =new ArrayList<>();
   // private ArrayList<Integer> categories =new ArrayList<>();
    private String publisher;
    private String discription;
    ArrayList<Category> categories =new ArrayList<>();
    public book(String name, ArrayList<wt> writter, ArrayList<String> translator, ArrayList<Integer> categories, String publisher, String discription) {
        this.name = name;
        this.writter = writter;
        this.translator = translator;
        this.categories = categories;
        this.publisher = publisher;
        this.discription = discription;
    }

    */

    public book(String name, String publisher, String discription) {
        this.name = name;
        this.pub = pub;
        this.desc = desc;
    }
    public book() {

    }

    public  ArrayList<String> getRequests() {
        return Requests;
    }

    public  void setRequests(ArrayList<String> requests) {
        Requests = requests;
    }


    public  ArrayList<Category> getCategories() {
        return categories;
    }

    public static void setCategories(ArrayList<Category> categories) {
        book.categories = categories;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
/*
    public ArrayList<Integer> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }*/


    public ArrayList<String> getTranslator() {
        return translator;
    }

    public void setTranslator(ArrayList<String> translator) {
        this.translator = translator;
    }

    public ArrayList<wt> getWriter() {
        return writer;
    }

    public void setWriter(ArrayList<wt> writer) {
        this.writer = writer;
    }

    public String getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(String borrowing) {
        this.borrowing = borrowing;
    }


    public String getDuration_of_Accepting_Time() {
        return Duration_of_Accepting_Time;
    }

    public void setDuration_of_Accepting_Time(String duration_of_Accepting_Time) {
        Duration_of_Accepting_Time = duration_of_Accepting_Time;
    }

    public int getDuration_of_Request() {
        return Duration_of_Request;
    }

    public void setDuration_of_Request(int duration_of_Request) {
        Duration_of_Request = duration_of_Request;
    }
}
