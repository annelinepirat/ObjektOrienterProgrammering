/*************************************************************
 * @author AnneLine
 * class Start
 * 
 * Dette er en oppstartsklasse som starter klassen Main og
 * laster tidligere objekter fra klassen Filbehandling.
 *************************************************************/
public class Start 
{	
	public static void main(String[] args) 
	{
		/* starter Main klassen og sender inn tidligere 
		 * student-objekter for ha disse med*/
		new Main(Filbehandling.lastGruppe());
	}
}// slutt på klassen Start