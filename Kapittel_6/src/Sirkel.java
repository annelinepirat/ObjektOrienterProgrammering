import java.text.DecimalFormat;

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
	public double getRadius() //radius verdien
	{
		return radius;
	}
	public double diameter ()
	{
		return 2*radius;
	}
	public double omkrets ()
	{
		return 2*Math.PI*radius;
	}
	public double areal ()
	{
		return Math.PI*radius*radius;
	}
	public static DecimalFormat desimalKonvertering() 
	{
		String formateringsstreng = "#,###,##0.00";
		DecimalFormat formateringsobjekt = new DecimalFormat(formateringsstreng);
		return formateringsobjekt;
	}
}
