package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.MusteriHareketlerContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MusteriHareketlerDAL extends ObjectHelper implements DALInterfaces<MusteriHareketlerContract> {

    @Override
    public void Insert(MusteriHareketlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO javaileotomasyon.musterihareketler(URUNID, ADET, PERSONEL, MUSTERI, FIYAT " +
                    ",TOPLAM,FATURAID,TARIH,NOTLAR)"
                    + " VALUES ('" + entity.getUrunId() + "','"
                    + entity.getAdet() + "','"
                    + entity.getPersonel() + "','"
                    + entity.getMusteri() + "','"
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
    public List<MusteriHareketlerContract> GetAll() {
        return null;
    }

    @Override
    public MusteriHareketlerContract Delete(MusteriHareketlerContract entity) {
        return null;
    }

    @Override
    public void Update(MusteriHareketlerContract entity) {

    }

    @Override
    public List<MusteriHareketlerContract> GetById(int id) {
        return null;
    }
}
