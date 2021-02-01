package tr.com.javaileOtomasyon.MainFE;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import tr.com.javaileOtomasyon.core.ObjectHelper;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiderRaporFE extends JPanel implements FeInterfaces {

    public GiderRaporFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        Connection connection;
        panel.setPreferredSize(new Dimension(1700, 900));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL?serverTimezone=Turkey","root","root");
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\mehme\\Documents\\NetBeansProjects\\SatisVeStok\\src\\tr\\com\\javaileOtomasyon\\Raporlar\\giderler.jrxml");
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(report,null,connection);
            JRViewer v = new JRViewer(print);
            panel.setLayout(new BorderLayout());
            panel.add(v);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
