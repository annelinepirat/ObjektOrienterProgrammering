import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Filebehandling.class
 * 
 * Klassen lagrer og leser et gruppeobjekt med studenter til fil med navn "gruppe.obj" ved Â bruke Java sin serializable funksjon.
 * 
 * Denne klassen er skrevet av ÿYSTEIN MÿRKESDAL.
 */


public class Filbehandling 
{
	
	//Filnavnet til gruppefila som blir lagret pÂ harddisken (statisk ettersom det ikke skal vÊre flere tilfeller av denne. final slik at den er fast og ikke endres).
	//Dette gj¯r det lett Â endre filnavnet, uten Â mÂtte gÂ gjennom hele koden.
	public static final String FILNAVN = "gruppe.obj";

	
	//Metode for Â laste gruppeobjektet, returnerer et Gruppe-objekt.
	//OBS! Hvis feil ved lagring, anta at filen er ¯delagt eller ikke eksisterer. Lag en tomt nytt gruppeobjekt! (Dette er ikke noe produksjonsverdig l¯sning, men i forhold til kriteriene i dette prosjektet sÂ holder det).
	public static Gruppe lastGruppe()
	{	
		File f = new File(Filbehandling.FILNAVN);
		Gruppe gruppe = null;

		if (f.exists())
		{
			//Filbehandling kj¯res i en try-klamme, slik at feil kan bli behandlet i stedet for Â krÊsje programmet.
			try
			{
				//Opprette en str¯m fra filen, en buffer for stabil lesing, og en str¯m for Â ta imot objektet som blir lest.
				FileInputStream fis = new FileInputStream(Filbehandling.FILNAVN);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);		    	

				//Leser objektet fra filen
				Object obj = ois.readObject();

				//Kontrollerer om objektet er av typen "Gruppe"
				if (obj instanceof Gruppe)
				{
					gruppe = (Gruppe)obj;	
				}
				
				//Lukker filen.
				ois.close();
				bis.close();
				fis.close();
			}
			catch (ClassNotFoundException cnf)
			{
				//Datafilen inneholder ikke klassen gruppe. Start programmet med en ny, tom studentgruppe.
				System.out.println("Fant ikke klassen ved lasting \n " + cnf); gruppe = new Gruppe();
			}
			catch (InvalidClassException ice)
			{
				//Progammet er ikke lenger kompatibelt med lagret data. Start programmet med en ny, tom studentgruppe.
				System.out.println("Endringer siden sist! Ikke kompatibel med gammel brukerdata.\nLager ny brukerdata."); gruppe = new Gruppe();
			}
			catch (IOException ioe)
			{
				//Generelt problem med innlastning. Start programmet med en ny, tom studentgruppe.
				System.out.println("Feil ved lasting \n" + ioe); gruppe = new Gruppe();
			}			
		}
		else
		{
			//Det eksisterer ikke en fil med gruppa. Start programmet med en tom gruppe.
			gruppe = new Gruppe(); 
		}

		
		//SKRIVER UT EN LISTE OVER ALLE LAGREDE STUDENTER HVER GANG FILEN ≈PNES.
		//Mest nyttig under utvikling, bare for Â se at alt stemmer :)
		for (int i = 0; i < gruppe.hentStudenterAsVector().size(); i++){
			System.out.println( gruppe.hentStudenterAsVector().elementAt(i));
		}
		
		return gruppe;	
	}


	//Metode for Â lagre et Gruppe-objekt, tar i mot et gruppeobjekt.
	public static void lagreGruppe(Gruppe grp)
	{

		//Filbehandling kj¯res i en try-klamme, slik at feil kan bli behandlet i stedet for Â krÊsje programmet.
		try
		{
			//Opprette en str¯m til filen, en buffer for stabil skriving, og en str¯m for Â sende objektet til filen.
			FileOutputStream fos = new FileOutputStream(Filbehandling.FILNAVN);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(grp);
			
			//T¯mming av alle str¯mmer (for Â hindre delevis lagring og korrupte filer.
			oos.flush();
			oos.close();	
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
		}
		catch (IOException ioe)
		{
			System.out.println("Feil ved lagring! " + ioe); //Gir brukeren beskjed om at lagringen ikke var vellykket, i tillegg vises java sin feilmelding.
		}
	}		
}