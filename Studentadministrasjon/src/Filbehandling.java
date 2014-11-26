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
 * Filebehandling
 * 
 * Klassen lagrer og leser et gruppeobjekt med studenter til fil med navn "gruppe.obj".
 */


public class Filbehandling 
{
	
	//Filnavnet til gruppefila.
	private static final String FILNAVN = "gruppe.obj";

	
	//Metode for � laste gruppeobjektet, returnerer et Gruppe-objekt.
	public static Gruppe lastGruppe()
	{	
		File f = new File(Filbehandling.FILNAVN);
		Gruppe gruppe = null;

		if (f.exists())
		{
			try
			{
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
				System.out.println("Fant ikke klassen ved lasting \n " + cnf); gruppe = new Gruppe();
			}
			catch (InvalidClassException ice)
			{
				System.out.println("Endringer siden sist! Ikke kompatibel med gammel brukerdata.\nLager ny brukerdata."); gruppe = new Gruppe();
			}
			catch (IOException ioe)
			{
				System.out.println("Feil ved lasting \n" + ioe);
			}			
		}
		else
		{
			//Hvis feil ved lagring, anta at filen er �delagt eller ikke eksisterer. Lag en tomt nytt gruppeobjekt!
			//(Dette er ikke noe produksjonsverdig l�sning, men i forhold til kriteriene i dette prosjektet s� holder det).
			gruppe = new Gruppe();   //Ved annen feil ved lasting, start med et nytt Gruppeobjekt.
		}

		
		//SKRIVER UT EN LISTE OVER ALLE LAGREDE STUDENTER HVER GANG FILEN �PNES.
		//Mest nyttig under utvikling, bare for � se at alt stemmer :)
//		for (int i = 0; i < gruppe.hentStudenterAsVector().size(); i++){
//			System.out.println( gruppe.hentStudenterAsVector().elementAt(i));
//		}
		
		return gruppe;	
	}


	//Metode for � lagre et Gruppe-objekt, tar i mot et gruppeobjekt.
	public static void lagreGruppe(Gruppe grp)
	{

		try
		{
			FileOutputStream fos = new FileOutputStream(Filbehandling.FILNAVN);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(grp);
			
			//T�mming av alle str�mmer (for � hindre delevis lagring og korrupte filer.
			oos.flush();
			oos.close();	
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
		}
		catch (IOException ioe)
		{
			System.out.println("Feil ved lagring! " + ioe);
		}

	}		


}