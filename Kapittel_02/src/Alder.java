import javax.swing.JOptionPane;
import java.util.Calendar;

public class Alder 
{
	public static void main (String[] args)
	{
		String fornavn;
		String fødselsår;
		int født;
		int år;
		int alder;
		
		
		fornavn = JOptionPane.showInputDialog("Skriv inn fornavn");
		fødselsår = JOptionPane.showInputDialog("Skriv inn fødselsår");
		født = Integer.parseInt(fødselsår);
		
		Calendar datetime = Calendar.getInstance();
		år = datetime.get(Calendar.YEAR);
		
		alder = år - født;
		JOptionPane.showMessageDialog( null, 
				"Hei " + fornavn + ", i år fyller du " + alder + " år.",
				"Alder", JOptionPane.PLAIN_MESSAGE);		
	}

}
