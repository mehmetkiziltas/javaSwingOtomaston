package tr.com.javaileOtomasyon.types;

public class MusteriContract {

    private int Id;
    private String Ad;
    private String Soyad;
    private String Telefon1;
    private String Telefon2;
    private String Tc;
    private String Mail;
    private String Il;
    private String Ilce;
    private String VergiDaire;
    private String Adres;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
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

    public String getTc() {
        return Tc;
    }

    public void setTc(String tc) {
        Tc = tc;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
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
        Object[] veriler = {Id, Ad, Soyad, Telefon1, Telefon2, Tc, Mail, Il, Ilce, VergiDaire, Adres};

        return veriler;
    }
    public Object[] getRehber() {
        Object[] veriler = {Ad, Soyad, Telefon1, Telefon2, Mail};

        return veriler;
    }
}
