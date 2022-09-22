import Repositories.ArticleRepository;
import Repositories.UserRepository;
import classes.Article;
import classes.User;
import menu.menu1;
import menu.menu2;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        User login = new User();
        User signin = new User();
        Article show = new Article();
       Scanner scanner = new Scanner(System.in);
       menu1.Welcome_menu();
        int input = scanner.nextInt();
        switch (input){
            case 1:
                System.out.println("Enter username:");
                login.setUsername(scanner.next());
                System.out.println("Enter password:");
                login.setPassword(scanner.next());
                UserRepository.login(login);
                if(UserRepository.boll == true){
                    System.out.println("login Successfully");
                    menu2.login_menu();
                    int input2 = scanner.nextInt();
                    switch (input2){
                        case 1:
                            ArticleRepository.SHOW_art(show);
                    }
                }
                else System.out.println(UserRepository.boll);

                break;
            case 2:
                System.out.print("Enter Your Username:");
                signin.setUserName(scanner.next());
                System.out.print("Enter Your National code:");
                signin.setNationalCode(scanner.nextInt());
                System.out.print("Enter Your Birthday date(Ex 1997/12/21) :");
                signin.setBirthDay(scanner.next());
                System.out.print("Enter Your Password:");
                signin.setPassWord(scanner.next());
                if(UserRepository.boll == true)
                    System.out.println("done! \n Please login.");
                else System.out.println("try again!");
                break;
            case 3:
                break;

        }


    /*  User user2 = new User();
        user2.setUserName("hadi");
       user2.setNationalCode(00453625);
        user2.setBirthDay("1985/04/21");
        user2.setPassWord("1308520");


        UserRepository.Sign_in(user2);


        Article article = new Article();
        article.setTitle("harrypotter");
        article.setBrief("Magic School");
        article.setContent("Drama");
        article.setCreateDate(2000);
        article.setIsPublished("Publish");


        ArticleRepository.insert_art(article);*/


    }
}