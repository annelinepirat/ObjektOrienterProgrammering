// importerer ulike klasser 
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Main
{
	private Gruppe gruppe = null; //Gjør gruppeobjektet (med alle studentene) tilgjengelig for hele Main-metoden.
	
	public Main(Gruppe grp)// sender inn grp fra klassen Gruppe
	{
		//Setter den lokale gruppevariablen til gruppa som er lastet fra fila.
		gruppe = grp;
		
		//Viser menyen (starter programmet)
		visMeny();
	}

	public void visMeny()
	{
		// gir brukeren ulike valg som kan taes
		String valg =JOptionPane.showInputDialog(
						null,
						"Skriv inn tallet på hva du vil gjøre\n"
						+ "1: Legg til student\n"
						+ "2: Generer gruppe\n"
						+ "3: Endre student\n"
						+ "0: Avslutt");
		if (valg == null)// sjekker om brukeren trykker på cancel og gir mulighet til å starte på nytt
		{
				System.exit(0);
		}
		if (valg.equals("1"))// hvis brukeren skriver 1 slår denne til
		{
			leggTilStudent();// starter opp metoden aapneFil og leggTilStudent
		}
		else if (valg.equals("2"))// hvis brukeren skriver 2 slår dette til
		{
			lagDiverseGrupper();// starter metoden lagDiverseGrupper-GenererGruppe
		}
		else if (valg.equals("3"))
		{
			new GUIMain(gruppe, this);// HVA SKAL KALLES OPP HER???
		}
		else if (valg.equals("0"))// hvis brukeren skriver 0 så slår dette til
		{
			System.exit(0); // Avslutt
		}
		else// sjekker om brukeren skriver inn noe feil eller trykker ok/kryss og gir brukeren mulighet til å starte på nytt
		{
				int ja = JOptionPane.showOptionDialog(null, "Du skrev ikke riktig, prøve igjen?",
						"Feil", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						null, 
						null);
				if (ja == JOptionPane.YES_OPTION)
				{
					visMeny();
				}
				else
				{
					System.exit(0);
				}
		}// slutt på else/if tester
	}// slutt på visMeny-metode
	
	public void leggTilStudent()
	{	
		Student student = null;// oppretter en konstruktør til klassen Student
		boolean mann = false;// gjør mann tilgjengelig gjennom hele metoden
		int svar;// gjør svar tilgjengelig gjennom hele metoden
		
		do// starter en løkke der brukeren kan skrive inn input
		{
			student = new Student();// kaller opp Studentklassen
			String elevFornavn = JOptionPane.showInputDialog(null, "Skriv inn fornavnet på eleven", "Fornavn", JOptionPane.QUESTION_MESSAGE);// fornavn fra brukeren
			if (elevFornavn == null || elevFornavn == "")// sjekker om brukeren trykker cancel og skriver ut feilmelding og starter på nytt
			{
				System.exit(0);
			}
			if (elevFornavn.isEmpty())// hvis brukeren lar input stå tomt så sett fornanv til error
			{
				elevFornavn = JOptionPane.showInputDialog(null, "Må ha et fornavn, skriv inn på nytt");
			}
			String elevEtternavn = JOptionPane.showInputDialog(null, "Skriv inn etternavn på eleven", "Etternavn", JOptionPane.QUESTION_MESSAGE);// input fra brukeren
			if (elevEtternavn == null || elevEtternavn == "")// sjekker om brukeren trykker cancel og skriver ut feilmelding og starter på nytt
			{
				System.exit(0);
			}
			if (elevEtternavn.isEmpty())// hvis brukeren lar input stå tomt så sett etternavn til error
			{
				elevEtternavn = JOptionPane.showInputDialog(null, "Må ha et etternav, skriv inn på nytt");
			}
			String elevKjonn = JOptionPane.showInputDialog(null, "Skriv inn hvilket kjønn, mann eller dame?", "Kjønn", JOptionPane.QUESTION_MESSAGE);// input fra brukeren
			if (elevKjonn == null || elevKjonn == "")
			{
				System.exit(0);
			}
			if (elevKjonn.isEmpty())
			{
				elevKjonn = JOptionPane.showInputDialog(null, "Må ha et kjønn, skriv inn på nytt");
			}
			if (elevKjonn.toLowerCase().equals("mann"))// sjekker om brukeren har skrevet inn mann
				mann = true;// setter da mann til true
			else// sjekker om brukeren har skrevet inn noe annet enn mann
				mann = false;// setter da mann til false
			String studieStart = JOptionPane.showInputDialog(null, "Hvilket år startet studenten?", "Studiestart", JOptionPane.QUESTION_MESSAGE);// input fra brukeren
			if (studieStart == null || studieStart == "")// hvis brukeren trykker cancel skriv ut beskjed og ny input
			{
				System.exit(0);
			}
			while (studieStart.isEmpty())// hvis brukeren lar input stå tom start på nytt
			{
				studieStart = JOptionPane.showInputDialog(null, "Må ha et studieår, skriv inn på nytt.");
				if (studieStart == null || studieStart == "")
				{
					System.exit(0);
				}
			}
			int studStart = Integer.parseInt(studieStart);
			if (studStart < 2010 || studStart > 2014)
			{
				do
				{
					studieStart = JOptionPane.showInputDialog(null, "Studenter som går på dette studiet har startet mellom 2010 og 2014, skriv inn årstall på nytt.");
					if (studieStart == null || studieStart == "")
					{
						System.exit(0);
					}
					studStart = Integer.parseInt(studieStart);
				}while (studStart < 2010 || studStart > 2014);
			}
			
			String fagomrade = JOptionPane.showInputDialog("Velg nr. for faget til studenten:\n"
					+ "1. Norsk\n"
					+ "2. Engelsk\n"
					+ "3. Matematikk");	
			if (fagomrade == null || fagomrade == "")
			{
				System.exit(0);
			}
			if (fagomrade.isEmpty())
			{
				fagomrade = JOptionPane.showInputDialog("Må ha et fag, prøv på nytt.\n"
						+ "1. Norsk\n"
						+ "2. Engelsk\n"
						+ "3. Matematikk");
			}
			int fag = Integer.parseInt(fagomrade);
			if (fag < 1 || fag > 3)
			{
				do
				{
				JOptionPane.showMessageDialog(null, "Feil nr, prøv igjen.");
				fagomrade = JOptionPane.showInputDialog("Velg nr. for faget til studenten:\n"
						+ "1. Norsk\n"
						+ "2. Engelsk\n"
						+ "3. Matematikk");
				if (fagomrade == null || fagomrade == "")
				{
					System.exit(0);
				}
				fag = Integer.parseInt(fagomrade);
				}while (fag < 1 || fag > 3);
			}
			
			try
			{
				student.setFornavn(elevFornavn);
				student.setEtternavn(elevEtternavn);
				student.setKjonn(mann);
				student.setStudiestart(studieStart);
				if (fagomrade.equals("1"))
				{
					student.setFag("Norsk");// her bestemmes det hvilket fag studenten har
				}
				else if (fagomrade.equals("2"))
				{
					student.setFag("Engelsk");
				}
				else if (fagomrade.equals("3"))
				{
					student.setFag("Matematikk");
				}

				gruppe.leggTilStudent(student);
				Filbehandling.lagreGruppe(gruppe);// etter hver gang leggTilStudent har kjørt så sendes de inn i filbehandlings-klassen og lagres i objekter der
			}
			catch (FormatterClosedException fce)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil ved skriving til fil", 
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			catch (NoSuchElementException ee)// hvis try ikke slår til - feilmelding
			{
				JOptionPane.showMessageDialog(
						null, 
						"", 
						"Feil input, prøv igjen", 
						JOptionPane.PLAIN_MESSAGE);// feilmelding
			}
			svar = JOptionPane.showOptionDialog(null, 
					"Vil du lese inn flere elever?", 
					"Klasseliste", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);
		}while (svar == JOptionPane.YES_OPTION);
		visMeny();
	}// slutt på metoden leggTilStudent

	public void lagDiverseGrupper()
	{
		int igjen;
		Student[] stud = null;
		do
		{
			String valgtre = JOptionPane.showInputDialog(null,
							"Skriv inn tallet på hva du vil gjøre\n"
							+ "1: Sorter etter kjønn\n"
							+ "2: Sorter etter fag\n"
							+ "3: Sorter etter studiestart\n"
							+ "4: Sorter alfabetisk\n"
							+ "5: Lag tilfeldig sammensetting\n"
							+ "6: Lag liste over de som er godkjent til eksamen\n"
							+ "0: Avslutt");
			GenererGruppe kjor = new GenererGruppe(gruppe);
			if (valgtre.equals("1"))// sortere etter kjønn
			{
				kjor.sortereKjonn();
				// kjør metode ... og returner verdi ...
			}
			else if (valgtre.equals("2"))// sortere etter fag
			{
				kjor.sortereFag();
			}
			else if (valgtre.equals("3"))// sortere etter studiestartår
			{
				kjor.sortereStudiestart();
			}
			else if (valgtre.equals("4"))// sorterer alfabetisk
			{
				kjor.sortereAlfabetisk(gruppe.hentStudenterAsArray());
			}
			else if (valgtre.equals("5"))// sett sammen tilfeldig
			{	
				kjor.sortereTilfeldig(gruppe.hentStudenterAsArray());
			}
			else if (valgtre.equals("6"))// sorterer etter de som kan gå til eksamen
			{
				kjor.sortereGodkjent();
			}
			else if (valgtre.equals("0"))// avslutter
			{
				System.exit(0); // Avslutt
			}
			else
			{
				igjen = JOptionPane.showOptionDialog(null, 
						"Du skrev inn et valg som ikke finnes, prøve på nytt?",
						"Lister",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						null, 
						null);
				if (igjen == JOptionPane.YES_OPTION)
					lagDiverseGrupper();
			}
			igjen = JOptionPane.showOptionDialog(null,
					"Vil du generere nye lister?", 
					"Lister",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);
		}while(igjen == JOptionPane.YES_OPTION);
		System.exit(0);
	}
}