package tr.com.javaileOtomasyon.types;

public class FaturalarBilgiContract {
    private String Id;
    private String Seri;
    private String SiraNo;
    private String CariTuru;
    private String Tarih;
    private String Saat;
    private String VergiDaire;
    private String Alici;
    private String TEden;
    private String TAlan;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSeri() {
        return Seri;
    }

    public void setSeri(String seri) {
        Seri = seri;
    }

    public String getSiraNo() {
        return SiraNo;
    }

    public void setSiraNo(String siraNo) {
        SiraNo = siraNo;
    }

    public String getCariTuru() {
        return CariTuru;
    }

    public void setCariTuru(String cariTuru) {
        CariTuru = cariTuru;
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

    public String getVergiDaire() {
        return VergiDaire;
    }

    public void setVergiDaire(String vergiDaire) {
        VergiDaire = vergiDaire;
    }

    public String getAlici() {
        return Alici;
    }

    public void setAlici(String alici) {
        Alici = alici;
    }

    public String getTEden() {
        return TEden;
    }

    public void setTEden(String TEden) {
        this.TEden = TEden;
    }

    public String getTAlan() {
        return TAlan;
    }

    public void setTAlan(String TAlan) {
        this.TAlan = TAlan;
    }

    public Object[] getVeriler() {
        Object[] veriler = {Id, Seri, SiraNo, CariTuru, Tarih, Saat, VergiDaire, Alici, TEden, TAlan};
        return veriler;
    }
}
