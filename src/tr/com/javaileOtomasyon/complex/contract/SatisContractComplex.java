package tr.com.javaileOtomasyon.complex.contract;

import java.sql.Date;

public class SatisContractComplex {

    private int Id;
    private String musteriAdi;
    private String personelAdi;
    private String urunAdi;
    private int adet;
    private String tarih;

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
     * @return the musteriAdi
     */
    public String getMusteriAdi() {
        return musteriAdi;
    }

    /**
     * @param musteriAdi the musteriAdi to set
     */
    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
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

    public Object[] getVeriler() {
        Object[] satisVeriler = {Id, musteriAdi, personelAdi, urunAdi, adet, tarih};

        return satisVeriler;
    }

    @Override
    public String toString() {
        return musteriAdi + " " + personelAdi + " " + urunAdi;
    }

}
