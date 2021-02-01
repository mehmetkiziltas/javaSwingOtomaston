package tr.com.javaileOtomasyon.types;

public class KatagoriContract {

    private int id;
    private String Adi;
    private int parentId;

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

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return Adi;
    }

}
