package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.FaturaDetayContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaturaDetayDAL extends ObjectHelper implements DALInterfaces<FaturaDetayContract> {
    @Override
    public void Insert(FaturaDetayContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.faturadetay(FATURAURUNID, URUNADI, MIKTAR, " +
                    "FIYAT,TUTAR,FATURAID)"
                    + " VALUES ('" + entity.getFaturaUrunId() + "','"
                    + entity.getUrunAdi() + "','"
                    + entity.getMiktar() + "','"
                    + entity.getFiyat() + "','"
                    + entity.getTutar() + "','"
                    + entity.getFaturaId() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FaturaDetayContract> GetAll() {
        List<FaturaDetayContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FaturaDetayContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.faturadetay");
            while (resultSet.next()) {
                contract = new FaturaDetayContract();
                contract.setID(resultSet.getString("ID"));
                contract.setFaturaUrunId(resultSet.getString("FATURAURUNID"));
                contract.setUrunAdi(resultSet.getString("URUNADI"));
                contract.setMiktar(resultSet.getString("MIKTAR"));
                contract.setFiyat(resultSet.getString("FIYAT"));
                contract.setTutar(resultSet.getString("TUTAR"));
                contract.setFaturaId(resultSet.getString("FATURAID"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public FaturaDetayContract Delete(FaturaDetayContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.faturadetay WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(FaturaDetayContract entity) {
        Connection connection = getConnection();
        try {
            //"ID","Ürün Id", "Ürün Adı", "Miktar", "Fiyat", "Tutar", "Fatura Id"
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.faturadetay" +
                    " SET FATURAURUNID = '" + entity.getFaturaUrunId() + "'," +
                    " URUNADI = '" + entity.getUrunAdi() + "'," +
                    " MIKTAR = '" + entity.getMiktar() + "'," +
                    " FIYAT = '" + entity.getFiyat() + "'," +
                    " TUTAR = '" + entity.getTutar() + "'," +
                    " FATURAID = '" + entity.getFaturaId() + "'" +
                    "WHERE ID = " + entity.getID() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FaturaDetayContract> GetById(int id) {
        return null;
    }

    public List<FaturaDetayContract > GetByIdString(String id) {
        List<FaturaDetayContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FaturaDetayContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.faturadetay WHERE FATURAID = " + id + "");
            while (resultSet.next()) {
                contract = new FaturaDetayContract();
                contract.setID(resultSet.getString("ID"));
                contract.setFaturaUrunId(resultSet.getString("FATURAURUNID"));
                contract.setUrunAdi(resultSet.getString("URUNADI"));
                contract.setMiktar(resultSet.getString("MIKTAR"));
                contract.setFiyat(resultSet.getString("FIYAT"));
                contract.setTutar(resultSet.getString("TUTAR"));
                contract.setFaturaId(resultSet.getString("FATURAID"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }
}
