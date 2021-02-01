/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.javaileOtomasyon.dal;

import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.DALInterfaces;
import tr.com.javaileOtomasyon.types.IlcelerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mehme
 */
public class IlcelerDAL extends ObjectHelper implements DALInterfaces<IlcelerContract>{

    @Override
    public void Insert(IlcelerContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IlcelerContract> GetAll() {
       return null;
    }

    @Override
    public IlcelerContract Delete(IlcelerContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(IlcelerContract entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IlcelerContract> GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<IlcelerContract> GetByName(String ilAdicek) {
        List<IlcelerContract> datacontract = new ArrayList<>();
        Connection connection = getConnection();
        IlcelerContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT distinct javaileotomasyon.ilce.isim,javaileotomasyon.ilce.il_no,javaileotomasyon.ilce.ilce_no\n" +
                    "FROM javaileotomasyon.ilce inner JOIN javaileotomasyon.il \n" +
                    "ON javaileotomasyon.ilce.il_no = (\n" +
                    "select javaileotomasyon.il.il_no\n" +
                    "from javaileotomasyon.il where javaileotomasyon.il.isim = +'" +ilAdicek +"'\n" +
                    ") ORDER BY javaileotomasyon.ilce.isim ASC");
            while (resultSet.next()) {
                contract = new IlcelerContract();
                contract.setIlce_no(resultSet.getInt("ilce_no"));
                contract.setIlceAdi(resultSet.getString("isim"));
                contract.setIl_no(resultSet.getInt("il_no"));
                datacontract.add(contract);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KatagoriDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datacontract;
    }

}
