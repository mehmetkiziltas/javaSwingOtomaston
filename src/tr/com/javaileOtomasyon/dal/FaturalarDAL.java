package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.FaturalarBilgiContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaturalarDAL extends ObjectHelper implements DALInterfaces<FaturalarBilgiContract> {
    @Override
    public void Insert(FaturalarBilgiContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.faturabilgi(SERI, SIRANO, " +
                    "TARIH,SAAT,VERGIDAIRE,ALICI, TESLIMEDEN, TESLIMALAN)"
                    + " VALUES ('" + entity.getSeri() + "','"
                    + entity.getSiraNo() + "','"
                    + entity.getTarih() + "','"
                    + entity.getSaat() + "','"
                    + entity.getVergiDaire() + "','"
                    + entity.getAlici() + "','"
                    + entity.getTEden() + "','"
                    + entity.getTAlan() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FaturalarBilgiContract> GetAll() {
        List<FaturalarBilgiContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FaturalarBilgiContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.faturabilgi");
            while (resultSet.next()) {
                contract = new FaturalarBilgiContract();
                contract.setId(resultSet.getString("FATURABILGIID"));
                contract.setSeri(resultSet.getString("SERI"));
                contract.setSiraNo(resultSet.getString("SIRANO"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setSaat(resultSet.getString("SAAT"));
                contract.setVergiDaire(resultSet.getString("VERGIDAIRE"));
                contract.setAlici(resultSet.getString("ALICI"));
                contract.setTEden(resultSet.getString("TESLIMEDEN"));
                contract.setTAlan(resultSet.getString("TESLIMALAN"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public FaturalarBilgiContract Delete(FaturalarBilgiContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.faturabilgi WHERE FATURABILGIID = '" + entity + "'");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(FaturalarBilgiContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.faturabilgi" +
                    " SET SERI = '" + entity.getSeri() + "'," +
                    "SIRANO = '" + entity.getSiraNo() + "', " +
                    "TARIH = '" + entity.getTarih() + "'," +
                    " SAAT = '" + entity.getSaat() + "'," +
                    " VERGIDAIRE = '" + entity.getVergiDaire() + "'," +
                    " ALICI = '" + entity.getAlici() + "'," +
                    " TESLIMEDEN = '" + entity.getTEden() + "'," +
                    " TESLIMALAN = '" + entity.getTAlan() + "'" +
                    "WHERE FATURABILGIID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FaturalarBilgiContract> GetById(int id) {
        return null;
    }
}
