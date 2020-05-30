package com.dream.utils;

import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    public static String DRIVERNAME = "";
    public static String URL = "";
    public static String USER = "";
    public static String PASSWORD = "";

    static {
        try {
            Properties properties = new Properties();
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("com/dream/utils/dbconfig.properties"));
            DRIVERNAME = properties.getProperty("DRIVERNAME");
            URL = properties.getProperty("URL");
            USER = properties.getProperty("USER");
            PASSWORD = properties.getProperty("PASSWORD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }


    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {

        if(rs != null){
            try{
                rs.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try{
                stmt.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

    }

}
