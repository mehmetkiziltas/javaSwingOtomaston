package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.NotlarContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotlarDAL extends ObjectHelper implements DALInterfaces<NotlarContract> {
    @Override
    public void Insert(NotlarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.notlar(TARIH, SAAT, BASLIK, " +
                    "DETAY,OLUSTURAN,HITAP)"
                    + " VALUES ('" + entity.getTarih() + "','"
                    + entity.getSaat() + "','"
                    + entity.getBaslik() + "','"
                    + entity.getDetay() + "','"
                    + entity.getOlusturan() + "','"
                    + entity.getHitap() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NotlarContract> GetAll() {
        List<NotlarContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        NotlarContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.notlar");
            while (resultSet.next()) {
                contract = new NotlarContract();
                contract.setId(resultSet.getString("Id"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setSaat(resultSet.getString("saat"));
                contract.setBaslik(resultSet.getString("BASLIK"));
                contract.setDetay(resultSet.getString("detay"));
                contract.setOlusturan(resultSet.getString("olusturan"));
                contract.setHitap(resultSet.getString("HITAP"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public NotlarContract Delete(NotlarContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.NOTLAR WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(NotlarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.notlar " +
                    "SET TARIH = '" + entity.getTarih() + "'," +
                    " SAAT = '" + entity.getSaat() + "'," +
                    " BASLIK = '" + entity.getBaslik() + "'," +
                    " DETAY = '" + entity.getDetay() + "'," +
                    " OLUSTURAN = '" + entity.getOlusturan() + "'," +
                    " HITAP = '" + entity.getHitap() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<NotlarContract> GetById(int id) {
        return null;
    }
}
