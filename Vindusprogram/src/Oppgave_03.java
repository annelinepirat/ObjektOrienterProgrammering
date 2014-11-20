
public class Oppgave_03 
{
	public static String arealRektangel(double bredde, double høyde)
	{
		String resultat = "";
		if (bredde > 0 && høyde > 0)
		{
			double areal = bredde*høyde;
			resultat = "Arealet av rektangel med bredde " + bredde + " og høyde " + høyde + " = "  + areal;
			return resultat;
		}
		else
			return "Det er ikke mulig å regne ut areal av en rektangel med negativ verdi.";
	}
}
