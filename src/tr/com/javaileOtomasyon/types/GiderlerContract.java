package tr.com.javaileOtomasyon.types;

public class GiderlerContract {
    private String Id;
    private String Yil;
    private String Ay;
    private String Elektrik;
    private String Su;
    private String Dogalgaz;
    private String Internet;
    private String Maaslar;
    private String Extralar;
    private String Notlar;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getYil() {
        return Yil;
    }

    public void setYil(String yil) {
        Yil = yil;
    }

    public String getAy() {
        return Ay;
    }

    public void setAy(String ay) {
        Ay = ay;
    }

    public String getElektrik() {
        return Elektrik;
    }

    public void setElektrik(String elektrik) {
        Elektrik = elektrik;
    }

    public String getSu() {
        return Su;
    }

    public void setSu(String su) {
        Su = su;
    }

    public String getDogalgaz() {
        return Dogalgaz;
    }

    public void setDogalgaz(String dogalgaz) {
        Dogalgaz = dogalgaz;
    }

    public String getInternet() {
        return Internet;
    }

    public void setInternet(String internet) {
        Internet = internet;
    }

    public String getMaaslar() {
        return Maaslar;
    }

    public void setMaaslar(String maaslar) {
        Maaslar = maaslar;
    }

    public String getExtralar() {
        return Extralar;
    }

    public void setExtralar(String extralar) {
        Extralar = extralar;
    }

    public String getNotlar() {
        return Notlar;
    }

    public void setNotlar(String notlar) {
        Notlar = notlar;
    }

    @Override
    public String toString() {
        return "GiderlerContract{" +
                "Id='" + Id + '\'' +
                ", Yil='" + Yil + '\'' +
                ", Ay='" + Ay + '\'' +
                ", Elektrik='" + Elektrik + '\'' +
                ", Su='" + Su + '\'' +
                ", Dogalgaz='" + Dogalgaz + '\'' +
                ", Internet='" + Internet + '\'' +
                ", Maaslar='" + Maaslar + '\'' +
                ", Extralar='" + Extralar + '\'' +
                ", Notlar='" + Notlar + '\'' +
                '}';
    }

    public Object[] getVeriler() {
        Object[] veriler = {Id, Yil, Ay, Elektrik, Su, Dogalgaz, Internet, Maaslar, Extralar, Notlar};

        return veriler;
    }
}
