package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.KasaContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KasaDAL extends ObjectHelper implements DALInterfaces<KasaContract> {
    @Override
    public void Insert(KasaContract entity) {

    }

    @Override
    public List<KasaContract> GetAll() {
        return null;
    }

    @Override
    public KasaContract Delete(KasaContract entity) {
        return null;
    }

    @Override
    public void Update(KasaContract entity) {

    }

    @Override
    public List<KasaContract> GetById(int id) {
        return null;
    }

    public List<KasaContract> GetToplamTutarDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(TUTAR) AS 'TUTAR' FROM javaileotomasyon.faturadetay");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setToplamTutar(resultSet.getString("TUTAR"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetOdemelerDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select (ELEKTRIK+SU+DOGALGAZ+INTERNET+MAASLAR+EKSTRA) as 'Odemeler'FROM javaileotomasyon.giderler ORDER BY ID ASC");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setOdemeler(resultSet.getString("Odemeler"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetPersonelMaaslariDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select MAASLAR FROM javaileotomasyon.giderler ORDER BY ID ASC");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setPersonelMaaslari(resultSet.getString("MAASLAR"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetMusteriSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as 'Personeller' from javaileotomasyon.musteriler");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setMusteriSayisi(resultSet.getString("Personeller"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetFirmaSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as 'Firmalar' from javaileotomasyon.firmalar");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setFirmaSayisi(resultSet.getString("Firmalar"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetFirmaSehirSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(distinct(IL)) as 'Firma_Sehir' from javaileotomasyon.firmalar");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setFirmaSehirSayisi(resultSet.getString("Firma_Sehir"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetMusteriSehirSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(distinct(IL)) as 'Musteri_Sehir' from javaileotomasyon.musteriler");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setMusteriSehirSayisi(resultSet.getString("Musteri_Sehir"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetPersonelSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) as 'Personeller' from javaileotomasyon.personeller");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setPersonelSayisi(resultSet.getString("Personeller"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KasaContract> GetStokSayisiDAL() {
        List<KasaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KasaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select sum(adet) as 'Adet' from javaileotomasyon.urunler");
            while (resultSet.next()) {
                contract = new KasaContract();
                contract.setStokSayisi(resultSet.getString("Adet"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
