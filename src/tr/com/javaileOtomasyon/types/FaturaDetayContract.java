package tr.com.javaileOtomasyon.types;

public class FaturaDetayContract {
    private String ID;
    private String FaturaUrunId;
    private String UrunAdi;
    private String Miktar;
    private String Fiyat;
    private String Tutar;
    private String FaturaId;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFaturaUrunId() {
        return FaturaUrunId;
    }

    public void setFaturaUrunId(String faturaUrunId) {
        FaturaUrunId = faturaUrunId;
    }

    public String getUrunAdi() {
        return UrunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        UrunAdi = urunAdi;
    }

    public String getMiktar() {
        return Miktar;
    }

    public void setMiktar(String miktar) {
        Miktar = miktar;
    }

    public String getFiyat() {
        return Fiyat;
    }

    public void setFiyat(String fiyat) {
        Fiyat = fiyat;
    }

    public String getTutar() {
        return Tutar;
    }

    public void setTutar(String tutar) {
        Tutar = tutar;
    }

    public String getFaturaId() {
        return FaturaId;
    }

    public void setFaturaId(String faturaId) {
        FaturaId = faturaId;
    }

    public Object[] getVeriler() {
        Object[] veriler = {ID, FaturaUrunId, UrunAdi, Miktar, Fiyat, Tutar,FaturaId};
        return veriler;
    }
}
