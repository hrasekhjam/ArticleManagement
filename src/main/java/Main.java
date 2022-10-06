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
            run();
    }


    public static void secondmenu() {
        Article show = new Article();
        Article edite = new Article();
        Article add = new Article();
        User edit = new User();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu2.login_menu();
            int input2 = scanner.nextInt();
            switch (input2) {
                case 1:
                    show.setUser_id(UserRepository.UserId);
                    ArticleRepository.SHOW_art(show);
                    secondmenu();
                case 2:
                    System.out.println("Your Articles");
                    show.setUser_id(UserRepository.UserId);
                    ArticleRepository.SHOW_art(show);
                    edit();
                    System.out.println("Write the new something");
                    edite.setEdindex(scanner.next());
                    ArticleRepository.Edite_art(edite);
                    System.out.println("Change Successfully");
                    secondmenu();
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
                    secondmenu();
                case 4:
                    System.out.println("Change Password: ");
                    edit.setPassWord(scanner.next());
                    UserRepository.changepass(edit);
                    System.out.println("Change Successfully");
                case 5:
                    run();
            }
        }
    }

    public static boolean run() {
        User login = new User();
        User signin = new User();


        Scanner scanner = new Scanner(System.in);

        menu1.Welcome_menu();
        int input = scanner.nextInt();
        boolean flag = true;
        while (flag) {
            switch (input) {
                case 1:
                    System.out.println("Enter username:");
                    login.setUsername(scanner.next());
                    System.out.println("Enter password:");
                    login.setPassword(scanner.next());
                    UserRepository.login(login);
                    if (UserRepository.boll == true) {
                        System.out.println("login Successfully");
                        secondmenu();
                    } else System.out.println("Try Again");
                    run();
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

                    run();
                case 3:

                    break;

            }
        }

        return flag;
    }

    public static void edit(){
        Scanner scanner = new Scanner(System.in);
        menu2.edit_menu();
        switch (scanner.nextInt()){
          case 0:
                menu2.login_menu();
          case 1:
              ArticleRepository.EDITE_ARTICLE_QUERY = "update article set title = ? where id = ?";
              break;
          case 2:
              ArticleRepository.EDITE_ARTICLE_QUERY = "update article set brief = ? where id = ?";
              break;
          case 3:
              ArticleRepository.EDITE_ARTICLE_QUERY = "update article set content = ? where id = ?";
              break;
          case 4:
              ArticleRepository.EDITE_ARTICLE_QUERY = "update article set is_published = ? where id = ?";
              break;
        }
    }
}