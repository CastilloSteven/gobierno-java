package Vista;

import javax.swing.JOptionPane;

public class InOut {
    
    public int pedirEntero(String m){
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }
    
    public String pedirString(String m){
        return JOptionPane.showInputDialog(m);
    }
    
    public void mostraDatos(String m){
        JOptionPane.showMessageDialog(null, m);
    }
    public void mostraDatos2(int m){
        JOptionPane.showMessageDialog(null, m);
    }
    
    
     
}
