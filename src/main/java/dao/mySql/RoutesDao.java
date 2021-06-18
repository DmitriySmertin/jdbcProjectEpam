package dao.mySql;

import domain.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoutesDao {
    DbHandler dbHandler = new DbHandler();
    public String result = "";
    public static int maxNumberRoute = 0;

    public boolean readAllRoutes () throws SQLException,ClassNotFoundException
    {
        String readAllRoutesSql = "SELECT * FROM routes" ;
        try {
            Statement st = dbHandler.getCon().createStatement();
            ResultSet resultSet;
            resultSet = st.executeQuery(readAllRoutesSql);

            while (resultSet.next())
            {
                int id = resultSet.getInt("idRoutes");
                String name = resultSet.getString("name");
                int allTickets = resultSet.getInt("allTicket");
                int freeTickets = resultSet.getInt("freeTicket");
                int soldTickets = resultSet.getInt("soldTicket");
                maxNumberRoute = id;
                result += "NumberOfRoute:" + id + ", " + "NameRoute:" +
                        name + ", " + "AllTickets:" + allTickets +
                        ", " + "FreeTickets:"  + freeTickets + ", " +
                        "SoldTickets:"  + soldTickets + "\n";
            }

            result = result.trim();
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

    public boolean reserveTicket(int numberRoute) throws SQLException,ClassNotFoundException
    {
        String reserveSql = "UPDATE routes SET freeTicket = freeTicket - 1, soldTicket = soldTicket + 1 WHERE idRoutes = ?";

        try {
            PreparedStatement prSt = dbHandler.getCon().prepareStatement(reserveSql);
            prSt.setInt(1,numberRoute);
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
