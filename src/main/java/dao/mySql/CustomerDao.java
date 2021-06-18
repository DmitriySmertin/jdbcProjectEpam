package dao.mySql;

import domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {
    DbHandler dbHandler = new DbHandler();

    public boolean create (String fullName, String passport, String phoneNumber) throws SQLException,ClassNotFoundException {
        String insertSql = "INSERT INTO customer (fullName,passport, phoneNumb) VALUES (?,?,?)";

        try {
            PreparedStatement prSt = dbHandler.getCon().prepareStatement(insertSql);
            prSt.setString(1,fullName);
            prSt.setString(2,passport);
            prSt.setString(3,phoneNumber);
            prSt.executeUpdate();
            prSt.close();
            dbHandler.con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
