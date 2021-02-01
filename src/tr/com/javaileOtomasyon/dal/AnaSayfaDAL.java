package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.AnaSayfaContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnaSayfaDAL extends ObjectHelper implements DALInterfaces<AnaSayfaContract> {
    @Override
    public void Insert(AnaSayfaContract entity) {

    }

    @Override
    public List<AnaSayfaContract> GetAll() {
        return null;
    }

    @Override
    public AnaSayfaContract Delete(AnaSayfaContract entity) {
        return null;
    }

    @Override
    public void Update(AnaSayfaContract entity) {

    }

    @Override
    public List<AnaSayfaContract> GetById(int id) {
        return null;
    }

    public List<AnaSayfaContract> GetAzalanStoklar() {
        List<AnaSayfaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        AnaSayfaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT URUNAD,SUM(ADET) AS 'ADET' " +
                    "FROM javaileotomasyon.urunler GROUP BY URUNAD HAVING SUM(ADET) <= 20 ORDER BY SUM(ADET)");
            while (resultSet.next()) {
                contract = new AnaSayfaContract();
                contract.setUrunAd(resultSet.getString("URUNAD"));
                contract.setAdet(resultSet.getString("ADET"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<AnaSayfaContract> GetSonHareketler() {
        List<AnaSayfaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        AnaSayfaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT URUNAD, javaileotomasyon.firmahareketler.ADET, " +
                    "javaileotomasyon.firmalar.AD,FIYAT, TOPLAM " +
                    "FROM javaileotomasyon.firmahareketler " +
                    "INNER JOIN javaileotomasyon.urunler " +
                    "ON javaileotomasyon.firmahareketler.URUNID=javaileotomasyon.urunler.ID " +
                    "INNER JOIN javaileotomasyon.firmalar " +
                    "ON javaileotomasyon.firmahareketler.FIRMA=javaileotomasyon.firmalar.ID");
            while (resultSet.next()) {
                contract = new AnaSayfaContract();
                contract.setSonUrunAd(resultSet.getString("URUNAD"));
                contract.setSonAdet(resultSet.getString("ADET"));
                contract.setSonAd(resultSet.getString("AD"));
                contract.setSonFiyat(resultSet.getString("FIYAT"));
                contract.setSonToplam(resultSet.getString("TOPLAM"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<AnaSayfaContract> GetAjanda() {
        List<AnaSayfaContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        AnaSayfaContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select TARIH, saat,BASLIK " +
                    "from javaileotomasyon.notlar order by ID desc limit 10;");
            while (resultSet.next()) {
                contract = new AnaSayfaContract();
                contract.setAjandaTarih(resultSet.getString("TARIH"));
                contract.setAjandaSaat(resultSet.getString("saat"));
                contract.setAjandaBaslik(resultSet.getString("BASLIK"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
