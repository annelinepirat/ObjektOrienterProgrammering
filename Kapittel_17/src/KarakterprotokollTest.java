
public class KarakterprotokollTest 
{
	public static void main (String [] args)
	{
		LagKlasseliste program = new LagKlasseliste();
		
		program.aapneFil();
		program.leggTilElev();
		program.lukkFil();
		
		EndreKlasseliste kul = new EndreKlasseliste();
		
		kul.aapneFil();
		kul.lesFil();
		//kul.leggTilFil();
		kul.lukkFil();
	}
}