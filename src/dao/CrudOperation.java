
package dao;

import com.mysql.jdbc.PreparedStatement;
import db.DBConnection;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperation {

    public static PreparedStatement getPreparedStatement(String sql, Object... param) throws FileNotFoundException, SQLException, Exception {
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);

        for (int i = 0; i < param.length; i++) {
            pstm.setObject(i + 1, param[i]);

        }
        return pstm;
    }

    public static boolean executeUpdate(String sql, Object... para) throws FileNotFoundException, SQLException, Exception {
        return getPreparedStatement(sql, para).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(String sql, Object... para) throws FileNotFoundException, SQLException, Exception {
        return getPreparedStatement(sql, para).executeQuery();
    }

}
