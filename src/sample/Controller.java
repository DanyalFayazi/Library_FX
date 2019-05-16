package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.peer.LabelPeer;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.ResourceBundle;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;


//public class Controller implements Initializable {
public class Controller  {


    @FXML
    private Button test;
    @FXML
    private Button SignUp;
    @FXML
    private Button Login;
    @FXML
    private Button Add_Book;
    @FXML
    private Button Edit_Book;
    @FXML
    private Button Request_Book;
    @FXML
    private Button Give_Book_to_Others;
    @FXML
    private Button Refresh;
    @FXML
    private Button forget_password;
    @FXML
    private Button Administrator;
    @FXML
    private Button admin_remove;
    @FXML
    private Button ch_user_name;
    @FXML
    private Button Show_user;
    @FXML
    private Button home;
    @FXML
    private Button Search_user;
    @FXML
    private Button user_Gbooks;
    @FXML
    private Button add_to_gen;


    @FXML
    private Label refresh_status;
    @FXML
    private Label email_status1;
    @FXML
    private Label email_status2;
    @FXML
    private Label login_status;

    @FXML
    private TextField names;
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtadminname;
    @FXML
    private PasswordField txtpassword_admin;
    @FXML
    private RadioButton general_books;
    @FXML
    private RadioButton all_books;
    @FXML
    public ListView<String> ls_books;
    @FXML
    public ListView<String> ls_users;
    @FXML
    public ListView<String> searched_user;
    @FXML
    public ListView<String> G_b;


    //ObservableList<String> List_ALL_Books=FXCollections.observableArrayList(Main.logged_user.ls_books);


