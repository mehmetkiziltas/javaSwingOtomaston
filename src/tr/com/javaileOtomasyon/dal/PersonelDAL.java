
package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.AccountsContract;
import tr.com.javaileOtomasyon.types.PersonelContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract> {

    @Override
    public void Insert(PersonelContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.personel(AdiSoyadi, Email) values ('"
                    + entity.getAdiSoyadi()
                    + "','" + entity.getEmail() + "')");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PersonelContract> GetAll() {
        List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
        Connection connection = getConnection();
        PersonelContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.personeller");
            while (resultSet.next()) {
                contract = new PersonelContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
                contract.setEmail(resultSet.getString("Email"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<PersonelContract> GetPersonelInfo() {
        List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
        Connection connection = getConnection();
        PersonelContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.personeller");
            while (resultSet.next()) {
                contract = new PersonelContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdiSoyadi(resultSet.getString("AD"));
                contract.setEmail(resultSet.getString("MAIL"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public PersonelContract Delete(PersonelContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(PersonelContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonelContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<AccountsContract> GetByName(String name) {
        List<AccountsContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        AccountsContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM javaileotomasyon.personeller where AD = '" + name + "'");
            while (resultSet.next()) {
                contract = new AccountsContract();
                contract.setPersonelId(resultSet.getInt("Id"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
