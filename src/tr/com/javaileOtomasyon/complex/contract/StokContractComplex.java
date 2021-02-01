package tr.com.javaileOtomasyon.complex.contract;

import java.sql.Date;

public class StokContractComplex {

    private int Id;
    private String urunAdi;
    private String personelAdi;
    private String tarih;
    private int adet;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the urunAdi
     */
    public String getUrunAdi() {
        return urunAdi;
    }

    /**
     * @param urunAdi the urunAdi to set
     */
    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    /**
     * @return the personelAdi
     */
    public String getPersonelAdi() {
        return personelAdi;
    }

    /**
     * @param personelAdi the personelAdi to set
     */
    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    /**
     * @return the tarih
     */
    public String getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    /**
     * @return the adet
     */
    public int getAdet() {
        return adet;
    }

    /**
     * @param adet the adet to set
     */
    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Object[] getVeriler() {
        Object[] veriler = {Id, urunAdi, personelAdi, adet,  tarih};

        return veriler;
    }

    public String toString() {
        return personelAdi + " " + urunAdi;
    }
}
