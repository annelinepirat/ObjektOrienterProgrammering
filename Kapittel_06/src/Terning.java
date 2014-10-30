import java.util.Random;// importerer

public class Terning 
{
	private int verdi;//lager en int verdi med navn verdi
	private Random generator = new Random ();//gjør kall på metoden random i java.util
	
//	public Terning()
//	{
//		kast();
//	} hva gjør denne???
	
	public void kast ()//starter en generator som lager et random tall med seks muligheter fra tallet 1
	{
		verdi = 1 + generator.nextInt (6);
	}
	public int getVerdi()//returnerer verdi fra kastet over til getVerdi
	{
		return verdi;
	}
}// slutt på klassen
