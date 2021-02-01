
package tr.com.javaileOtomasyon.test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import tr.com.javaileOtomasyon.fe.LoginFE;


public class Run {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } 
            }
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new LoginFE();
            }
        });
    }
}
