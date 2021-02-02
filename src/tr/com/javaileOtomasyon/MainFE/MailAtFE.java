package tr.com.javaileOtomasyon.MainFE;

import tr.com.javaileOtomasyon.interfaces.FeInterfaces;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class MailAtFE extends JDialog implements FeInterfaces {

    private String MailAdresi;

    public MailAtFE(String mail) {
        setMailAdresi(mail);
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);

        setTitle("Mail Gönderme Paneli");
        setVisible(true);
        panel.setSize(new Dimension(100,100));
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel MailPanel = new JPanel(new BorderLayout());
        JPanel MailSolPanel = new JPanel(new BorderLayout());
        JPanel kasaSolUstPanel = new JPanel(new GridLayout(5, 2));

        JLabel MailAdresiLabel = new JLabel("Mail Adresi: ", JLabel.RIGHT);
        kasaSolUstPanel.add(MailAdresiLabel);
        JTextArea MailAdresiBox = new JTextArea();
        kasaSolUstPanel.add(MailAdresiBox);

        MailAdresiBox.setText(getMailAdresi());

        JLabel MailKonuLabel = new JLabel("Mail Konu: ", JLabel.RIGHT);
        kasaSolUstPanel.add(MailKonuLabel);
        JTextArea MailKonuBox = new JTextArea(5,20){
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };
        MailKonuBox.setLineWrap(true);
        kasaSolUstPanel.add(MailKonuBox);

        JLabel MailMesajLabel = new JLabel("Mesaj: ", JLabel.RIGHT);
        kasaSolUstPanel.add(MailMesajLabel);
        JTextArea MailMesajBox = new JTextArea(5,20);
        MailMesajBox.setLineWrap(true);
        kasaSolUstPanel.add(MailMesajBox);

        JLabel MailSonuc = new JLabel();
        kasaSolUstPanel.add(MailSonuc);

        JButton MailButton = new JButton("Gönder");
        kasaSolUstPanel.add(MailButton);
        MailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Properties pro = new Properties();
                pro.put("mail.smtp.host","smtp.gmail.com");
                pro.put("mail.smtp.socketFactory.port","465");
                pro.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                pro.put("mail.smtp.auth","true");
                pro.put("mail.smtp.port","465");

                Session session = Session.getDefaultInstance(pro,
                        new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("","");
                    }
                });
                Message message = new MimeMessage(session);
                try {
                    message.setFrom(new InternetAddress(""));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(MailAdresiBox.getText()));
                    message.setSubject(MailKonuBox.getText());
                    message.setText(MailMesajBox.getText());
                    Transport.send(message);
                    MailSonuc.setText("Mesaj Gönderildi");
                    dispose();
                } catch (MessagingException messagingException) {
                    MailSonuc.setText("Mail Gönderilemedi Hata");
                    dispose();
                }
            }
        });

        MailSolPanel.add(kasaSolUstPanel, BorderLayout.NORTH);
        MailPanel.add(MailSolPanel, BorderLayout.WEST);
        MailPanel.setSize(new Dimension(200,200));

        return MailPanel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }

    public String getMailAdresi() {
        return MailAdresi;
    }

    public void setMailAdresi(String mailAdresi) {
        MailAdresi = mailAdresi;
    }
}
