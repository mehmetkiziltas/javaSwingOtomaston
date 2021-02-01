package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.GiderlerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiderlerDAL extends ObjectHelper implements DALInterfaces<GiderlerContract> {
    @Override
    public void Insert(GiderlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.giderler(YIL, Ay, ELEKTRIK,SU,DOGALGAZ,INTERNET,MAASLAR,EKSTRA,NOTLAR) values ('"
                    + entity.getYil() + "','"
                    + entity.getAy() + "','"
                    + entity.getElektrik() + "','"
                    + entity.getSu() + "','"
                    + entity.getDogalgaz() + "','"
                    + entity.getInternet() + "','"
                    + entity.getMaaslar() + "','"
                    + entity.getExtralar() + "','"
                    + entity.getNotlar() + "')");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<GiderlerContract> GetAll() {
        List<GiderlerContract> datacontract = new ArrayList<GiderlerContract>();
        Connection connection = getConnection();
        GiderlerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.Giderler");
            while (resultSet.next()) {
                contract = new GiderlerContract();
                contract.setId(resultSet.getString("Id"));
                contract.setYil(resultSet.getString("YIL"));
                contract.setAy(resultSet.getString("Ay"));
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

    @Override
    public GiderlerContract Delete(GiderlerContract entity) {
        return null;
    }
    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.giderler WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Update(GiderlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.musteriler SET YIL = '" + entity.getYil() + "'," +
                    " Ay = '" + entity.getAy() + "'," +
                    " ELEKTRIK = '" + entity.getElektrik() + "', " +
                    "su = '" + entity.getSu() + "'," +
                    "Dogalgaz = '" + entity.getDogalgaz() + "'," +
                    "INTERNET = '" + entity.getInternet() + "'," +
                    "maaslar = '" + entity.getMaaslar() + "', " +
                    "ekstra = '" + entity.getExtralar() + "'" +
                    "notlar = '" + entity.getNotlar() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GiderlerContract> GetById(int id) {
        return null;
    }
}
