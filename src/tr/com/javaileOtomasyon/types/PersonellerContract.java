package tr.com.javaileOtomasyon.types;

public class PersonellerContract {
    private String Id;
    private String Ad;
    private String Soyad;
    private String Telefon;
    private String Tc;
    private String Mail;
    private String Il;
    private String Ilce;
    private String Adres;
    private String Gorev;

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

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
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

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getGorev() {
        return Gorev;
    }

    public void setGorev(String gorev) {
        Gorev = gorev;
    }
    public Object[] getVeriler() {
        Object[] veriler = {Id, Ad, Soyad, Telefon, Tc, Mail, Il, Ilce, Adres, Gorev};

        return veriler;
    }

    @Override
    public String toString() {
        return Ad ;
    }
}
