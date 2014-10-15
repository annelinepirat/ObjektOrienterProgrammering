import javax.swing.JOptionPane;

public class SekunderTilTimerMinutterSekunder 
{
	public static void main(String[] args)
	{
		String antallSekunder = JOptionPane.showInputDialog("Skriv antall sekunder du briker på å lese en side");
		int sekunder1 = Integer.parseInt(antallSekunder);
		
		int timer;
		int minutter;
		int sekunder;
		
		timer = sekunder1/3600;
		minutter = sekunder1%3600/60;
		sekunder = sekunder1%60;
		
		JOptionPane.showMessageDialog(null,
				"Du brukte " +
		timer + " timer " + minutter + " minutter " + sekunder + " sekunder " + " på å lese en side.");
	}
}
