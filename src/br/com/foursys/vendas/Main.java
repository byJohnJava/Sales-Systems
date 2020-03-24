package br.com.foursys.vendas;

import br.com.foursys.vendas.view.LoginPrincipal;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 *@author's: Equipe 4 "Diego, we have a problem!"
 */
public class Main {

    public static void main(String[] args) {

       try {
            AcrylLookAndFeel.setTheme("Default", "aaaaaaa", "EPIC TECHNOLOGY");
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final int MAX = 100;
        final JFrame progressBar = new JFrame("Carregando Sistema...");

        // creates progress bar
        final JProgressBar pb = new JProgressBar();
        pb.setMinimum(0);
        pb.setMaximum(MAX);
        pb.setStringPainted(true);
        pb.setOrientation(JProgressBar.HORIZONTAL);

        // add progress bar
        progressBar.setLayout(new FlowLayout());
        progressBar.getContentPane().add(pb);

        progressBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        progressBar.setSize(240, 60);
        progressBar.setVisible(true);
        progressBar.setLocationRelativeTo(null);
        progressBar.setResizable(false);

        // update progressbar
        for (int i = 0; i <= MAX; i++) {
            final int currentValue = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(25);

            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(progressBar, e.getMessage());
            }
        }

        progressBar.setVisible(false);
       new LoginPrincipal();
        
    }

}
