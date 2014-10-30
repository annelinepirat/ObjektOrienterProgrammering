 import javax.swing.JOptionPane;
 public class AddisjonDesimaltall
 {
    public static void main( String args[] )
    {
       String førsteSifferstreng;
       String andreSifferstreng;
       førsteSifferstreng = JOptionPane.showInputDialog("Skriv desimaltall her");
    		   double tall1 = Double.parseDouble(førsteSifferstreng);
    	andreSifferstreng = JOptionPane.showInputDialog("Skriv desimaltall her");
    			double tall2 = Double.parseDouble(andreSifferstreng);
    	

       double sum = tall1 + tall2;

       JOptionPane.showMessageDialog( null, 
    		   førsteSifferstreng + 
    		   " + " + 
    		   andreSifferstreng + 
    		   " = " + 
    		   sum,
          "Resultater", JOptionPane.PLAIN_MESSAGE );
    } 
}  