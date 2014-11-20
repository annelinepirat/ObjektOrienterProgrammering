import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main
{
	private Formatter output;// gjør det mulig å skrive til fil
	private Scanner input;// gjør det mulig å lese fra fil
	
	public void visMeny()
	{
		int valg = Integer.parseInt(
				JOptionPane.showInputDialog(
						null,
						"Skriv inn tallet på hva du vil gjøre\n"
						+ "1: Legg til student\n"
						+ "2: Generer gruppe\n"
						+ "0: Avslutt"));
		
		if (valg == 1)
		{
			aapneFil();// åpner filen slik at man 
			lesFil();
			leggTilStudent();// starter opp metoden aapneFil og leggTilStudent
			lukkFil();
		}
		else if (valg == 2)
		{
			lagDiverseGrupper();
			//genererGruppe();// starter metoden genererStudentliste
		}else if (valg == 0)
		{
			System.exit(0); // Avslutt
		}

	}
	
	public void aapneFil()
	{
		try
		{
			input = new Scanner (new File ("Studentliste.txt"));//leser inn fra filen
			if (input.hasNext())
			{
				System.out.println("Hei");
			}
			else
			output = new Formatter ("Studentliste.txt");// skriver til filen
		}
		catch (SecurityException se)// hvis ikke try slår igjennom sjekk om den er låst eller ei
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Du har ikke skriverettigheter til denne fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog 
		}
		catch (FileNotFoundException fnfe)// hvis ikke try slår igjennom sjekk om fila eksisterer
		{
			JOptionPane.showMessageDialog(
					null, 
					"", 
					"Feil ved åpning av fila", 
					JOptionPane.PLAIN_MESSAGE);// MessageDialog
		}
	}// slutt på metoden aapneFil
	
	public void lesFil()
	{
		Student stud = new Student(null, 0, false, null, null, null);
		
		try
		{
			while(input.hasNext())
			{
				stud.setFornavn(input.next());
				stud.setEtternavn(input.next());
				stud.setKjonn(input.next());
				stud.setStudiestart(Integer.parseInt(input.next()));
				stud.setFag(input.next());
				
				if (stud.getFornavn() != null)
				{
					output.format("%s %s %s %d %s", 
							stud.getFornavn(),
							stud.getEtternavn(),
							stud.getKjonn(),
							stud.getStudiestart(),
							stud.getFag());
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"",
							"Må ha et navn.",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		catch (NoSuchElementException elementException)// sjekker om det er noe feil
		{
			JOptionPane.showMessageDialog(
					null, 
					"Upassende format i fila", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			input.close();
			System.exit(1);
		}
		catch (IllegalStateException stateException)// sjekker om det er noe feil
		{
			JOptionPane.showMessageDialog(
					null, 
					"Feil i lesing fra fil", 
					null, 
					JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}	
	}
	
	public void leggTilStudent()
	{	
		Student student = new Student(null, 0, false, null, null, null);
		int svar;
		
		do//sjekk om dette overskriver det som er scannet fra txt.fila?
		{
			String elevFornavn = JOptionPane.showInputDialog(null, "Skriv inn fornavnet på eleven", "Fornavn", JOptionPane.QUESTION_MESSAGE);
			String elevEtternavn = JOptionPane.showInputDialog(null, "Skriv inn etternavn på eleven", "Etternavn", JOptionPane.QUESTION_MESSAGE);
			String elevKjonn = JOptionPane.showInputDialog(null, "Skriv inn hvilket kjønn, mann eller dame?", "Kjønn", JOptionPane.QUESTION_MESSAGE);
			boolean mann;
			if (elevKjonn.toLowerCase().equals("mann"))
				mann = true;
			else
				mann = false;
			int studieStart = Integer.parseInt(JOptionPane.showInputDialog(null, "Hvilket år startet studenten?", "Studiestart", JOptionPane.QUESTION_MESSAGE));
			String fagomrade = JOptionPane.showInputDialog(null, "Hvilket fag har studenten?", "Fagområde", JOptionPane.QUESTION_MESSAGE);
			
			
			try
			{
				student.setFornavn(elevFornavn);
				student.setEtternavn(elevEtternavn);
				student.setKjonn(elevKjonn);
				student.setStudiestart(studieStart);
				student.setFag(fagomrade);			

				if (student.getFornavn() != null)
				{
					output.format("%s %s %s %d %s\n",
							student.getFornavn(),
							student.getEtternavn(),
							student.getKjonn(),
							student.getStudiestart(),
							student.getFag());
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"",
							"Må ha et elevnavn.",
							JOptionPane.PLAIN_MESSAGE);
				}
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
	}// slutt på metoden leggTilStudent
	
	public void lukkFil()
	{
		if(input != null)
			input.close();
		if(output != null)
			output.close();
	}// slutt på metoden lukk fil

	public void lagDiverseGrupper()
	{
		int valgTre = Integer.parseInt(
				JOptionPane.showInputDialog(
						null,
						"Skriv inn tallet på hva du vil gjøre\n"
						+ "1: Sorter etter kjønn\n"
						+ "2: Sorter etter fag\n"
						+ "3: Sorter etter studiestart\n"
						+ "4: Lag tilfeldig sammensetting\n"
						+ "0: Avslutt"));
		GenererGruppe kjor = new GenererGruppe();
		if (valgTre == 1)
		{
			kjor.sortereKjonn();
			// kjør metode ... og returner verdi ...
		}
		else if (valgTre == 2)
		{
			int velgFag = Integer.parseInt(JOptionPane.showInputDialog(
					null,
					"Skriv inn tallet på det faget du har:\n"
					+ "1:"))
			// kjør metode ... og returner verdi ...
		}
		else if (valgTre == 3)
		{
			// kjør metode ... og returner verdi...	
		}
		else if (valgTre == 4)
		{
			// kjør metode ... og returner verdi ...
		}
		else if (valgTre == 0)
		{
			System.exit(0); // Avslutt
		}
	}
}