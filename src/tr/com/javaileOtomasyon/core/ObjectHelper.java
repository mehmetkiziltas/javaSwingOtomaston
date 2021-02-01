package tr.com.javaileOtomasyon.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tr.com.javaileOtomasyon.interfaces.CoreInterfaces;

public class ObjectHelper extends CoreFields implements CoreInterfaces {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("hata1");
            Logger.getLogger(ObjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        } catch (SQLException ex) {
            System.out.println(getUrl() + " " + getUserName() + " " + getPassword());
            Logger.getLogger(ObjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
