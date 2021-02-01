package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.MusteriContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusteriDAL extends ObjectHelper implements DALInterfaces<MusteriContract> {
    
    @Override
    public void Insert(MusteriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.musteriler(AD, Soyad, Telefon1, Telefon2,Tc,Mail,Il,Ilce,VergiDaire,Adres) values ('"
                    + entity.getAd() + "','"
                    + entity.getSoyad() + "','"
                    + entity.getTelefon1() + "','"
                    + entity.getTelefon2() + "','"
                    + entity.getTc() + "','"
                    + entity.getMail() + "','"
                    + entity.getIl() + "','"
                    + entity.getIlce() + "','"
                    + entity.getVergiDaire() + "','"
                    + entity.getAdres() + "')");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<MusteriContract> GetAll() {
        List<MusteriContract> datacontract = new ArrayList<MusteriContract>();
        Connection connection = getConnection();
        MusteriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.musteriler");
            while (resultSet.next()) {
                contract = new MusteriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAd(resultSet.getString("AD"));
                contract.setSoyad(resultSet.getString("Soyad"));
                contract.setTelefon1(resultSet.getString("Telefon1"));
                contract.setTelefon2(resultSet.getString("Telefon2"));
                contract.setTc(resultSet.getString("Tc"));
                contract.setMail(resultSet.getString("MAIL"));
                contract.setIl(resultSet.getString("Il"));
                contract.setIlce(resultSet.getString("Ilce"));
                contract.setVergiDaire(resultSet.getString("VERGIDAIRE"));
                contract.setAdres(resultSet.getString("Adres"));
                datacontract.add(contract);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
    
    @Override
    public MusteriContract Delete(MusteriContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.musteriler WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void Update(MusteriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.musteriler SET Ad = '" + entity.getAd() + "'," +
                    " soyad = '" + entity.getSoyad() + "'," +
                    " telefon1 = '" + entity.getTelefon1() + "', " +
                    "telefon2 = '" + entity.getTelefon2() + "'," +
                    "tc = '" + entity.getTc() + "'," +
                    "MAIL = '" + entity.getMail() + "'," +
                    "IL = '" + entity.getIl() + "', " +
                    "ILCE = '" + entity.getIlce() + "'" +
                    "ADRES = '" + entity.getAdres() + "'" +
                    "VERGIDAIRE = '" + entity.getVergiDaire() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<MusteriContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
