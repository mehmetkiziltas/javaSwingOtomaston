package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.BankalarContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankalarDAL extends ObjectHelper implements DALInterfaces<BankalarContract> {
    @Override
    public void Insert(BankalarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.BANKALAR(BANKAADI, IL, ILCE, " +
                    "SUBE,IBAN,HESAPNO,YETKILI, TELEFON, TARIH, HESAPTURU, FIRMAID)"
                    + " VALUES ('" + entity.getBankaAdi() + "','"
                    + entity.getIl() + "','"
                    + entity.getIlce() + "','"
                    + entity.getSube() + "','"
                    + entity.getIban() + "','"
                    + entity.getHesapNo() + "','"
                    + entity.getYetkili() + "','"
                    + entity.getTelefon() + "','"
                    + entity.getTarih() + "','"
                    + entity.getHesapTuru() + "','"
                    + entity.getFirmaId() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BankalarContract> GetAll() {
        List<BankalarContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        BankalarContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM javaileotomasyon.BANKALAR");
            while (resultSet.next()) {
                contract = new BankalarContract();
                contract.setId(resultSet.getString("Id"));
                contract.setBankaAdi(resultSet.getString("BANKAADI"));
                contract.setIl(resultSet.getString("IL"));
                contract.setIlce(resultSet.getString("ILCE"));
                contract.setSube(resultSet.getString("SUBE"));
                contract.setIban(resultSet.getString("IBAN"));
                contract.setHesapNo(resultSet.getString("HESAPNO"));
                contract.setYetkili(resultSet.getString("YETKILI"));
                contract.setTelefon(resultSet.getString("TELEFON"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setHesapTuru(resultSet.getString("HESAPTURU"));
                contract.setFirmaId(resultSet.getString("FIRMAID"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public BankalarContract Delete(BankalarContract entity) {
        return null;
    }

    public void DeleteById(int entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM javaileotomasyon.bankalar WHERE ID = " + entity + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(BankalarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE javaileotomasyon.bankalar SET BANKAADI = '" + entity.getBankaAdi() + "'," +
                    "IL = '" + entity.getIl() + "'," +
                    "ILCE = '" + entity.getIlce() + "', " +
                    "SUBE = '" + entity.getSube() + "'," +
                    "IBAN = '" + entity.getIban() + "'," +
                    "HESAPNO = '" + entity.getHesapNo() + "'," +
                    "YETKILI = '" + entity.getYetkili() + "'," +
                    "TELEFON = '" + entity.getTelefon() + "'," +
                    "TARIH = '" + entity.getTarih() + "'," +
                    "HESAPTURU = '" + entity.getHesapTuru() + "'," +
                    "FIRMAID = '" + entity.getFirmaId() + "'" +
                    "WHERE ID = " + entity.getId() + "");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BankalarContract> GetById(int id) {
        return null;
    }
}
