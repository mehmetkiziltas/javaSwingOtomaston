package tr.com.javaileOtomasyon.types;

public class PersonelContract {

    private int id;
    private String AdiSoyadi;
    private String email;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the AdiSoyadi
     */
    public String getAdiSoyadi() {
        return AdiSoyadi;
    }

    /**
     * @param AdiSoyadi the AdiSoyadi to set
     */
    public void setAdiSoyadi(String AdiSoyadi) {
        this.AdiSoyadi = AdiSoyadi;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return AdiSoyadi;
    }

}
