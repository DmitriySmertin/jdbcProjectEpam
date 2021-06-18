package dao.mySql;

import domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
    DbHandler dbHandler = new DbHandler();
    public String resultStr = "";

    public boolean delete(String fullName) throws SQLException,ClassNotFoundException
    {

        String deleteSql = "DELETE FROM customer WHERE fullname = ?";
        try {
            PreparedStatement prSt = dbHandler.getCon().prepareStatement(deleteSql);
            prSt.setString(1,fullName);
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
    public boolean readAllCustomers()  throws SQLException, ClassNotFoundException
    {
        String selectAllSql = "SELECT * FROM customer";

        try {
            Statement st = dbHandler.getCon().createStatement();
            ResultSet resultSet;
            resultSet = st.executeQuery(selectAllSql);

            while (resultSet.next())
            {
                int idCust = resultSet.getInt("idCustomer");
                String fullName = resultSet.getString("fullName");
                String pass = resultSet.getString("passport");
                String phone = resultSet.getString("phoneNumb");
                resultStr += "Id:" + idCust + ", " + "FullName:" + fullName + ", " + "Passport:" + pass + ", "
                         + "PhoneNumber"  + phone + "\n";
            }
            resultStr = resultStr.trim();
            resultSet.close();
            st.close();
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
