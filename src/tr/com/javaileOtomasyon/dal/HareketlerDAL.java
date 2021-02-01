package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.GiderlerContract;
import tr.com.javaileOtomasyon.types.HareketlerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HareketlerDAL extends ObjectHelper implements DALInterfaces<HareketlerContract> {
    @Override
    public void Insert(HareketlerContract entity) {

    }

    @Override
    public List<HareketlerContract> GetAll() {
        return null;
    }

    public List<HareketlerContract> GetAllMusteriHareketler() {
        List<HareketlerContract> datacontract = new ArrayList();
        Connection connection = getConnection();
        HareketlerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT HAREKETID, URUNAD,javaileotomasyon.musterihareketler.ADET, " +
                    "(javaileotomasyon.personeller.AD + ' ' + javaileotomasyon.personeller.SOYAD) " +
                    "AS 'ADSOYAD', (javaileotomasyon.musteriler.AD + ' ' + javaileotomasyon.musteriler.SOYAD) " +
                    "AS 'MÜŞTERİ', FIYAT, TOPLAM, javaileotomasyon.musterihareketler.ADET, FATURAID, TARIH, NOTLAR " +
                    "FROM javaileotomasyon.musterihareketler " +
                    "INNER JOIN javaileotomasyon.urunler " +
                    "ON javaileotomasyon.musterihareketler.URUNID=javaileotomasyon.urunler.ID " +
                    "INNER JOIN javaileotomasyon.personeller " +
                    "ON javaileotomasyon.musterihareketler.PERSONEL=javaileotomasyon.personeller.ID " +
                    "INNER JOIN javaileotomasyon.musteriler " +
                    "ON javaileotomasyon.musterihareketler.MUSTERI=javaileotomasyon.musteriler.ID");
            while (resultSet.next()) {
                contract = new HareketlerContract();
                contract.setHareketId(resultSet.getString("HAREKETID"));
                contract.setUrunAd(resultSet.getString("URUNAD"));
                contract.setAdet(resultSet.getString("ADET"));
                contract.setAdSoyad(resultSet.getString("ADSOYAD"));
                contract.setFirmaAd(resultSet.getString("MÜŞTERİ"));
                contract.setFiyat(resultSet.getString("FIYAT"));
                contract.setToplam(resultSet.getString("TOPLAM"));
                contract.setFaturaId(resultSet.getString("FATURAID"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setNotlar(resultSet.getString("NOTLAR"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
    public List<HareketlerContract> GetAllFirmaHareketler() {
        List<HareketlerContract> datacontract = new ArrayList();
        Connection connection = getConnection();
        HareketlerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT HAREKETID, URUNAD, javaileotomasyon.firmahareketler.ADET," +
                    " (javaileotomasyon.personeller.AD +' '+ SOYAD) AS 'ADSOYAD', javaileotomasyon.firmalar.AD as 'FIRMAADI'," +
                    "FIYAT, TOPLAM, FATURAID, TARIH, NOTLAR " +
                    "FROM javaileotomasyon.firmahareketler INNER JOIN javaileotomasyon.urunler " +
                    "ON javaileotomasyon.firmahareketler.URUNID=urunler.ID INNER JOIN javaileotomasyon.personeller " +
                    "ON javaileotomasyon.firmahareketler.PERSONEL=javaileotomasyon.personeller.ID INNER JOIN javaileotomasyon.firmalar " +
                    "ON javaileotomasyon.firmahareketler.FIRMA=javaileotomasyon.firmalar.ID ");
            while (resultSet.next()) {
                contract = new HareketlerContract();
                contract.setHareketId(resultSet.getString("HAREKETID"));
                contract.setUrunAd(resultSet.getString("URUNAD"));
                contract.setAdet(resultSet.getString("ADET"));
                contract.setAdSoyad(resultSet.getString("ADSOYAD"));
                contract.setFirmaAd(resultSet.getString("FIRMAADI"));
                contract.setFiyat(resultSet.getString("FIYAT"));
                contract.setToplam(resultSet.getString("TOPLAM"));
                contract.setFaturaId(resultSet.getString("FATURAID"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setNotlar(resultSet.getString("NOTLAR"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public HareketlerContract Delete(HareketlerContract entity) {
        return null;
    }

    @Override
    public void Update(HareketlerContract entity) {

    }

    @Override
    public List<HareketlerContract> GetById(int id) {
        return null;
    }

    public List<GiderlerContract> GetAllKasaCikisHareketleri() {

        List<GiderlerContract> datacontract = new ArrayList();
        Connection connection = getConnection();
        GiderlerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.giderler");
            while (resultSet.next()) {
                contract = new GiderlerContract();
                contract.setId(resultSet.getString("ID"));
                contract.setYil(resultSet.getString("YIL"));
                contract.setAy(resultSet.getString("AY"));
                contract.setElektrik(resultSet.getString("ELEKTRIK"));
                contract.setSu(resultSet.getString("SU"));
                contract.setDogalgaz(resultSet.getString("DOGALGAZ"));
                contract.setInternet(resultSet.getString("INTERNET"));
                contract.setMaaslar(resultSet.getString("MAASLAR"));
                contract.setExtralar(resultSet.getString("EKSTRA"));
                contract.setNotlar(resultSet.getString("NOTLAR"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;

    }
}
