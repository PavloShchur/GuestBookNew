package com.mycoolsoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.05.2017.
 */
public class GuestBook {

    final static String URL = "jdbc:mysql://localhost:3306/my_tomcat?verifyServerCertificate=false&useSSL=true";
    final static String USER = "root";
    final static String PASSWORD = "auf253100vbnc45";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
//        addPost(new Post("p"));
//                addPost(new Post("p"));

        System.out.println(getAllPosts());


    }

    public static  List<Post> getAllPosts() throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        ArrayList<Post> posts = new ArrayList<Post>();
        try (ResultSet resultSet = c.createStatement().executeQuery("SELECT * FROM posts")) {
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setTxt(resultSet.getString("txt"));
                posts.add(post);
            }
            return posts;
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    public static void addPost (Post p) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("INSERT INTO posts(id, txt) VALUES (?,?)")) {
                {
                    ps.setLong(1, p.getId());
                    ps.setString(2, p.getTxt());
                    ps.execute();
                }
            }
        }
    }

    public static void deletePost(int id) {
        try (Connection c = getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("DELETE  FROM posts WHERE id=?")) {
                {
                    ps.setLong(1, id);
                    ps.execute();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}