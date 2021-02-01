package tr.com.javaileOtomasyon.types;

public class HareketlerContract {
    private String HareketId;
    private String UrunAd;
    private String Adet;
    private String AdSoyad;
    private String FirmaAd;
    private String Fiyat;
    private String Toplam;
    private String FaturaId;
    private String Tarih;
    private String Notlar;

    public String getHareketId() {
        return HareketId;
    }

    public void setHareketId(String hareketId) {
        HareketId = hareketId;
    }

    public String getUrunAd() {
        return UrunAd;
    }

    public void setUrunAd(String urunAd) {
        UrunAd = urunAd;
    }

    public String getAdet() {
        return Adet;
    }

    public void setAdet(String adet) {
        Adet = adet;
    }

    public String getAdSoyad() {
        return AdSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        AdSoyad = adSoyad;
    }

    public String getFirmaAd() {
        return FirmaAd;
    }

    public void setFirmaAd(String firmaAd) {
        FirmaAd = firmaAd;
    }

    public String getFiyat() {
        return Fiyat;
    }

    public void setFiyat(String fiyat) {
        Fiyat = fiyat;
    }

    public String getToplam() {
        return Toplam;
    }

    public void setToplam(String toplam) {
        Toplam = toplam;
    }

    public String getFaturaId() {
        return FaturaId;
    }

    public void setFaturaId(String faturaId) {
        FaturaId = faturaId;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getNotlar() {
        return Notlar;
    }

    public void setNotlar(String notlar) {
        Notlar = notlar;
    }
    public Object[] getVeriler() {
        Object[] veriler = {HareketId,UrunAd,Adet,AdSoyad,FirmaAd,Fiyat,Toplam,FaturaId,Tarih,Notlar};
        return veriler;
    }
}
