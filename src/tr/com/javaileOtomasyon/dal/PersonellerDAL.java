package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.PersonellerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonellerDAL extends ObjectHelper implements DALInterfaces<PersonellerContract> {
    @Override
    public void Insert(PersonellerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.personeller(AD, SOYAD, TELEFON, " +
                    "TC,MAIL,IL,ILCE, ADRES, GOREV)"
                    + " VALUES ('" + entity.getAd() + "','"
                    + entity.getSoyad() + "','"
                    + entity.getTelefon() + "','"
                    + entity.getTc() + "','"
                    + entity.getMail() + "','"
                    + entity.getIl() + "','"
                    + entity.getIlce() + "','"
                    + entity.getAdres() + "','"
                    + entity.getGorev() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PersonellerContract> GetAll() {
        List<PersonellerContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        PersonellerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.personeller");
            while (resultSet.next()) {
                contract = new PersonellerContract();
                contract.setId(resultSet.getString("Id"));
                contract.setAd(resultSet.getString("Ad"));
                contract.setSoyad(resultSet.getString("SOYAD"));
                contract.setTelefon(resultSet.getString("TELEFON"));
                contract.setTc(resultSet.getString("TC"));
                contract.setMail(resultSet.getString("MAIL"));
                contract.setIl(resultSet.getString("IL"));
                contract.setIlce(resultSet.getString("ILCE"));
                contract.setAdres(resultSet.getString("ADRES"));
                contract.setGorev(resultSet.getString("GOREV"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public PersonellerContract Delete(PersonellerContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.personeller WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(PersonellerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.personeller SET AD = '" + entity.getAd() + "'," +
                    " SOYAD = '" + entity.getSoyad() + "'," +
                    " telefon = '" + entity.getTelefon() + "', " +
                    "tc = '" + entity.getTc() + "'," +
                    "MAIL = '" + entity.getMail() + "'," +
                    " IL = '" + entity.getIl() + "'," +
                    " ILCE = '" + entity.getIlce() + "'," +
                    " Adres = '" + entity.getAdres() + "'," +
                    " Gorev = '" + entity.getGorev() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PersonellerContract> GetById(int id) {
        return null;
    }

    public String GetByName(String Ad) {
        Connection connection = getConnection();
        PersonellerContract contract = new PersonellerContract();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.personeller WHERE javaileotomasyon.personeller.AD= '"+ Ad +"'");
            while (resultSet.next()) {

                contract.setId(resultSet.getString("Id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contract.getId();
    }
}
