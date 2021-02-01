package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.KatagoriContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KatagoriDal extends ObjectHelper implements DALInterfaces<KatagoriContract> {

    @Override
    public void Insert(KatagoriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into javaileotomasyon.kategori(Adi, ParentId) values ('" + entity.getAdi()
                    + "'," + entity.getParentId() + ")");
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<KatagoriContract> GetAll() {
        List<KatagoriContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KatagoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.kategori");
            while (resultSet.next()) {
                contract = new KatagoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    public List<KatagoriContract> GetAllParentId() {
        List<KatagoriContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        KatagoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.kategori");
            while (resultSet.next()) {
                contract = new KatagoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public KatagoriContract Delete(KatagoriContract entity) {
        return null;
    }

    @Override
    public void Update(KatagoriContract entity) {
        System.out.println(entity.getId());
        Connection connection = getConnection();
        String sql = "update javaileotomasyon.kategori set Adi = '"
                + entity.getAdi() + "', ParentId = "
                + entity.getParentId() + " "
                + " where id = " + entity.getId() + "";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<KatagoriContract> GetById(int id) {
        return null;
    }

    public List<KatagoriContract> GetSearchKatagori(String KategoriAdi){
        List<KatagoriContract> dataContracts = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "select * from javaileotomasyon.kategori"
                + " where Adi like '"+"%"+KategoriAdi+"%"+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {                
                KatagoriContract contract = new KatagoriContract();
                contract.setAdi(rs.getString("Adi"));
                contract.setParentId(rs.getInt("ParentId"));
                
                dataContracts.add(contract);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataContracts;
    }
    public void UpdateByName(KatagoriContract entity) {
        Connection connection = getConnection();
        String sql = "update javaileotomasyon.kategori " +
                "set Adi = '" + entity.getAdi() +
                "', ParentId = " + entity.getParentId() +
                " where id = " + entity.getId() + "";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
