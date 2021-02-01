package tr.com.javaileOtomasyon.types;

public class BankalarContract {
    private String Id;
    private String BankaAdi;
    private String Il;
    private String Ilce;
    private String Sube;
    private String Iban;
    private String HesapNo;
    private String Yetkili;
    private String Telefon;
    private String Tarih;
    private String HesapTuru;
    private String FirmaId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBankaAdi() {
        return BankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        BankaAdi = bankaAdi;
    }

    public String getIl() {
        return Il;
    }

    public void setIl(String il) {
        Il = il;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String ilce) {
        Ilce = ilce;
    }

    public String getSube() {
        return Sube;
    }

    public void setSube(String sube) {
        Sube = sube;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public String getHesapNo() {
        return HesapNo;
    }

    public void setHesapNo(String hesapNo) {
        HesapNo = hesapNo;
    }

    public String getYetkili() {
        return Yetkili;
    }

    public void setYetkili(String yetkili) {
        Yetkili = yetkili;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getHesapTuru() {
        return HesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        HesapTuru = hesapTuru;
    }

    public String getFirmaId() {
        return FirmaId;
    }

    public void setFirmaId(String firmaId) {
        FirmaId = firmaId;
    }

    public Object[] getVeriler() {
        Object[] veriler = {Id, BankaAdi, Il, Ilce, Sube, Iban, HesapNo, Yetkili, Telefon, Tarih, HesapTuru, FirmaId};

        return veriler;
    }

    @Override
    public String toString() {
        return "BankalarContract{" +
                "Id='" + Id + '\'' +
                ", BankaAdi='" + BankaAdi + '\'' +
                ", Il='" + Il + '\'' +
                ", Ilce='" + Ilce + '\'' +
                ", Sube='" + Sube + '\'' +
                ", Iban='" + Iban + '\'' +
                ", HesapNo='" + HesapNo + '\'' +
                ", Yetkili='" + Yetkili + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Tarih='" + Tarih + '\'' +
                ", HesapTuru='" + HesapTuru + '\'' +
                ", FirmaId='" + FirmaId + '\'' +
                '}';
    }
}
