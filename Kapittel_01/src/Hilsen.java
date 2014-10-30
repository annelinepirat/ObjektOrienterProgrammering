import javax.swing.JOptionPane;

public class Hilsen 
{
	public static void main(String[] args)
	{
		String fornavn	;
		String etternavn;
		fornavn = JOptionPane.showInputDialog("Hallo!\n" + 
		"Hva er ditt fornavn?");	
		etternavn = JOptionPane.showInputDialog("Hva er ditt etternavn?");
		String skrift;
		skrift = "Ditt fulle navn er  " + fornavn + " " + etternavn;
		JOptionPane.showMessageDialog(null, skrift);
		}

}
