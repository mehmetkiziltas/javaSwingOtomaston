package tr.com.javaileOtomasyon.types;

public class AnaSayfaContract {
    //Azalan Stoklar
    private String UrunAd;
    private String Adet;

    //son 10 Hareket
    private String SonUrunAd;
    private String SonAdet;
    private String SonAd;
    private String SonFiyat;
    private String SonToplam;

    //Ajanda
    private String AjandaTarih;
    private String AjandaSaat;
    private String AjandaBaslik;

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

    public Object[] GetVerilerAzalanStoklarVeriler() {
        Object[] veriler = {UrunAd, Adet};
        return veriler;
    }

    public String getSonUrunAd() {
        return SonUrunAd;
    }

    public void setSonUrunAd(String sonUrunAd) {
        SonUrunAd = sonUrunAd;
    }

    public String getSonAdet() {
        return SonAdet;
    }

    public void setSonAdet(String sonAdet) {
        SonAdet = sonAdet;
    }

    public String getSonAd() {
        return SonAd;
    }

    public void setSonAd(String sonAd) {
        SonAd = sonAd;
    }

    public String getSonFiyat() {
        return SonFiyat;
    }

    public void setSonFiyat(String sonFiyat) {
        SonFiyat = sonFiyat;
    }

    public String getSonToplam() {
        return SonToplam;
    }

    public void setSonToplam(String sonToplam) {
        SonToplam = sonToplam;
    }

    public Object[] GetSonUrunlerVeriler() {
        Object[] veriler = {SonUrunAd, SonAdet, SonAd, SonFiyat, SonToplam};
        return veriler;
    }

    public String getAjandaTarih() {
        return AjandaTarih;
    }

    public void setAjandaTarih(String ajandaTarih) {
        AjandaTarih = ajandaTarih;
    }

    public String getAjandaSaat() {
        return AjandaSaat;
    }

    public void setAjandaSaat(String ajandaSaat) {
        AjandaSaat = ajandaSaat;
    }

    public String getAjandaBaslik() {
        return AjandaBaslik;
    }

    public void setAjandaBaslik(String ajandaBaslik) {
        AjandaBaslik = ajandaBaslik;
    }

    public Object[] GetAjandaVeriler() {
        Object[] veriler = {AjandaTarih, AjandaSaat, AjandaBaslik};
        return veriler;
    }
}
