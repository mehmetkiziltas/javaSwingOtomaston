package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.AccountsContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountsDAL extends ObjectHelper implements DALInterfaces<AccountsContract> {

    @Override
    public void Insert(AccountsContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.accounts(PersonelId, YetkiId, Sifre) values ("
                    + entity.getPersonelId() + ","
                    + entity.getYetkiliId() + ",'"
                    + entity.getSifre() + "')");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AccountsContract GetPersonelIdSifre(int personelId, String sifre) {
        AccountsContract contract = new AccountsContract();
        Connection baglanti = getConnection();
        try {
            Statement statement = baglanti.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * "
                    + "FROM javaileotomasyon.accounts "
                    + "where PersonelId = " + personelId + " and "
                    + "Sifre = '" + sifre.trim() + "'");

            while (rs.next()) {
                contract.setId(rs.getInt("Id"));
                contract.setPersonelId(rs.getInt("PersonelId"));
                contract.setSifre(rs.getString("Sifre"));
                contract.setYetkiliId(rs.getInt("YetkiId"));

            }
            statement.close();
            baglanti.close();
        } catch (Exception e) {
        }

        return contract;
    }

    public AccountsContract GetYetkiId(int personelId) {
        AccountsContract contract = new AccountsContract();
        Connection baglanti = getConnection();
        try {
            Statement statement = baglanti.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * "
                    + "FROM javaileotomasyon.accounts "
                    + "where PersonelId = " + personelId + "");

            while (rs.next()) {
                contract.setId(rs.getInt("Id"));
                contract.setPersonelId(rs.getInt("PersonelId"));
                contract.setYetkiliId(rs.getInt("YetkiId"));

            }
            statement.close();
            baglanti.close();
        } catch (Exception e) {
        }

        return contract;
    }

    @Override
    public List<AccountsContract> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountsContract Delete(AccountsContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(AccountsContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AccountsContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void updateByPersonelId(int PersonelId, int YetkiId) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.accounts " +
                    "SET YetkiId = '" + YetkiId + "'" +
                    "WHERE PersonelId =  '"+ PersonelId +"'");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateByPassword(int PersonelId, int password) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.accounts " +
                    "SET Sifre = '" + password + "'" +
                    "WHERE PersonelId =  '"+ PersonelId +"'");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
