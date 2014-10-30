import javax.swing.JOptionPane;

public class Kursboktest2 
{
	public static void main(String[] args)
	{
		Kursbok2 protokoll = new Kursbok2 ();
		
		String navn = JOptionPane.showInputDialog("Skriv kursnavn: ");
		
		protokoll.visTittel( navn );
	}
}
