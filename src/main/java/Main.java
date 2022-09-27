import Repositories.ArticleRepository;
import Repositories.UserRepository;
import classes.Article;
import classes.User;
import menu.menu1;
import menu.menu2;
import sun.security.mscapi.CPublicKey;

import java.lang.invoke.SwitchPoint;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        User login = new User();
        User signin = new User();
        Article show = new Article();
        Article edite = new Article();
        Article add = new Article();

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
                if(UserRepository.boll){
                    System.out.println("login Successfully");
                    menu2.login_menu();
                    int input2 = scanner.nextInt();
                    switch (input2){
                        case 1:
                            show.setUser_id(UserRepository.UserId);
                            ArticleRepository.SHOW_art(show);
                            break;
                        case 2:
                            System.out.println("Your Articles");
                            show.setUser_id(UserRepository.UserId);
                            ArticleRepository.SHOW_art(show);
                            System.out.println("Write the index you want to change ");
                            edite.setIndex(scanner.next());
                            System.out.println("Edite  "+edite.getIndex()+"  : ");
                            edite.setEdindex(scanner.next());
                         //   edite.setWhereindx(ArticleRepository.edstring);
                            ArticleRepository.Edite_art(edite);
                            break;
                        case 3:
                            System.out.println("Enter Title:");
                            add.setTitle(scanner.next());
                            System.out.println("Enter Brief:");
                            add.setBrief(scanner.next());
                            System.out.println("Enter Content:");
                            add.setContent(scanner.next());
                            System.out.println("Enter Create date:");
                            add.setCreateDate(scanner.nextInt());
                            System.out.println("Enter Publish Status:");
                            add.setIsPublished(scanner.next());
                            ArticleRepository.insert_art(add);
                            break;
                    }
                }
                else System.out.println(false);

                break;
            case 2:
                System.out.println("Enter Your Username:");
                signin.setUserName(scanner.next());
                System.out.println("Enter Your National code:");
                signin.setNationalCode(scanner.nextInt());
                System.out.println("Enter Your Birthday date(Ex 1997/12/21) :");
                signin.setBirthDay(scanner.next());
                System.out.println("Enter Your Password:");
                signin.setPassWord(scanner.next());
                UserRepository.Sign_in(signin);

                System.out.println("done! Please login.");


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