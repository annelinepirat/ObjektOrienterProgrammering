/***********************************************************************
 * @author Ida
 * 
 * Klasse for å generere ulike gruppesammensetninger av studentgruppen. 
 * Klassen kalles opp av Main, og bruker får velge hvilke gruppesammensetning 
 * som ønskes. 
 * Valgene er gruppering på bakgrunn av kjønn, fag, kull (år for studiestart), 
 * alfabetisk liste, 
 * tilfeldig gruppering basert på et ønsket antall grupper og studenter 
 * kvalifisert til eksamen på bakgrunn av leverte og godkjente arbeidskrav.
 * Grupperingene lagres ikke på noen fil da tanken er at programmet skal 
 * brukes hyppig som administrasjonsverktøy. 
 * Samtidig vil dette sikre at det hele tiden genereres grupper ut fra oppdatert 
 * studentinformasjon, 
 * hvilket er avgjørende i blant annet "sortereGodkjent"-gruppen.
 ************************************************************************/
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenererGruppe 
{	
	//LAGER EN ARRAY FOR ≈ HOLDE P≈ ALLE STUDENTENE
	private static Student[] stud = null;
	static String utskrift = ""; /* utskrift-variabel som får 
	verdi basert på valg gruppegenerering. Når verdi er satt skrives 
	dette ut i et dialogvindu i slutten av valgt metode. */

	/*KONTRUKTÿR SOM FOR ≈ LAGE EN GENERERGRUPPE-OBJEKT SOM TAR I MOT 
	ALLE STUDENTENE OG PLASSERER DISSE I ARRAYEN "stud".*/
	public GenererGruppe(Gruppe grp)
	{
		stud = grp.hentStudenterAsArray();
	}

	public void sortereKjonn() // start metode sortere kjønn
	{
		/* StringBuffer er en type String-variabel som tillater 
		kontinuerlig lagring av ny informasjon*/
		StringBuffer tekstomradeMann = new StringBuffer(); 
		StringBuffer tekstomradeDame = new StringBuffer();
		StringBuffer tekstomradeSamlet = new StringBuffer("MANN\n"); // overskrift Mann

		for (int i = 0; i < stud.length; i++)
		{
			if(stud[i].isMann() == true) //DENNE RETURNERER TRUE ELLER FALSE
			{
				tekstomradeMann.append(stud[i].getFornavn() 
						+ " " 
						+stud[i].getEtternavn() 
						+ "\n");
			}
			else /* alt annet enn mann, settes i dette programmet likt dame. 
				Vi har med andre ord valgt å ikke ta hensyn til eventuelle 
				studenter som ikke identifiserer seg som mann eller kvinne 
				(og tar i aller høyeste grad kritikk for dette).*/
			{
				tekstomradeDame.append(stud[i].getFornavn() 
						+ " " 
						+ stud[i].getEtternavn() 
						+ "\n");
			}	
		}// slutt for-løkke
		// samlet utskrift av mannfolka
		tekstomradeSamlet.append( tekstomradeMann);
		// overskrift Dame med linjeskift både før og etter
		tekstomradeSamlet.append("\n\nDAME\n"); 
		// samlet utskrift av kvinnfolka (og eventuelt andre ikke-menn)
		tekstomradeSamlet.append( tekstomradeDame); 

		utskrift = tekstomradeSamlet.toString();
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereKjønn

	// start metode sortere fag
	public void sortereFag () 
	{
		// her tar vi hØyde for at det kun er inntak om hØsten
		StringBuffer tekstomrade1 = new StringBuffer("NORSK\n");
		StringBuffer tekstomrade2 = new StringBuffer("ENGELSK\n");
		StringBuffer tekstomrade3 = new StringBuffer("MATEMATIKK\n");
		
		int fag = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Skriv inn tallet p¬ hvilken fagklasse du vil se\n"
				+ "1: Norsk \n"
				+ "2: Engelsk \n"
				+ "3: Matematikk \n"));
		/* IF-SETNINGER SOM STARTER SORTERING AV FAGKLASSER. FÿRSTE 
		IF-SETNING KOMMENTERT, GANGEN ER LIK I ELSE-IF-SETNINGENE.*/
		if (fag == 1)
		{
			// for-løkke som kjører gjennom hele arrayens lengde
			for (int i = 0; i < stud.length; i++) 
			{
				// plukker ut studenter med faget Norsk.
				if (stud[i].getFag().toLowerCase().equals("norsk"))  
				{
					/* skriver ut studentenes fornavn og 
					etternavn etterhvert som de identifiseres som norskstudenter.*/
					tekstomrade1.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn()); 
					tekstomrade1.append("\n"); // Linjeskift legges til
				}
			}
			// utskrift av utfyllt tekstområde med ferdigsortert fagklasse
			utskrift = tekstomrade1 + ""; 
		}
		else if (fag == 2)
		{
			for (int i = 0; i < stud.length; i++)
			{
				// plukker ut studenter med faget Engelsk.
				if (stud[i].getFag().toLowerCase().equals("engelsk"))   
				{
					tekstomrade2.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade2.append("\n");
				}
			}
			utskrift = tekstomrade2 + "";
		}
		else if (fag == 3)
		{
			for (int i = 0; i < stud.length; i++)
			{
				// plukker ut studenter med faget Matematikk.
				if (stud[i].getFag().toLowerCase().equals("matematikk"))  
				{
					tekstomrade3.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade3.append("\n");
				}
			}
			utskrift = tekstomrade3 + "";
		} // slutt if-løkke
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereFag
	
	/* start metode sortere studiestart. Her tar vi høyde for at det 
	kun er inntak om høsten*/
	public void sortereStudiestart() 
	{
		//Student [] stud = grp.hentStudenterAsArray();
		
		// her tar vi hØyde for at det kun er inntak om hØsten
		StringBuffer tekstomrade1 = new StringBuffer("Høst 2010\n");
		StringBuffer tekstomrade2 = new StringBuffer("Høst 2011\n");
		StringBuffer tekstomrade3 = new StringBuffer("Høst 2012\n");
		StringBuffer tekstomrade4 = new StringBuffer("Høst 2013\n");
		StringBuffer tekstomrade5 = new StringBuffer("Høst 2014\n");
		
		String utskrift = "";
		int valgAar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Skriv inn tallet p¬ hvilket ¬rskull du vil se\n"
				+ "1: 2010\t"
				+ "2: 2011\t"
				+ "3: 2012\t "
				+ "4: 2013\t"
				+ "5: 2014\t"));
		
		/* IF-SETNINGER SOM STARTER SORTERING AV ≈RSKULL. FÿRSTE IF-SETNING 
		KOMMENTERT, GANGEN ER LIK I ELSE-IF-SETNINGENE.*/
		if (valgAar == 1)
		{
			// for-løkke som kjører gjennom hele arrayens lengde
			for (int i = 0; i < stud.length; i++) 
			{
				// plukker ut studenter som startet i 2010
				if (stud[i].getStudiestart() == 2010) 
				{
					// studentens fornavn og etternavn legges til i tekstområdet
					tekstomrade1.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn()); 
					tekstomrade1.append("\n"); // linjeskift legges til
				}
			}
			// utskrift av utfyllt tekstområde med ferdigsortert årskull.
			utskrift = tekstomrade1 + ""; 
		}
		else if (valgAar == 2)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2011)
				{
					tekstomrade2.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade2.append("\n");
				}
			}
			utskrift = tekstomrade2 + "";
		}
		else if (valgAar == 3)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2012)
				{
					tekstomrade3.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade3.append("\n");
				}
			}
			utskrift = tekstomrade3 + "";
		}
		else if (valgAar == 4)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2013)
				{
					tekstomrade4.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade4.append("\n");
				}
			}
			utskrift = tekstomrade4 + "";
		}
		else if (valgAar == 5)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2014)
				{
					tekstomrade5.append(stud[i].getFornavn() 
							+ " " + stud[i].getEtternavn());
					tekstomrade5.append("\n");
				}
			}
			utskrift = tekstomrade5 + "";
		}
		
		
		/* Til slutt sjekkes det om brukeren skriver inn noe feil 
		eller trykker OK/kryss. Gir isåfall bruker mulighet til å starte på nytt*/
		else
		{
				int ja = JOptionPane.showOptionDialog(null, 
						"Vil du forsøke å skrive inn riktig år på nytt?",
						"Error! Error!", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, null, null);
				// hvis ja, sett ny verdi til variabelen valgAar.
				if (ja == JOptionPane.YES_OPTION) 
				{
					valgAar = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Skriv inn tallet p¬ hvilket ¬rskull du vil se\n"
							+ "1: 2010\t"
							+ "2: 2011\t"
							+ "3: 2012\t "
							+ "4: 2013\t"
							+ "5: 2014\t"));
				}
				else
				{
					// hvis ikke ja (altså nei i dette tilfellet); avslutt programmet.
					System.exit(0);  
				} // slutt else
		} // slutt else
		
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereStudestart

	// Lager liste over studenter som er kvalifisert til eksamen.
	public void sortereGodkjent () 
	{
		StringBuffer tekstomrade = new StringBuffer("Studenter kvalifisert til eksamen: \n");

		// for-løkke som kjører gjennom hele arrayens lengde, objekt for objekt
		for (int i = 0; i < stud.length; i++) 
		{
			// Plukker ut studentene som er kvalifisert til eksamen.
			if (stud[i].isGodkjent() == true) 
			{
				// Fornavn og etternavn legges til i tekstområdet.
				tekstomrade.append(stud[i].getFornavn() 
						+ " " + stud[i].getEtternavn()); 
				tekstomrade.append("\n");
			}
		}
		utskrift = tekstomrade + "";
		// ferdigsortert studentgruppe skrives ut i dialogboks.
		JOptionPane.showMessageDialog(null, utskrift); 
	} // slutt metode sortereStudiestart

	// Lager alfabetisk oversikt over studentene (ekstrasnacks og særdeles nyttig sortering)
	public void sortereAlfabetisk (Student[] stud) 
	{
		/* variabel av typen Stringbuffer, hvor verdien modifiseres 
		kontinuerlig gjennom metoden*/
		StringBuffer tekstomrade = new StringBuffer("Alfabetisk liste over studenter: \n"); 

		/* initialisering av ny array for bare studentenes fornavn (her kunne vi 
		også laget på etternavn, men vi liker å være uformelle)*/
		String[] studenter = new String[stud.length];
		/* for-løkke som kjører gjennom hele arrayens lengde, objekt for objekt, 
		og henter ut fornavnet deres*/
		for (int i = 0; i < studenter.length; i++)  
		{
			studenter[i] = stud[i].toString();
		}
		
		Arrays.sort(studenter); // metode som sorterer array "studenter"

		// for-løkke som henter ut navnene til alle studentene i array.
		for ( int i = 0 ; i < stud.length ; i++ ) 
		{
			/* skriver ut studentene i et tekstområde etterhvert som 
			de blir sortert i array.*/
			tekstomrade.append(studenter[i] + "\n"); 
		} // slutt for-løkke
		utskrift = tekstomrade + "";
		// utskrift av alfabetisk liste i et dialogvindu.
		JOptionPane.showMessageDialog(null, utskrift); 
	} // slutt metode sortereAlfabetisk
	
	// start metode sortere tilfeldig.
	public void sortereTilfeldig (Student[] stud)  
	{
		// Ny array som henter inn fornavnene på studentene.
		List studenter = new ArrayList();
		// for-løkke som kjører gjennom arrayen og formaterer fornavn til String-variabler.
		for (int i = 0; i < stud.length; i++) 
		{
			studenter.add(stud[i].toString());
		}
		// metode som "shuffler"/stokker om objektene i arrayen.
		Collections.shuffle(studenter);  

		// bruker blir spurt antall grupper ønsket.
		int antallGrupper = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Hvor mange grupper vil du sortere studentene i?\n")); 

		StringBuffer[] sb = new StringBuffer[antallGrupper];
		// for-løkke som kjører gjennom hele arrayens lengde
		for (int i = 0; i < sb.length; i++) 
		{
			sb[i] = new StringBuffer();
		}

		int counter = 0;
		int studnr = 0;
		

		while (studnr < studenter.size()) 
		{
			/* Gruppefordeling: 
			 * Ved hjelp av en teller plasseres studentene i antallGrupper grupper. 
			 * Når en student er plassert i hver gruppe kjøres counter-variabelen 
			 * til 0, og neste student blir plassert i gruppe 1, neste etter det i 
			 * gruppe 2 */
			// første student plasseres i første gruppe, andre i andre osv.
			sb[counter].append(studenter.get(studnr) + "\n");   
			counter++;
			studnr++;

			/* counter-variabel teller oppover så lenge den er mindre enn verdien 
			til antallGrupper; blir den større settes den til 0.*/
			if (counter >= antallGrupper) 
				counter = 0; 
		} // slutt while-løkke

		// skriver ut studentene, ferdig sortert og fordelt i grupper.
		for (int i = 0; i < studenter.size(); i++)  
		{
			System.out.println(studenter.get(i));
		}

		utskrift = "";

		/* går gjennom utskriften og formaterer til dem til String, 
		slik at de kan skrives ut i JOptionPane.*/
		for (int i = 0; i < sb.length; i++) 
		{
			utskrift += sb[i].toString() + "\n\n";
		}
		JOptionPane.showMessageDialog(null, utskrift);
	}// slutt metode sortere tilfeldig
} // slutt klasse