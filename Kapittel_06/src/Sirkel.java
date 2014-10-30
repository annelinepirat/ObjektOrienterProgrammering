public class Sirkel 
{
	private double radius; //lokal variabel
	
	public void setRadius(double radiusInput) //får radiusInput fra bruker og utfører if test
	{
		if (radiusInput <= 0.0) // mindre eller lik null?
		{
			radiusInput = 0.0; // gjør om til null
		}
		else 
			radius = radiusInput; // hvis ikke...
	}
	public double getRadius() //lager en get-metode som returnerer radius verdien
	{
		return radius;
	}
	public double diameter ()// lager diameter metode returnerer diameteren av en sirkel med verdi radius
	{
		return 2*radius;
	}
	public double omkrets ()// omkrets metode returnerer omkrets av sirkel med verdi radius og pi
	{
		return 2*Math.PI*radius;
	}
	public double areal ()// areal metode returnerer areal av sirkel med verdi radius og 
	{
		return Math.PI*radius*radius;
	}
}
