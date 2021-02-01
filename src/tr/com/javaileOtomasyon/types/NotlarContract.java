package tr.com.javaileOtomasyon.types;

public class NotlarContract {
    private String Id;
    private String Tarih;
    private String Saat;
    private String Baslik;
    private String Detay;
    private String Olusturan;
    private String Hitap;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getSaat() {
        return Saat;
    }

    public void setSaat(String saat) {
        Saat = saat;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String baslik) {
        Baslik = baslik;
    }

    public String getDetay() {
        return Detay;
    }

    public void setDetay(String detay) {
        Detay = detay;
    }

    public String getOlusturan() {
        return Olusturan;
    }

    public void setOlusturan(String olusturan) {
        Olusturan = olusturan;
    }

    public String getHitap() {
        return Hitap;
    }

    public void setHitap(String hitap) {
        Hitap = hitap;
    }

    public Object[] getVeriler() {
        Object[] veriler = {Id, Tarih, Saat, Baslik, Detay, Olusturan, Hitap};
        return veriler;
    }

    @Override
    public String toString() {
        return "NotlarContract{" +
                "Id='" + Id + '\'' +
                ", Tarih='" + Tarih + '\'' +
                ", Saat='" + Saat + '\'' +
                ", Baslik='" + Baslik + '\'' +
                ", Detay='" + Detay + '\'' +
                ", Olusturan='" + Olusturan + '\'' +
                ", Hitap='" + Hitap + '\'' +
                '}';
    }
}
