package sample;

import java.util.ArrayList;

public class Category {

    private String name;
    public  ArrayList<Category> sub =new ArrayList<>();

    public Category(String name ) {
        this.name = name;
    }





    //private Category sub=new Category();



    public Category() {

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getSub() {
        return sub;
    }

    public void setSub(ArrayList<Category> sub) {
        this.sub = sub;
    }


//    public ArrayList<Category> getSub_category() {
//        return sub_category;
//    }
//
//    public void setSub_category(ArrayList<Category> sub_category) {
//        this.sub_category = sub_category;
//    }

}
