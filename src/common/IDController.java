package common;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class IDController {

    public static String getLastID(String tableName, String colName) throws SQLException, Exception {
        String sql = "SELECT " + colName + " FROM " + tableName + " ORDER BY 1 DESC LIMIT 1";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return (rst.getString(1));
        }
        return null;
    }

}
