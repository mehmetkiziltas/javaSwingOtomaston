/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.javaileOtomasyon.types;

/**
 *
 * @author mehme
 */
public class IlcelerContract {
    private int ilce_no;
    private String ilceAdi;
    private int il_no;

    /**
     * @return the ilce_no
     */
    public int getIlce_no() {
        return ilce_no;
    }

    /**
     * @param ilce_no the ilce_no to set
     */
    public void setIlce_no(int ilce_no) {
        this.ilce_no = ilce_no;
    }

    /**
     * @return the ilceAdi
     */
    public String getIlceAdi() {
        return ilceAdi;
    }

    /**
     * @param ilceAdi the ilceAdi to set
     */
    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    /**
     * @return the il_no
     */
    public int getIl_no() {
        return il_no;
    }

    /**
     * @param il_no the il_no to set
     */
    public void setIl_no(int il_no) {
        this.il_no = il_no;
    }

    @Override
    public String toString() {
        return ilceAdi;
    }
    
 
}
