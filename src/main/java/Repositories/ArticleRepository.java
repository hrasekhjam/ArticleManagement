package Repositories;

import classes.Article;
import classes.User;
import connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRepository {
    private static final String INSERT_QUERY = "insert into article(title, brief, content, create_date, is_published) VALUES (?,?,?,?,?)";
    private static final String SEARCH_ARTICLE_QUERY = "select * from article";
    private static final String EDITE_ARTICLE_QUERY = "update article set ? = ? where ? = 2017";
    public static void SHOW_art(Article article){
        try {
            Connection connection = DbConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(SEARCH_ARTICLE_QUERY);


            ResultSet re = prepareStatement.executeQuery();
            while (re.next()){
                System.out.println("TITLE =>"+ re.getString("title")+", "
                            +"BRIEF =>"+ re.getString("brief")+", "
                            +"CONTENT =>"+ re.getString("content")+", "
                            +"CREAT_DATE =>"+ re.getInt("create_date")+", "
                            +"  IS_PUBLISHED =>"+ re.getString("is_published")+", ");
            }


            prepareStatement.close();
           // connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


//    --------
    public static void insert_art(Article article){
        try {
            Connection connection = DbConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1,article.getTitle());
            prepareStatement.setString(2,article.getBrief());
            prepareStatement.setString(3,article.getContent());
            prepareStatement.setInt(4,article.getCreateDate());
            prepareStatement.setString(5,article.getIsPublished());




            System.out.println("add parameter to table");
            prepareStatement.execute();


            prepareStatement.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
