package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.swing.*;

public class SatislarFE extends JPanel implements FeInterfaces {

    public SatislarFE() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
    }

    @Override
    public JPanel initPanel() {
//
//        JPanel satisPanel = new JPanel(new BorderLayout());
//        JPanel satisSagPanel = new JPanel(new BorderLayout());
//        JPanel satisSagUstPanel = new JPanel(new GridLayout(6, 2));
//        JPanel satisSagAltPanel = new JPanel();
//
//        satisSagPanel.setBorder(BorderFactory.createTitledBorder("Satış İşlemleri"));
//        String[] satisKolonlar = {"Id", "Personel Adı", "Müşteri Adı", "Ürün Adı", "Adeti", "Tarih"};
//        DefaultTableModel satismodel = new DefaultTableModel(satisKolonlar, 0);
//        JTable satisTablo = new JTable(satismodel);
//        JScrollPane satisTablePane = new JScrollPane(satisTablo);
//        JLabel musteriLabel = new JLabel("Müşteri Adı: ", JLabel.RIGHT);
//        satisSagUstPanel.add(musteriLabel);
//        JComboBox musteriAdiBox = new JComboBox(new MusteriDAL().GetAll().toArray());
//        satisSagUstPanel.add(musteriAdiBox);
//        JLabel satisUrunAdiLabel = new JLabel("Ürün Adı: ", JLabel.RIGHT);
//        satisSagUstPanel.add(satisUrunAdiLabel);
//        JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDAL().GetAllUrunler().toArray());
//        satisSagUstPanel.add(satisUrunAdiBox);
//        JLabel satisAdetLabel = new JLabel("Adet: ", JLabel.RIGHT);
//        satisSagUstPanel.add(satisAdetLabel);
//        JTextField satisAdetField = new JTextField(10);
//        satisSagUstPanel.add(satisAdetField);
//        JLabel satisTarihiLabel = new JLabel("Satış Tarihi: ", JLabel.RIGHT);
//        satisSagUstPanel.add(satisTarihiLabel);
//        JDateChooser satisTarihi = new JDateChooser();
//        satisSagUstPanel.add(satisTarihi);
//        JButton satisEkleButton = new JButton("Satış Yap");
//        satisSagUstPanel.add(satisEkleButton);
//        JButton satisYenileButton = new JButton("Yenile");
//        satisSagUstPanel.add(satisYenileButton);
//
//        satisEkleButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PersonelContract personelContract = (PersonelContract) LoginFE.emailBox.getSelectedItem();
//                UrunlerContractComplex urunlerContract = (UrunlerContractComplex) satisUrunAdiBox.getSelectedItem();
//                MusteriContract musteriContract = (MusteriContract) musteriAdiBox.getSelectedItem();
//                SatisContract contract = new SatisContract();
//
//                contract.setMusteriId(musteriContract.getId());
//                contract.setParsonelId(personelContract.getId());
//                contract.setUrunId(urunlerContract.getID());
//                contract.setAdet(Integer.parseInt(satisAdetField.getText()));
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                String date = format.format(satisTarihi.getDate());
//                contract.setTarih(date);
//
//                new SatisDAL().Insert(contract);
//                StokContract stokContract = new StokContract();
//
//                stokContract.setPersonelId(personelContract.getId());
//                stokContract.setUrunId(urunlerContract.getID());
//                stokContract.setAdet(-Integer.parseInt(satisAdetField.getText()));
//                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//                String date1 = format1.format(satisTarihi.getDate());
//                stokContract.setTarih(date1);
//                new StokDAL().Insert(stokContract);
//
//                JOptionPane.showMessageDialog(getRootPane(), musteriContract.getAd()
//                        + " adlı müşteriye satıs işlemi gerçekleşmiştir");
//                int satisSatir = satismodel.getRowCount();
//                for (int i = 0; i < satisSatir; i++) {
//                    satismodel.removeRow(0);
//                }
//                for (SatisContractComplex satisContract : new SatisDAL().GetAllSatis()) {
//                    satismodel.addRow(satisContract.getVeriler());
//                }
//            }
//        });
//        for (SatisContractComplex satisContract : new SatisDAL().GetAllSatis()) {
//            satismodel.addRow(satisContract.getVeriler());
//        }
//        satisYenileButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int satisSatir = satismodel.getRowCount();
//                for (int i = 0; i < satisSatir; i++) {
//                    satismodel.removeRow(0);
//                }
//                for (SatisContractComplex satisContract : new SatisDAL().GetAllSatis()) {
//                    satismodel.addRow(satisContract.getVeriler());
//                }
//            }
//        });
//        satisSagPanel.add(satisSagUstPanel, BorderLayout.NORTH);
//        satisSagPanel.add(satisSagAltPanel, BorderLayout.SOUTH);
//        satisPanel.add(satisSagPanel, BorderLayout.EAST);
//        satisPanel.add(satisTablePane, BorderLayout.CENTER);
        return null;
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
