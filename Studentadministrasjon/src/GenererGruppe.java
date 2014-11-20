/*Følgende utfordringer har jeg møtt på, da min kunnskap ikke strekker til: 
 * Konstruktør til klassene main og student
 * Å hente inn student-objektene i en array, og deretter hente informasjon ut fra denne arrayen.
 * Å randomisere array med student-objekter + fordele randomisert array i grupperinger (bruke tekstområde her?)
 * Takker for alle innspill/forslag til kode!!
 */

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class GenererGruppe 
{
	private String forNavn;
	private String etterNavn;
	private int studieStart;
	private String valgtFag;
	private boolean mann;

	public GenererGruppe (String fornavn, String etternavn, int studiestart, String fag, boolean mann) // konstrukt¯r
	{
		this.forNavn = fornavn;
		this.etterNavn = etternavn;
		this.studieStart = studiestart;
		this.valgtFag = fag;
		this.mann = mann;
	}

//	Student student = new Student();// konstruktør

	public void sortereKjonn() // start metode sortere kjønn
	{
		Student [] stud = grp.hentStudenterAsArray();
		JTextArea tekstomradeMann = new JTextArea();
		tekstomradeMann.setText("Mann\n");
		JTextArea tekstomradeDame = new JTextArea();
		tekstomradeDame.setText("Dame\n");
		JTextArea tekstomradeSamlet = new JTextArea();
		tekstomradeSamlet.setText("Kjønn");
		
		for (int i = 0; i < stud.length; i++)
		{
			if(stud[i].isMann() == mann)
			{
				tekstomradeMann.append(stud[i].getFornavn() + stud[i].getEtternavn() + "\n");
			}
			else if (stud[i].isMann() != mann)
			{
				tekstomradeDame.append(stud[i].getFornavn() + " " + stud[i].getEtternavn() + "\n");
			}	
		}
		tekstomradeSamlet.append(tekstomradeMann + "\t" + tekstomradeDame + "\n");
		String utskrift = tekstomradeSamlet + "";
		
		JOptionPane.showMessageDialog(null, utskrift);
	}

	public void sortereFag () // start metode sortere fag
	{
		
	//	<while-l¯kke?>
	//	<get fag, set fag>
	//	<initialiser if-setninger>
	//	if FAG1
	//		legg student.fornavn + student.etternavn i tekstomrÂde1
	//	if FAG2
	//		legg student.fornavn + student.etternavn i tekstomrÂde1

	//		osv.
	//<slutt if-setning>
	//<slutt while>
	}
	
	public void sortereStudiestart() // start metode sortere studiestart
	{
		Student [] stud = grp.hentStudenterAsArray();
		JTextArea tekstomrade1 = new JTextArea();
		tekstomrade1.setText("Høst 2010");// her tar vi høyde for at det kunn er inntak om høsten
		JTextArea tekstomrade2 = new JTextArea();
		tekstomrade2.setText("Høst 2011");
		JTextArea tekstomrade3 = new JTextArea();
		tekstomrade3.setText("Høst 2012");
		JTextArea tekstomrade4 = new JTextArea();
		tekstomrade4.setText("Høst 2013");
		JTextArea tekstomrade5 = new JTextArea();
		tekstomrade5.setText("Høst 2014");
		String utskrift = "";
		int valgAar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Skriv inn tallet på hvilket årskull du vil se\n"
				+ "1: 2010"
				+ "2: 2011"
				+ "3: 2012"
				+ "4: 2013"
				+ "5: 2014"));
		if (valgAar == 1)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2010)
				{
					tekstomrade1.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
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
				}
			}
			utskrift = tekstomrade2 + "";
		}
		else if (valgAar == 3)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2010)
				{
					tekstomrade3.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
				}
			}
			utskrift = tekstomrade3 + "";
		}
		else if (valgAar == 4)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2010)
				{
					tekstomrade4.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
				}
			}
			utskrift = tekstomrade4 + "";
		}
		else if (valgAar == 5)
		{
			for (int i = 0; i < stud.length; i++)
			{
				if (stud[i].getStudiestart() == 2010)
				{
					tekstomrade5.append(stud[i].getFornavn() + " " + stud[i].getEtternavn());
				}
			}
			utskrift = tekstomrade5 + "";
		}
		JOptionPane.showMessageDialog(null, utskrift);
	}

	public static void sortereTilfeldig (int [] a) // start metode sortere tilfeldig
	{
		
	
	
	//	<JOptionPane-vindu - sp¯r om antall grupper> 
	//	<get elevnavn/studentnummer, set elevnavn>
	//	<legg alle elever i en array> 
	//	<randomiser array>
	//	<legg til i riktig antall grupper> // bruke tekstomrÂde (st¯rrelse pÂ tekstomrÂde lik antall grupper valgt) eller ny array her? tekstomrÂde best, mest ryddig?
	}
//<skriv ut valgt liste>

} // slutt klasse