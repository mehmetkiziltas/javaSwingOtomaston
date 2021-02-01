package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.complex.contract.StokContractTotalComplex;
import tr.com.javaileOtomasyon.complex.contract.UrunlerContractComplex;
import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.StokContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StokDAL extends ObjectHelper implements DALInterfaces<StokContract> {
    
    @Override
    public void Insert(StokContract entity) {

    }
    
    public List<StokContract> GetAllStok() {
        List<StokContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        StokContract contract;
        String sql = "select urunad,sum(adet) as 'Miktar' from javaileotomasyon.urunler group by urunad";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                contract = new StokContract();
                contract.setUrunAd(resultSet.getString("urunad"));
                contract.setAdet(resultSet.getString("Miktar"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
    
    public List<StokContractTotalComplex> GetTotalStok() {
       return null;
    }
    
    @Override
    public List<StokContract> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public StokContract Delete(StokContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Update(StokContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<StokContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UrunlerContractComplex> GetByAdi(String Ad) {
        List<UrunlerContractComplex> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        UrunlerContractComplex contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT urunler.ID,urunler.URUNAD,kategori.Adi,urunler.MODEL ," +
                    "urunler.YIL,urunler.ADET,urunler.ALISFIYAT,urunler.SATISFIYAT,urunler.DETAY " +
                    "FROM javaileotomasyon.urunler left join javaileotomasyon.kategori " +
                    "on urunler.MARKA = kategori.ParentId where javaileotomasyon.urunler.URUNAD = '" + Ad + "'");
            while (resultSet.next()) {
                contract = new UrunlerContractComplex();
                contract.setID(resultSet.getInt("Id"));
                contract.setADI(resultSet.getString("URUNAD"));
                contract.setMARKA(resultSet.getString("kategori.Adi"));
                contract.setMODEL(resultSet.getString("model"));
                contract.setYIL(resultSet.getString("YIL"));
                contract.setADET(resultSet.getString("Adet"));
                contract.setALISFIYAT(resultSet.getFloat("ALISFIYAT"));
                contract.setSATISFIYAT(resultSet.getFloat("SATISFIYAT"));
                contract.setDETAY(resultSet.getString("Detay"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
