package tr.com.javaileOtomasyon.types;

import java.sql.Date;

public class SatisContract {

    private int Id;
    private int musteriId;
    private int parsonelId;
    private int urunId;
    private int adet;
    private String tarih;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the musteriId
     */
    public int getMusteriId() {
        return musteriId;
    }

    /**
     * @param musteriId the musteriId to set
     */
    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

    /**
     * @return the parsonelId
     */
    public int getParsonelId() {
        return parsonelId;
    }

    /**
     * @param parsonelId the parsonelId to set
     */
    public void setParsonelId(int parsonelId) {
        this.parsonelId = parsonelId;
    }

    /**
     * @return the urunId
     */
    public int getUrunId() {
        return urunId;
    }

    /**
     * @param urunId the urunId to set
     */
    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    /**
     * @return the adet
     */
    public int getAdet() {
        return adet;
    }

    /**
     * @param adet the adet to set
     */
    public void setAdet(int adet) {
        this.adet = adet;
    }

    /**
     * @return the tarih
     */
    public String getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return Id + " " + musteriId + " " + parsonelId + " " + urunId + " " + adet + " " + tarih;
    }

}
