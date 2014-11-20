import java.util.Random;

public class Oppgave_02_terning 
{
	private int verdi;
	private Random generator = new Random();
	
	public Oppgave_02_terning()
	{
		kast();
	}
	
	public void kast()
	{
		verdi = 1 + generator.nextInt(6);
	}
	
	public int getVerdi()
	{
		return verdi;
	}
}
