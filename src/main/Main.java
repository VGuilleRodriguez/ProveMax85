package main;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import vista.LoginVista;

/**
 *
 * @author nicolas
 */
public class Main {
    
    public static void main(String[] args) {
    
        /* FlatLaf setup */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        LoginVista loginView = new LoginVista();
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
    }
    
}
