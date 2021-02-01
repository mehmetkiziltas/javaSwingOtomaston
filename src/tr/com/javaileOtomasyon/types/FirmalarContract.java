package tr.com.javaileOtomasyon.types;

public class FirmalarContract {
    private String Id;
    private String Ad;
    private String YetkiliStatu;
    private String YetkiliAdSoyad;
    private String YetkiliTc;
    private String Sektor;
    private String Telefon1;
    private String Telefon2;
    private String Mail;
    private String Fax;
    private String Il;
    private String Ilce;
    private String VergiDaire;
    private String Adres;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getYetkiliStatu() {
        return YetkiliStatu;
    }

    public void setYetkiliStatu(String yetkiliStatu) {
        YetkiliStatu = yetkiliStatu;
    }

    public String getYetkiliAdSoyad() {
        return YetkiliAdSoyad;
    }

    public void setYetkiliAdSoyad(String yetkiliAdSoyad) {
        YetkiliAdSoyad = yetkiliAdSoyad;
    }

    public String getYetkiliTc() {
        return YetkiliTc;
    }

    public void setYetkiliTc(String yetkiliTc) {
        YetkiliTc = yetkiliTc;
    }

    public String getSektor() {
        return Sektor;
    }

    public void setSektor(String sektor) {
        Sektor = sektor;
    }

    public String getTelefon1() {
        return Telefon1;
    }

    public void setTelefon1(String telefon1) {
        Telefon1 = telefon1;
    }

    public String getTelefon2() {
        return Telefon2;
    }

    public void setTelefon2(String telefon2) {
        Telefon2 = telefon2;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
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

    public String getVergiDaire() {
        return VergiDaire;
    }

    public void setVergiDaire(String vergiDaire) {
        VergiDaire = vergiDaire;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    @Override
    public String toString() {
        return Ad;
    }
    public Object[] getVeriler() {
        Object[] veriler = {Id, Ad, YetkiliStatu, YetkiliAdSoyad, YetkiliTc, Sektor, Telefon1, Telefon2, Mail, Fax, Il,
        Ilce, VergiDaire, Adres};

        return veriler;
    }
    public Object[] getRehber() {
        Object[] veriler = {Ad, YetkiliAdSoyad, Telefon1, Telefon2, Mail, Fax};

        return veriler;
    }
}
