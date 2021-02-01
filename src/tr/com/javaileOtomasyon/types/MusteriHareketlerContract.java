package tr.com.javaileOtomasyon.types;

public class MusteriHareketlerContract {
    private String HareketId;
    private String UrunId;
    private String Adet;
    private String Personel;
    private String Musteri;
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

    public String getUrunId() {
        return UrunId;
    }

    public void setUrunId(String urunId) {
        UrunId = urunId;
    }

    public String getAdet() {
        return Adet;
    }

    public void setAdet(String adet) {
        Adet = adet;
    }

    public String getPersonel() {
        return Personel;
    }

    public void setPersonel(String personel) {
        Personel = personel;
    }

    public String getMusteri() {
        return Musteri;
    }

    public void setMusteri(String musteri) {
        Musteri = musteri;
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
        Object[] veriler = {HareketId, UrunId, Adet, Personel, Musteri, Fiyat, Toplam, FaturaId, Tarih, Notlar};
        return veriler;
    }

    @Override
    public String toString() {
        return "FirmaHareketlerContract{" +
                "HareketId='" + HareketId + '\'' +
                ", UrunId='" + UrunId + '\'' +
                ", Adet='" + Adet + '\'' +
                ", Personel='" + Personel + '\'' +
                ", Firma='" + Musteri + '\'' +
                ", Fiyat='" + Fiyat + '\'' +
                ", Toplam='" + Toplam + '\'' +
                ", FaturaId='" + FaturaId + '\'' +
                ", Tarih='" + Tarih + '\'' +
                ", Notlar='" + Notlar + '\'' +
                '}';
    }
}
