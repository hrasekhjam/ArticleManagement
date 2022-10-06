package Repositories;

import classes.User;
import connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static final String INSERT_QUERY = "insert into nafar (username, national_code, birthday, password) Values (?,?,?,?)";
    private static final String SEARCH_USER_QUERY = "select id, username , password from nafar where username=? and password =?";
    private static final String EDITE_USER_QUERY = "update nafar set password = ? where id = ?";
     public static boolean boll = true;
     public static int UserId;

    public static void changepass (User user){
        try {
            Connection connection = DbConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(EDITE_USER_QUERY);
            prepareStatement.setString(1, user.getPassWord());
            prepareStatement.setInt(2, UserId);

            prepareStatement.execute();


            prepareStatement.close();
            // connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    -------------------

    public static void login (User user){
        try {
            Connection connection = DbConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(SEARCH_USER_QUERY);
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());

            prepareStatement.execute();

            ResultSet re = prepareStatement.executeQuery();

//            boll = re.next();
            while (re.next()){
                UserId = re.getInt("id");
            }

            prepareStatement.close();
            // connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    -------------------
    public static void Sign_in (User user){
        try {
            Connection connection = DbConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1,user.getUserName());
            prepareStatement.setInt(2,user.getNationalCode());
            prepareStatement.setString(3,user.getBirthDay());
            prepareStatement.setString(4,user.getPassWord());


            prepareStatement.execute();


            prepareStatement.close();
           // connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
