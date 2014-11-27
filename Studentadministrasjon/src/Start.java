//Dette er kun en oppstartsklasse for å initiere et objekt av "Main" og laste evt. tidligere grupper.
public class Start 
{	
	public static void main(String[] args) 
	{
		// starter Main klassen og sender inn tidligere student-objekter for ha disse med
		new Main(Filbehandling.lastGruppe());
	}
}// slutt på klassen Start