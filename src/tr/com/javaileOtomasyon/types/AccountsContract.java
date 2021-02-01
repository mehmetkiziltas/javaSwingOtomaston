package tr.com.javaileOtomasyon.types;

public class AccountsContract {

    private int Id;
    private int yetkiliId;
    private int personelId;
    private String sifre;

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
     * @return the yetkiliId
     */
    public int getYetkiliId() {
        return yetkiliId;
    }

    /**
     * @param yetkiliId the yetkiliId to set
     */
    public void setYetkiliId(int yetkiliId) {
        this.yetkiliId = yetkiliId;
    }

    /**
     * @return the personelId
     */
    public int getPersonelId() {
        return personelId;
    }

    /**
     * @param personelId the personelId to set
     */
    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return Id + " " + personelId + " " + sifre + " " + yetkiliId;
    }

}
