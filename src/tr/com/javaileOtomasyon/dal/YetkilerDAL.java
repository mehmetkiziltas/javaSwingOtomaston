
package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.YetkilerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class YetkilerDAL extends ObjectHelper implements DALInterfaces<YetkilerContract>{

    @Override
    public void Insert(YetkilerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.yetkiler(Ad) values ('"
                    + entity.getAdi()
                    + "')");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<YetkilerContract> GetAll() {
        List<YetkilerContract> datacontract = new ArrayList<YetkilerContract>();
        Connection connection = getConnection();
        YetkilerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.yetkiler");
            while (resultSet.next()) {
                contract = new YetkilerContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Ad"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public YetkilerContract Delete(YetkilerContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(YetkilerContract entity) {

    }

    @Override
    public List<YetkilerContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<YetkilerContract> GetByYetkiName(String name) {
        List<YetkilerContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        YetkilerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM javaileotomasyon.yetkiler where AD = '" + name + "'");
            while (resultSet.next()) {
                contract = new YetkilerContract();
                contract.setId(resultSet.getInt("Id"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
