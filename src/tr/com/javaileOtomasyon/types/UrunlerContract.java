package tr.com.javaileOtomasyon.types;

public class UrunlerContract {

    private int ID;
    private String ADI;
    private String MARKA;
    private String MODEL;
    private String YIL;
    private String ADET;
    private float ALISFIYAT;
    private float SATISFIYAT;
    private String DETAY;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getADI() {
        return ADI;
    }

    public void setADI(String ADI) {
        this.ADI = ADI;
    }

    public String getMARKA() {
        return MARKA;
    }

    public void setMARKA(String MARKA) {
        this.MARKA = MARKA;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getYIL() {
        return YIL;
    }

    public void setYIL(String YIL) {
        this.YIL = YIL;
    }

    public String getADET() {
        return ADET;
    }

    public void setADET(String ADET) {
        this.ADET = ADET;
    }

    public float getALISFIYAT() {
        return ALISFIYAT;
    }

    public void setALISFIYAT(float ALISFIYAT) {
        this.ALISFIYAT = ALISFIYAT;
    }

    public float getSATISFIYAT() {
        return SATISFIYAT;
    }

    public void setSATISFIYAT(float SATISFIYAT) {
        this.SATISFIYAT = SATISFIYAT;
    }

    public String getDETAY() {
        return DETAY;
    }

    public void setDETAY(String DETAY) {
        this.DETAY = DETAY;
    }

    @Override
    public String toString() {
        return ADI;
    }
}
