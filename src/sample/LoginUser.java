package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUser {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean login(String username1, String pass1)
    {

        boolean f1 = false;
        boolean f2 = false;
        int hashed =pass1.hashCode();
        for (int i = 0; i <Main.members.size() ; i++) {
            if(username1.equals(Main.members.get(i).getEmail()))
            {
                f1 = true;
            }
        }
        for (int i = 0; i < Main.members.size(); i++) {
            if(hashed==Main.members.get(i).getPass())
            {
                f2 = true;
                Main.logged_user = Main.members.get(i);

            }
        }
        if(f1 ==true &&f2 ==true)
        {
            return true;
        }else {
            // Main.logged_user = null;
            return false;

        }
    }
    public boolean Admin_Login(String username1, String pass1)
    {

        boolean t1 = false;
        boolean t2 = false;
        int hashed =pass1.hashCode();

            if(username1.equals(Main.adminstrator.getEmail()))
            {
                t1 = true;
            }

            if(hashed==Main.adminstrator.getPass().hashCode())
            {
                t2 = true;
//                Main.logged_user = Main.members.get(i);

            }

        if(t1 ==true &&t2 ==true)
        {
            return true;
        }else {
            // Main.logged_user = null;
            return false;

        }
    }
}
