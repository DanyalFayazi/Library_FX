package sample;

import javax.swing.*;
import java.text.ParseException;

import static sample.Controller.Difference_of_two_time;
import static sample.Controller.time;

public class multithreads implements Runnable {

    public void run() {
        while (true) {
            synchronized (Thread.currentThread()) {
                try {
                    Thread.currentThread().wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("CALLED");
            if(Main.logged_user == null)
                continue;
            System.out.println("CALLED1");
            for (int i = 0; i < Main.logged_user.getGeneral_Book_List().size(); i++)
            {
                if (Main.logged_user.getGeneral_Book_List().get(i).getBorrowing() == null)
                    continue;
                try
                {
                    System.out.println("CALLED2");
                    if (Difference_of_two_time(Main.logged_user.General_Book_List.get(i).getDuration_of_Accepting_Time(), time()) > Main.logged_user.General_Book_List.get(i).getDuration_of_Request())
                    {
                        System.out.println("CALLED3");
                        String[] name = Main.logged_user.books_user.get(i).getName().split("[-]");
                        Main.logged_user.books_user.get(i).setName(name[0]);
                        User user = new User();
                        for (int j = 0; j < Main.members.size(); j++) {
                            if (Main.members.get(j).getID().equals(Main.logged_user.General_Book_List.get(j).getBorrowing())) {
                                user = Main.members.get(j);
                                for (int k = 0; k < user.Borrowed_Book.size(); k++) {
                                    if (user.Borrowed_Book.get(k).getName().equals(name[0])) {
                                        JOptionPane.showMessageDialog(null, name[0] + " has returned to your Book list");
                                        user.Borrowed_Book.remove(k);

                                    }
                                }
                            }
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
