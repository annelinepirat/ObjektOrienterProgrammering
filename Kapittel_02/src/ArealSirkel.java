 import javax.swing.JOptionPane;
 public class ArealSirkel
 {
    public static void main(String[] args)
    {
    	String radiusSirkel;
    	radiusSirkel = JOptionPane.showInputDialog(null, 
    			"Skriv inn radius på sirkel", 
    			"Radius", 
    			JOptionPane.PLAIN_MESSAGE);
    			double radius =  Double.parseDouble(radiusSirkel);
    			double sum = 3.14 * radius * radius;
    			JOptionPane.showMessageDialog( null, 
    					sum, 
    					"Arealet av sirkelen er", 
    					JOptionPane.PLAIN_MESSAGE );
    }
 }