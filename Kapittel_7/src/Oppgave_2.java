import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Oppgave_2 
{
	public static void main (String[] args)
	{
		JTextArea tekstområde = new JTextArea();
		tekstområde.setText("Tallene var: \n");
		
		int [] tall = new int [10];
		for (int i = 0; i < 10; i++)
		{
			tall[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Skriv et heltall:"));
		if (tall[i] >= 1 && tall[i] <= 50)
		{
			tekstområde.append("*" + tall[i] + "\n");
		}
		else
		{
			tekstområde.append("\n");
		}
		}
		JOptionPane.showMessageDialog(null, tekstområde);
	}
}
