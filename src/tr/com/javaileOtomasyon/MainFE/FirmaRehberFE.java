package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.FirmalarDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.FirmalarContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirmaRehberFE extends JPanel implements FeInterfaces {
    public FirmaRehberFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel firmaRehberPanel = new JPanel(new BorderLayout());
        firmaRehberPanel.setPreferredSize(new Dimension(1700, 900));

        String[] firmaRehberKolonlar = {"AD", "YETKILIADSOYAD","TELEFON1","TELEFON2", "MAIL", "FAX"};
        DefaultTableModel firmaRehbermodel = new DefaultTableModel(firmaRehberKolonlar, 0);
        JTable firmaRehbertablo = new JTable(firmaRehbermodel);

        JScrollPane firmaRehberTablePane = new JScrollPane(firmaRehbertablo);

        firmaRehberPanel.add(firmaRehberTablePane, BorderLayout.CENTER);
        for (FirmalarContract FRcontract : new FirmalarDAL().GetAll()) {
            firmaRehbermodel.addRow(FRcontract.getRehber());
        }
        firmaRehberTablePane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) firmaRehbertablo.getModel();
                int selectedRowIndex = firmaRehbertablo.getSelectedRow();
                new MailAtFE((String) model.getValueAt(selectedRowIndex,4)).show();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return firmaRehberPanel;
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
