import javax.swing.JOptionPane;

public class Kursbok4 
{
	private String kursnavn;
	
	public Kursbok4 (String n)
	{
		kursnavn = n;
	}
	public void setKursnavn ( String navn )
	{
		kursnavn = navn;
	}
	public String getKursnavn ()
	{
		return kursnavn;
	}
	public void visTittel()
	{
		JOptionPane.showMessageDialog(null, "Kursbok for " + kursnavn);
	}
}
