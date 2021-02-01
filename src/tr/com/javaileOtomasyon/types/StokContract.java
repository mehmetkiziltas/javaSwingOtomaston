package tr.com.javaileOtomasyon.types;

public class StokContract {
    private String UrunAd;
    private String Adet;

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

    public Object[] GetVeriler()  {
        Object[] veriler = {UrunAd,Adet};
        return veriler;
    }
}