    //user@user.com
    public void LoginUser(ActionEvent event) throws ParseException, IOException {
        //ActionEvent event = new ActionEvent();
            LoginUser Log = new LoginUser();
            boolean test = Log.login(txtusername.getText(), txtpassword.getText());
            if (test != true) {
             login_status.setText("You cann't enter your panel.please try again");        //  JOptionPane.showMessageDialog(null, "You can not enter your panel.\nplease");
                 LoginUser(event);

            }
        Thread t=new Thread(new multithreads());
        t.start();
        login_status.setText("You've been Login Successfully");

        email_status1.setText("");
        email_status2.setText("");

        Parent root = FXMLLoader.load(getClass().getResource("User Menu.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource(SceneName));
        Scene rootScene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
        //   Ad_User(event, root);
//        primaryStage1.setTitle("User Menu");
//        primaryStage1.setScene(new Scene(root, 300, 275));
//        primaryStage1.show();

    }

    public void Send_Email(String user_email, String user_password, String massage){
        String host = "smtp.gmail.com";
        String from = "danyalfayazi7@gmail.com";
        String pass = "d09336334045";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host",host );
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        String[] to = {user_email}; // added this line
        try {
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) { // changed from a while loop
                toAddress[i] = new InternetAddress(to[i]);
            }
          //  System.out.println(Message.RecipientType.TO);
            email_status1.setText("New password sent to your email");
            email_status2.setText("please change it in your panel");
            for (int i = 0; i < toAddress.length; i++) { // changed from a while loop
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            message.setSubject("Forget password?-Your local Library");
            message.setText(massage);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException mx) {
            mx.printStackTrace();
        }


    }

    public static int findBook_Index(ArrayList<book> bookArrayList) {
        int temp1 = 0;
        String bookName = JOptionPane.showInputDialog("Enter the the name of your book that you want to reach!!!");
        for (int i = 0; i <= bookArrayList.size() - 1; i++) {
            if (bookArrayList.get(i).getName().equals(bookName)) {
                temp1 = i;
                break;
            }
        }

        return temp1;
    }

    public static book findBook_Object(ArrayList<book> books) throws ParseException {
        int tmp = 0;
         boolean flag=false;
        String book_name = JOptionPane.showInputDialog("Enter the the name of your book that you want to reach!!!");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book_name)) {
                //return books.get(i).getSub_category();
                tmp = i;
                 flag=true;

                 break;
            }
        }
        if (flag==false){
            JOptionPane.showMessageDialog(null,"Can not find this book\nplease try again");
            findBook_Index(books);
        }
        return books.get(tmp);
    }

    public static String time(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("DD:hh:mm");
        return sdf.format(cal.getTime()) ;
    }
    public static long Difference_of_two_time(String time1,String time2) throws ParseException {

        //String time3 = "106:00:00";
        String[] Time1=time1.split("[:/.,]");
        String[] Time2=time2.split("[:/.,]");
        int sum1=0;
        int sum2=0;
        for (int i = 0; i <Time1.length ; i++) {
            sum1 += Integer.parseInt(Time1[i]);
        }
        for (int i = 0; i <Time2.length ; i++) {
            sum2 += Integer.parseInt(Time2[i]);
        }
        long Difference=sum2-sum1;
        return Difference;
    }

    public void addUser(ActionEvent event) {
        String name = JOptionPane.showInputDialog("Enter Name :");
        String pass = JOptionPane.showInputDialog("Enter password :");
        String fpass = JOptionPane.showInputDialog("what is your phone Number ");
        String email = JOptionPane.showInputDialog("Enter email :");
        int id = (int) (Math.random() * Main.members.size() + 1);
        int hashed = pass.hashCode();

        User add_user = new User(name, email, hashed, Integer.toString(id), fpass);

        while (true) {

            if (LoginUser.validate(add_user.getEmail())) {

                Main.members.add(add_user);
                Main.List_ALL_User.add(add_user.getName());
                System.out.println(add_user.getEmail() + "    &&&   " + add_user.getPass());

                break;

            } else if (!LoginUser.validate(add_user.getEmail())) {
                JOptionPane.showMessageDialog(null, "Email is not valid!");
                add_user.setEmail(JOptionPane.showInputDialog("Enter email :"));

            }
        }

    }

    public void Add_Book(ActionEvent event) throws IOException, ParseException {

        String name = JOptionPane.showInputDialog("Enter Name of book :");
        String pub = JOptionPane.showInputDialog("Enter pub of book :");
        String desc = JOptionPane.showInputDialog("Enter desc of book :");
        book tmp = new book(name, pub, desc);

        Main.logged_user.ls_books.add(name);

        Main.logged_user.List_ALL_Books.add(name);

        // add category to the book
        int count = Integer.parseInt(JOptionPane.showInputDialog("How many category U want to ADD"));
        for (int i = 0; i < count; i++) {

            String ncat = JOptionPane.showInputDialog("Enter the name of your category");

            tmp.getCategories().add(new Category(ncat));
        }
        JOptionPane.showMessageDialog(null, "If this book has any sub category you can add them in the Edit category", "info:subcategory", JOptionPane.INFORMATION_MESSAGE);

        int count1 = Integer.parseInt(JOptionPane.showInputDialog("how many Writer U want to ADD"));

        for (int i = 0; i < count1; i++) {

            String nw = JOptionPane.showInputDialog("Enter the name of book  Writer");
            String fw = JOptionPane.showInputDialog("Enter the  family name of book Writer");
            String idw = JOptionPane.showInputDialog("Enter the ID of book writer");
            tmp.getWriter().add(new wt(nw, fw, idw));

        }

        int count2 = Integer.parseInt(JOptionPane.showInputDialog("how many translator U want to ADD"));

        for (int i = 0; i < count2; i++) {

            String nt = JOptionPane.showInputDialog("Enter the name of translator");

            tmp.getTranslator().add(nt);

        }

        Main.logged_user.getBooks_user().add(tmp);
//        LoginUser();
    }

    public void Edit_Book(ActionEvent event) throws ParseException {
        while (true) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog("How do U want to edit your book\n1.remove the book\n2.Rename the book\n3.see your book detail\n4.Add catrgory"));

            if (choice > 4 && choice <= 0) {
                return;
            }

            switch (choice) {
                case 1:


                    int temp = findBook_Index(Main.logged_user.getBooks_user());
                    Main.logged_user.getBooks_user().remove(temp);
                    JOptionPane.showMessageDialog(null, "your book Removed successfully", "work process", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 2: {
                    String name = JOptionPane.showInputDialog("enter a new name of this book");
                    book temp2 = findBook_Object(Main.logged_user.getBooks_user());
                    temp2.setName(name);
                    JOptionPane.showMessageDialog(null, "your book name changed successfully", "work process", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case 3: {
                    String translatortmp = " ";

                    book temp3 = findBook_Object(Main.logged_user.getBooks_user());
                    JOptionPane.showMessageDialog(null, temp3.getName());

                    for (int i = 0; i < temp3.getTranslator().size(); i++) {
                        translatortmp += temp3.getTranslator().get(i) + "\n";
                    }
                    JOptionPane.showMessageDialog(null, translatortmp);
                    String qus1 = JOptionPane.showInputDialog("Do U want to see the writer or writer(y/n)");
                    if (qus1.equals("y")) {
                        String writertmp = " ";
                        for (int i = 0; i < book.writer.size(); i++) {
                            writertmp += temp3.getWriter().get(i).getName() + " " + temp3.getWriter().get(i).getFamily() + " " + temp3.getWriter().get(i).getId() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, writertmp);
                    }
//                    String qus2 = JOptionPane.showInputDialog("Do U want to see the category or categories(y/n)");
//                    if (qus2.equals("y")) {
//                        String categorytmp=" ";
//                        for (int i = 0; i < book.categories.size(); i++) {
//                           // categorytmp+=temp3.getCategories().get(i).getName()+" "+temp3.getCategories().get(i).getSub_category()+"\n";
//                        }
//                        JOptionPane.showMessageDialog(null,categorytmp);
//                    }

                    break;
                }
                case 4: {
                String all_book="";
                int b=0;
                    for (int i = 0; i <Main.logged_user.books_user.size() ; i++) {
                        all_book+=i+"-"+Main.logged_user.books_user.get(i).getName()+"\n";
                    }
                    b=Integer.parseInt(JOptionPane.showInputDialog(null,"choose the code of the book\n"+all_book));

                    String all_cat="";
                    int c=0;
                    for (int i = 0; i <Main.logged_user.books_user.get(b).getCategories().size() ; i++) {
                        all_cat+=Main.logged_user.books_user.get(b).getCategories().get(i).getName();

                    }
                    c= Integer.parseInt(JOptionPane.showInputDialog(null,"choose the code of the category\n"+all_cat));
                     int num= Integer.parseInt(JOptionPane.showInputDialog(null,"How many subcategory you want to add"));
                    for (int i = 0; i < num; i++) {

                        String ncat = JOptionPane.showInputDialog("Enter the name of your category");

                        Main.logged_user.getBooks_user().get(b).getCategories().add(new Category(ncat));
                    }
                }


            }//switch
        }//while(true)

    }
    public void Request_Book(ActionEvent event) throws ParseException {
        String users = "";
        String books = "";

        if (Main.members.size()<=1) {JOptionPane.showMessageDialog(null,"there is no user that U can borrow book from ");
        //    usermenu();
        }


        for (int i = 0; i <Main.members.size() ; i++) {
            if (Main.logged_user.getName()!=Main.members.get(i).getName())
                users =i+"-"+Main.members.get(i).getName()+"\n";
        }
        int  user_index = Integer.parseInt(JOptionPane.showInputDialog(null,users+"","Enter a code of user that you want to borrow a book from",JOptionPane.OK_CANCEL_OPTION)) ;
        User temp;
        temp=Main.members.get(user_index);


        if (temp.getGeneral_Book_List().size()==0) {JOptionPane.showMessageDialog(null,"there is no book that U can borrow\nplease choose other user!!!");
          //  Request_a_book();
        }
        for (int i = 0; i <temp.getGeneral_Book_List().size() ; i++) {
            Main.members.get(user_index);
            books =i+"-"+temp.getGeneral_Book_List().get(i).getName()+"\n";
        }
        int  book_index = Integer.parseInt(JOptionPane.showInputDialog(null,""+books,"Enter a code of book that you want to borrow",JOptionPane.OK_CANCEL_OPTION)) ;

        //  book.Requests.add(Main.members.get(user_index).getID());

        //Main.members.get(user_index);
        if (temp.getGeneral_Book_List().get(book_index).getBorrowing()!=null) {
            JOptionPane.showMessageDialog(null, "this book has been borrowed\nplease try another book", "ERROR", JOptionPane.ERROR_MESSAGE);
          //  usermenu();
        }
        temp.getGeneral_Book_List().get(book_index).Requests.add(Main.members.get(user_index).getID());

        String During=JOptionPane.showInputDialog(null,"How much time you want to borrow this book ?\nExample --> DD:hh:mm");

        temp.getGeneral_Book_List().get(book_index).Requests_Duration.add(During);
        JOptionPane.showMessageDialog(null,"your Request has been sent","Information",JOptionPane.OK_CANCEL_OPTION);

    }

    public  void Give_Book_to_Others (ActionEvent event) throws ParseException {
        String book="";
        if (Main.logged_user.getGeneral_Book_List().size()==0) {
            JOptionPane.showMessageDialog(null,"You dont have any book in your General Book");
          //  usermenu();
        }

        for (int i = 0; i <Main.logged_user.getGeneral_Book_List().size() ; i++) {
            if (Main.logged_user.getGeneral_Book_List().get(i).Requests!=null)
                book=""+i+"-"+Main.logged_user.getGeneral_Book_List().get(i).getName()+"\n";
        }

        int  book_i = Integer.parseInt(JOptionPane.showInputDialog(null,"These are Requested Book,Choose the code of a book that you want to borrow.\n "+book,"Requested Book",JOptionPane.OK_CANCEL_OPTION)) ;
        book book_object;
        book_object=Main.logged_user.General_Book_List.get(book_i);

        String rq="";

        for (int i = 0; i < book_object.Requests.size(); i++) {

            rq=i+"-"+book_object.Requests.get(i)+"----"+book_object.Requests_Duration.get(i)+"\n";

        }


        int finaling =Integer.parseInt(JOptionPane.showInputDialog(null,"Choose the code of the user id that you want to borrow to.\n"+rq,"Accepting a Request",JOptionPane.OK_CANCEL_OPTION));
//        int Y_N=Integer.parseInt(JOptionPane.showInputDialog(null,"DO you really want to give it to this user ?\n1-Yes\n2-No"));
//
//        if (Y_N==2) {usermenu();}
        String During0[]=book_object.Requests_Duration.get(finaling).split("[:/.,]");
        int Duting_int=0;
        for (int i = 0; i < During0.length; i++) {
            Duting_int+=Integer.parseInt(During0[i]);
        }
        book_object.setBorrowing(book_object.Requests.get(finaling));
        book_object.setDuration_of_Request(Duting_int);
        User user=new User();
        for (int i = 0; i <Main.members.size() ; i++) {
            if (Main.members.get(i).getID().equals(book_object.Requests.get(finaling)));
            user=Main.members.get(i);
            break;
        }
        book_object.setDuration_of_Accepting_Time(time());
        user.Borrowed_Book.add(book_object);

        book_object.setName(book_object.getName()+"-Borrowed");
        JOptionPane.showMessageDialog(null,"The Book Borrowed Successfully");
    }

    public void Refresh(ActionEvent event){
        String bar=">";
        for (int i=1;i<200;i++){
            refresh_status.setText(" loading...............\n") ;
            bar=bar+">";
            refresh_status.setText (bar);
            refresh_status.setText("");

            if (bar.length()%50==0) bar=">";

        }
        for (int i = 0; i <Main.logged_user.getGeneral_Book_List().size() ; i++) {
            if(Main.logged_user.getGeneral_Book_List().get(i).getBorrowing()!=null){
                try {
                    if(Difference_of_two_time(Main.logged_user.General_Book_List.get(i).getDuration_of_Accepting_Time(),time())>Main.logged_user.General_Book_List.get(i).getDuration_of_Request()){
                        String[]name=Main.logged_user.books_user.get(i).getName().split("[-]");
                        Main.logged_user.books_user.get(i).setName(name[0]);
                        User user=new User();
                        for (int j = 0; j <Main.members.size() ; j++) {
                            if(Main.members.get(j).getID().equals(Main.logged_user.General_Book_List.get(j).getBorrowing())){
                                user=Main.members.get(j);
                                for (int k = 0; k <user.Borrowed_Book.size() ; k++) {
                                    if (user.Borrowed_Book.get(k).getName().equals(name[0])){
                                        JOptionPane.showMessageDialog(null,name[0]+" has returned to your Book list");
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

      //  refresh_status.setText("done");

    }


    public void Show_list(ActionEvent event){
        if(all_books.isSelected()){
            ls_books.setItems(Main.logged_user.List_ALL_Books);}
        if (general_books.isSelected()){
            ls_books.setItems(Main.logged_user.List_General);}
    }

    public void  I_forget_my_password(ActionEvent event) {
        String em=JOptionPane.showInputDialog(null,"give me your email");
        String phone_num=JOptionPane.showInputDialog(null,"give me your phone number");
        boolean f1 = false;
        boolean f2 = false;

        for (int i = 0; i <Main.members.size() ; i++) {
            if(em.equals(Main.members.get(i).getEmail()))
            {
                f1 = true;
            }
        }
        int pass_index = 0;
        for (int i = 0; i <Main.members.size() ; i++) {
            if(phone_num.equals(Main.members.get(i).getForget_pass()))
            {
                f2 = true;
                pass_index=i;
            }
        }

        if(f1 ==true &&f2 ==true)
        {
            String time=time();
            String[] str=time.split("[:]");
            System.out.println(time);
            int sum=0;
            for (int i = 0; i <str.length ; i++) {
                sum+=Integer.parseInt(str[i]);
            }

            //JOptionPane.showMessageDialog(null,"Hello "+Main.members.get(pass_index).getName()+" this is your password :\n"+sum);
            String massage="Hi "+Main.members.get(pass_index).getName()+" this is your password :\n"+"---->>>> "+sum+"\nChange this password by your panel";
            Send_Email(Main.members.get(pass_index).getEmail(),Integer.toString(sum),massage);
            String hashed_S =Integer.toString(sum);
            int hashed_I=hashed_S.hashCode();
            Main.members.get(pass_index).setPass(hashed_I);
        }

    }

    public void AdminUser(ActionEvent event) throws IOException {
     //   ActionEvent event2 = new ActionEvent();
        LoginUser Log = new LoginUser();
        boolean test = Log.Admin_Login(txtadminname.getText(), txtpassword_admin.getText());
        if (LoginUser.validate(txtadminname.getText())) {

            if (test != true) {
                login_status.setText("Sorry,cann't login.please try again");
                AdminUser(event);

            }

        }

        login_status.setText("You've been Login Successfully");

       // Parent root1 = FXMLLoader.load(getClass().getResource("Admin Menu.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Admin Menu.fxml"));
        Scene rootScene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();


    }
        //jyfuiohjioj



    public void Delete_User(ActionEvent event){
        String user=JOptionPane.showInputDialog(null,"enter the user name that you want to delete");
        for (int i = 0; i <Main.members.size() ; i++) {
            if (Main.members.get(i).getName().equals(user))
                JOptionPane.showMessageDialog(null,"the user "+Main.members.get(i).getName()+"has been removed");
                Main.members.remove(i);
        }
    }

    public void Show_user(ActionEvent event){

        ls_users.setItems(Main.List_ALL_User);

    }

    public void ch_user_name(ActionEvent event){
        String user=JOptionPane.showInputDialog(null,"enter the user name that you want to change name");
        String new_name=JOptionPane.showInputDialog(null,"enter the new name ");
        for (int i = 0; i <Main.members.size() ; i++) {
            if (Main.members.get(i).getName().equals(user)){
                JOptionPane.showMessageDialog(null,"the new name is : "+new_name);
            Main.members.get(i).setName(new_name);
            }
        }
    }

    public void Home(ActionEvent event) throws IOException {
        //ActionEvent event4 = new ActionEvent();
        Parent root = FXMLLoader.load(getClass().getResource("Main Menu.fxml"));
        Scene rootScene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }
    //ObservableList<String> users = FXCollections.observableArrayList();

    public ObservableList users= FXCollections.observableArrayList();


    String one_user="";
   public void Search_users(ActionEvent event) throws IOException {
       for (int i = 0; i <Main.members.size() ; i++) {
           if (names.getText().equals(Main.members.get(i).getName())) {

                users= FXCollections.observableArrayList(Main.members.get(i).getName()+"--->"+Main.members.get(i).getEmail());

           }

       }



       searched_user.setItems(users);



    }


    public void show_User_Gbooks(ActionEvent event){

        // one_user=one_user.("[","");
        searched_user.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        one_user= String.valueOf(searched_user.getSelectionModel().getSelectedItems());
        if (one_user==null) return;
//        System.out.println(one_user);
        one_user=one_user.replace("[","");
        one_user=one_user.replace("]","");
        one_user.trim();
        if (one_user==null)one_user="";

        String [] N_one_user=one_user.split("--->");
        for (int i = 0; i < Main.members.size(); i++) {
            if (N_one_user[0].equals(Main.members.get(i).getName())){
            G_b.setItems(Main.members.get(i).List_General);
            }
        }

    }

    public void Add_to_Gen(ActionEvent event) throws ParseException {
       book Book=findBook_Object(Main.logged_user.books_user);
       Main.logged_user.General_Book_List.add(Book);
        Main.logged_user.List_General.add(Book.getName());
       JOptionPane.showMessageDialog(null,"your book added to the general list");


    }
}
