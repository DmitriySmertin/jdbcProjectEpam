package dao.mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler extends ConfigDb {
    Connection con;
    public Connection getCon() throws ClassNotFoundException,SQLException
    {
         String connStr = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(connStr, dbUser,dbPass);
         return con;
    }

}
