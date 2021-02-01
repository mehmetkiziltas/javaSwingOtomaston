package tr.com.javaileOtomasyon.types;

public class SehirlerContract {

    private int Id;
    private String sehirAdi;

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
     * @return the sehirAdi
     */
    public String getSehirAdi() {
        return sehirAdi;
    }

    /**
     * @param sehirAdi the sehirAdi to set
     */
    public void setSehirAdi(String sehirAdi) {
        this.sehirAdi = sehirAdi;
    }

    @Override
    public String toString() {
        return sehirAdi;
    }

}
