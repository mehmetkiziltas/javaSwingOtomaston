package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.FirmaHareketlerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirmaHareketlerDAL extends ObjectHelper implements DALInterfaces<FirmaHareketlerContract> {

    @Override
    public void Insert(FirmaHareketlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.firmahareketler(URUNID, ADET, PERSONEL, FIRMA,FIYAT " +
                    ",TOPLAM,FATURAID,TARIH,NOTLAR)"
                    + " VALUES ('" + entity.getUrunId() + "',"
                    + entity.getAdet() + ",'"
                    + entity.getPersonel() + "',"
                    + entity.getFirma() + ",'"
                    + entity.getFiyat() + "','"
                    + entity.getToplam() + "','"
                    + entity.getFaturaId() + "','"
                    + entity.getTarih() + "','"
                    + entity.getNotlar() + "')");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FirmaHareketlerContract> GetAll() {
        List<FirmaHareketlerContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        FirmaHareketlerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");
            while (resultSet.next()) {
                contract = new FirmaHareketlerContract();
                contract.setHareketId(resultSet.getString("HareketId"));
                contract.setUrunId(resultSet.getString("UrunId"));
                contract.setAdet(resultSet.getString("Adet"));
                contract.setPersonel(resultSet.getString("Personel"));
                contract.setFirma(resultSet.getString("FIRMA"));
                contract.setFiyat(resultSet.getString("FIYAT"));
                contract.setToplam(resultSet.getString("Toplam"));
                contract.setFaturaId(resultSet.getString("FaturaId"));
                contract.setTarih(resultSet.getString("TARIH"));
                contract.setNotlar(resultSet.getString("Notlar"));
                datacontract.add(contract);

            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

    @Override
    public FirmaHareketlerContract Delete(FirmaHareketlerContract entity) {
        return null;
    }

    @Override
    public void Update(FirmaHareketlerContract entity) {

    }

    @Override
    public List<FirmaHareketlerContract> GetById(int id) {
        return null;
    }
}
