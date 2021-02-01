package tr.com.javaileOtomasyon.types;

public class YetkilerContract {

    private int Id;
    private String Adi;

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
     * @return the Adi
     */
    public String getAdi() {
        return Adi;
    }

    /**
     * @param Adi the Adi to set
     */
    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    @Override
    public String toString() {
        return Adi;
    }

}
