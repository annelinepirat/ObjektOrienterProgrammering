import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenererGruppe 
{	
	//LAGER EN ARRAY FOR ≈ HOLDE P≈ ALLE STUDENTENE
	private static Student[] stud = null;
	static String utskrift = ""; 

	//KONTRUKTÿR SOM FOR ≈ LAGE EN GENERERGRUPPE-OBJEKT SOM TAR I MOT ALLE STUDENTENE OG PLASSERER DISSE I ARRAYEN "stud".
	public GenererGruppe(Gruppe grp)
	{
		stud = grp.hentStudenterAsArray();
	}
	

	public void sortereKjonn() // start metode sortere kj¯nn
	{

		StringBuffer tekstomradeMann = new StringBuffer(); // se nÊrmere pÂ stringbuffer
		StringBuffer tekstomradeDame = new StringBuffer();
		StringBuffer tekstomradeSamlet = new StringBuffer("MANN\n");
		
		for (int i = 0; i < stud.length; i++)
		{
			if(stud[i].isMann() == true) //DENNE RETURNERER TRUE ELLER FALSE
			{
				tekstomradeMann.append(stud[i].getFornavn() + " " +stud[i].getEtternavn() + "\n");
			}
			else
			{
				tekstomradeDame.append(stud[i].getFornavn() + " " + stud[i].getEtternavn() + "\n");
			}	
		}// slutt for-l¯kke

		tekstomradeSamlet.append( tekstomradeMann);
		tekstomradeSamlet.append("\n\nDAME\n");
		tekstomradeSamlet.append( tekstomradeDame);
		
		utskrift = tekstomradeSamlet.toString();
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereKj¯nn

	public void sortereFag () // start metode sortere fag
	{
		StringBuffer tekstomrade1 = new StringBuffer("NORSK\n");// her tar vi h¯yde for at det kun er inntak om h¯sten
		StringBuffer tekstomrade2 = new StringBuffer("ENGELSK\n");
		StringBuffer tekstomrade3 = new StringBuffer("MATEMATIKK\n");
		
		int fag = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Skriv inn tallet pÂ hvilken fagklasse du vil se\n"
				+ "1: Norsk \n"
				+ "2: Engelsk \n"
				+ "3: Matematikk \n"));
		
		if (fag == 1)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getFag().toLowerCase().equals("norsk")) // plukker ut studenter med faget Norsk. 
				{
					tekstomrade1.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade1.append("\n");
				}
			}
			utskrift = tekstomrade1 + "";
		}
		else if (fag == 2)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getFag().toLowerCase().equals("engelsk"))  // plukker ut studenter med faget Engelsk. 
				{
					tekstomrade2.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade2.append("\n");
				}
			}
			utskrift = tekstomrade2 + "";
		}
		else if (fag == 3)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getFag().toLowerCase().equals("matematikk"))  // plukker ut studenter med faget Matematikk.
				{
					tekstomrade3.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade3.append("\n");
				}
			}
			utskrift = tekstomrade3 + "";
		} // slutt if-l¯kke
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereFag
	
	public void sortereStudiestart() // start metode sortere studiestart
	{
		//Student [] stud = grp.hentStudenterAsArray();
		
		StringBuffer tekstomrade1 = new StringBuffer("Høst 2010\n");// her tar vi h¯yde for at det kun er inntak om h¯sten
		StringBuffer tekstomrade2 = new StringBuffer("Høst 2011\n");
		StringBuffer tekstomrade3 = new StringBuffer("Høst 2012\n");
		StringBuffer tekstomrade4 = new StringBuffer("Høst 2013\n");
		StringBuffer tekstomrade5 = new StringBuffer("Høst 2014\n");
		
		String utskrift = "";
		int valgAar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Skriv inn tallet pÂ hvilket Ârskull du vil se\n"
				+ "1: 2010\t"
				+ "2: 2011\t"
				+ "3: 2012\t "
				+ "4: 2013\t"
				+ "5: 2014\t"));
		if (valgAar == 1)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2010)
				{
					tekstomrade1.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade1.append("\n");
				}
			}
			utskrift = tekstomrade1 + "";
		}
		else if (valgAar == 2)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2011)
				{
					tekstomrade2.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
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
					tekstomrade3.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
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
					tekstomrade4.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
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
					tekstomrade5.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade5.append("\n");
				}
			}
			utskrift = tekstomrade5 + "";
		}
		JOptionPane.showMessageDialog(null, utskrift);
	}

	public void sortereGodkjent ()// Lager liste over eksamen som er kvalifisert til eksamen. 
	{
		StringBuffer tekstomrade = new StringBuffer("Studenter kvalifisert til eksamen: \n");
		
		for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].isGodkjent() == true) // Plukker ut elevene som er kvalifisert til eksamen. SJEKK VARIABEL.
				{
					tekstomrade.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
					tekstomrade.append("\n");
				}
			}
			utskrift = tekstomrade + "";
			JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereStudiestart
	
	public void sortereAlfabetisk (Student[] stud)
	{
		StringBuffer tekstomrade = new StringBuffer("Alfabetisk liste over studenter: \n");
		
		String[] studenter = new String[stud.length]; 
		for (int i = 0; i < studenter.length; i++){
			studenter[i] = stud[i].toString();
		}
		Arrays.sort(studenter); // metode som sorterer array. Men hva sorteres? fornavn? etternavn? Sjekk dette.

		for ( int i = 0 ; i <= studenter.length ; i++ ) // for-l¯kke som henter ut navnene til alle studentene i array. St¯rre eller lik!
		{
			tekstomrade.append(studenter[i] + "\n"); // skriver ut navnene etterhvert som de blir sortert i array - er hvertfall tanken
		} // slutt for-l¯kke
		utskrift = tekstomrade + "";
		JOptionPane.showMessageDialog(null, utskrift);
	} // slutt metode sortereAlfabetisk
	
//	RIKTIG INITIALISERING AV ARRAY HER?
	public void sortereTilfeldig (Student[] stud) // start metode sortere tilfeldig. 
	{

		//Sortere tilfeldig
		List studenter = new ArrayList();//[stud.length]; 
		for (int i = 0; i < stud.length; i++){
			studenter.add(stud[i].toString());
		}
		Collections.shuffle(studenter); // metode som "shuffler"/stokker om objektene i arrayen. 
		
		
		// Skal det opprettes en egen array her for sortering, hvor jeg henter inn arrayen med objekter? Eller skal jeg fylle ny array med fornavn/etternavn og deretter sortere?
		int antallGrupper = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Hvor mange grupper vil du sortere studentene i?\n"));

		StringBuffer[] sb = new StringBuffer[antallGrupper];
		for (int i = 0; i < sb.length; i++){
			sb[i] = new StringBuffer();
		}
		
		int counter = 0;
		int studnr = 0;
		
		while (studnr < studenter.size()){
			sb[counter].append(studenter.get(studnr) + "\n");
			counter++;
			studnr++;
			
			if (counter >= antallGrupper)
				counter = 0;
		}
		
		for (int i = 0; i < studenter.size(); i++){
			System.out.println(studenter.get(i));
		}
		
		utskrift = "";
		
		for (int i = 0; i < sb.length; i++){
			utskrift += sb[i].toString() + "\n\n";
		}
		JOptionPane.showMessageDialog(null, utskrift);
	}// slutt metode sortere tilfeldig
} // slutt klasse