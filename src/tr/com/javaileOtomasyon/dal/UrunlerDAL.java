package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.complex.contract.UrunlerContractComplex;
import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.UrunlerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces<UrunlerContract> {

    @Override
    public void Insert(UrunlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.urunler(urunad, marka, model, YIL,ALISFIYAT,SATISFIYAT,Detay)"
                    + " VALUES ('" + entity.getADI() + "',"
                    + entity.getMARKA() + ",'"
                    + entity.getMODEL() + "',"
                    + entity.getYIL() + ",'"
                    + entity.getALISFIYAT() + "','"
                    + entity.getSATISFIYAT() + "','"
                    + entity.getDETAY() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UrunlerContract> GetAll() {
        return null;
    }

    public List<UrunlerContractComplex> GetAllUrunler() {
        List<UrunlerContractComplex> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        UrunlerContractComplex contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT urunler.ID,urunler.URUNAD,kategori.Adi,urunler.MODEL" +
                    ",urunler.YIL,urunler.ADET,urunler.ALISFIYAT," +
                    "urunler.SATISFIYAT,urunler.DETAY " +
                    "FROM javaileotomasyon.urunler \n" +
                    "left join javaileotomasyon.kategori\n" +
                    "on urunler.MARKA = kategori.ParentId");
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

    @Override
    public UrunlerContract Delete(UrunlerContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.urunler WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(UrunlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.urunler SET urunad = '" + entity.getADI() + "'," +
                    " marka = '" + entity.getMARKA() + "'," +
                    " model = '" + entity.getMODEL() + "', " +
                    "YIL = '" + entity.getYIL() + "'," +
                    "Adet = '" + entity.getADET() + "'," +
                    "ALISFIYAT = '" + entity.getALISFIYAT() + "'," +
                    "SATISFIYAT = '" + entity.getSATISFIYAT() + "', " +
                    "Detay = '" + entity.getDETAY() + "'" +
                    "WHERE ID = " + entity.getID() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }

    public String GetByName(String name) {
        Connection connection = getConnection();
        UrunlerContract contract = new UrunlerContract();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM javaileotomasyon.urunler WHERE URUNAD = '" + name + "'");
            while (resultSet.next()) {
                contract.setID(resultSet.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(contract.getID());
    }
    public void UpdateByName(int GelenAdet, String UrunId) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update javaileotomasyon.urunler set Adet = Adet -'" + GelenAdet  + "' WHERE ID = '" + UrunId + "'");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
