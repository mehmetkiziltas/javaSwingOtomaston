package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.complex.contract.SatisContractComplex;
import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.SatisContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SatisDAL extends ObjectHelper implements DALInterfaces<SatisContract> {

    @Override
    public void Insert(SatisContract entity) {
//        Connection connection = getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into javaileotomasyon.satis(UrunId, MusteriId, Tarih, "
//                    + "Adet, PersonelId) values ("
//                    + entity.getUrunId()
//                    + "," + entity.getMusteriId()
//                    + ",'" + entity.getTarih()
//                    + "'," + entity.getAdet()
//                    + "," + entity.getParsonelId() + ")");
//            statement.close();
//            connection.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public List<SatisContractComplex> GetAllSatis() {
        List<SatisContractComplex> dataContract = new ArrayList<>();
        Connection connection = getConnection();
        SatisContractComplex contract;
        String sql = "SELECT satis.Id, personeller.ad, musteriler.ad, URUNAD, satis.Adet, satis.Tarih "
                + " FROM javaileotomasyon.satis"
                + " left join javaileotomasyon.musteriLER"
                + " on javaileotomasyon.satis.MusteriId = javaileotomasyon.musteriLER.Id"
                + " left join javaileotomasyon.urunler"
                + " on javaileotomasyon.satis.UrunId = javaileotomasyon.urunler.Id"
                + " left join javaileotomasyon.personeller"
                + " on javaileotomasyon.satis.PersonelId = javaileotomasyon.personeller.Id"
                + " order by javaileotomasyon.satis.Id Desc ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                contract = new SatisContractComplex();
                contract.setId(resultSet.getInt("satis.Id"));
                contract.setMusteriAdi(resultSet.getString("musteriLER.AD"));
                contract.setPersonelAdi(resultSet.getString("personelLER.AD"));
                contract.setTarih(resultSet.getString("satis.Tarih"));
                contract.setUrunAdi(resultSet.getString("URUNAD"));
                contract.setAdet(resultSet.getInt("Adet"));

                dataContract.add(contract);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dataContract;
    }

    @Override
    public List<SatisContract> GetAll() {

        return null;
    }

    @Override
    public SatisContract Delete(SatisContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(SatisContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SatisContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
