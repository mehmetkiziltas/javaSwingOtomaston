package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.FirmalarContract;
import tr.com.javaileOtomasyon.types.PersonellerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirmalarDAL extends ObjectHelper implements DALInterfaces<FirmalarContract> {
    @Override
    public void Insert(FirmalarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.firmalar(AD, YETKILISTATU, YETKILIADSOYAD, " +
                    "YETKILITC,SEKTOR,TELEFON1,TELEFON2, MAIL, FAX, IL, ILCE, VERGIDAIRE, ADRES)"
                    + " VALUES ('" + entity.getAd() + "','"
                    + entity.getYetkiliStatu() + "','"
                    + entity.getYetkiliAdSoyad() + "','"
                    + entity.getYetkiliTc() + "','"
                    + entity.getSektor() + "','"
                    + entity.getTelefon1() + "','"
                    + entity.getTelefon2() + "','"
                    + entity.getMail() + "','"
                    + entity.getFax() + "','"
                    + entity.getIl() + "','"
                    + entity.getIlce() + "','"
                    + entity.getVergiDaire() + "','"
                    + entity.getAdres() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FirmalarContract> GetAll() {
        List<FirmalarContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FirmalarContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.firmalar");
            while (resultSet.next()) {
                contract = new FirmalarContract();
                contract.setId(resultSet.getString("Id"));
                contract.setAd(resultSet.getString("Ad"));
                contract.setYetkiliStatu(resultSet.getString("YETKILISTATU"));
                contract.setYetkiliAdSoyad(resultSet.getString("YETKILIADSOYAD"));
                contract.setYetkiliTc(resultSet.getString("YETKILITC"));
                contract.setSektor(resultSet.getString("SEKTOR"));
                contract.setTelefon1(resultSet.getString("TELEFON1"));
                contract.setTelefon2(resultSet.getString("TELEFON2"));
                contract.setMail(resultSet.getString("MAIL"));
                contract.setFax(resultSet.getString("FAX"));
                contract.setIl(resultSet.getString("IL"));
                contract.setIlce(resultSet.getString("ILCE"));
                contract.setVergiDaire(resultSet.getString("VERGIDAIRE"));
                contract.setAdres(resultSet.getString("ADRES"));

                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public FirmalarContract Delete(FirmalarContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.firmalar WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(FirmalarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.firmalar SET AD = '" + entity.getAd() + "'," +
                    " YETKILISTATU = '" + entity.getYetkiliStatu() + "'," +
                    " YETKILIADSOYAD = '" + entity.getYetkiliAdSoyad() + "', " +
                    "YETKILITC = '" + entity.getYetkiliTc() + "'," +
                    "SEKTOR = '" + entity.getSektor() + "'," +
                    "TELEFON1 = '" + entity.getTelefon1() + "'," +
                    "TELEFON2 = '" + entity.getTelefon2() + "', " +
                    "MAIL = '" + entity.getMail() + "'," +
                    " FAX = '" + entity.getFax() + "'," +
                    " IL = '" + entity.getIl() + "'," +
                    " ILCE = '" + entity.getIlce() + "'," +
                    " VERGIDAIRE = '" + entity.getVergiDaire() + "'," +
                    " ADRES = '" + entity.getAdres() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FirmalarContract> GetById(int id) {
        return null;
    }

    public List<FirmalarContract> GetOrderByAll() {
        List<FirmalarContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FirmalarContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT distinct AD FROM javaileotomasyon.firmalar");
            while (resultSet.next()) {
                contract = new FirmalarContract();
                contract.setAd(resultSet.getString("Ad"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public String GetByName(String Ad) {
        Connection connection = getConnection();
        PersonellerContract contract = new PersonellerContract();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.firmalar WHERE javaileotomasyon.firmalar.AD= '"+ Ad +"'");
            while (resultSet.next()) {

                contract.setId(resultSet.getString("Id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contract.getId();
    }
}
