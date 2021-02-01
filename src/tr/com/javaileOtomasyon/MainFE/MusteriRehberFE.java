package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.dal.MusteriDAL;
import tr.com.javaileOtomasyon.interfaces.FeInterfaces;
import tr.com.javaileOtomasyon.types.MusteriContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MusteriRehberFE extends JPanel implements FeInterfaces {

    public MusteriRehberFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
        JPanel musteriRehberPanel = new JPanel(new BorderLayout());
        musteriRehberPanel.setPreferredSize(new Dimension(1700, 900));

        String[] musteriRehberKolonlar = {"AD", "SOYAD", "TELEFON1","TELEFON2", "MAIL"};
        DefaultTableModel musteriRehbermodel = new DefaultTableModel(musteriRehberKolonlar, 0);
        JTable musteriRehbertablo = new JTable(musteriRehbermodel);

        JScrollPane RehberTablePane = new JScrollPane(musteriRehbertablo);

        musteriRehberPanel.add(RehberTablePane, BorderLayout.CENTER);
        for (MusteriContract MRcontract : new MusteriDAL().GetAll()) {
            musteriRehbermodel.addRow(MRcontract.getRehber());
        }
        RehberTablePane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) musteriRehbertablo.getModel();
                int selectedRowIndex = musteriRehbertablo.getSelectedRow();
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
        return musteriRehberPanel;
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
