import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main
{
	private Formatter output;
	private Formatter input;
	
	public void visMeny()
	{
		int valg = Integer.parseInt(
				JOptionPane.showInputDialog(
						null,
						"Skriv inn tallet på hva du vil gjøre\n "
						+ "1: Legg til student\n "
						+ "2: Generer studentliste\n "
						+ "0: Avslutt"));
		
		if (valg == 1)
		{
			aapneFil();
			leggTilStudent();// starter opp metoden aapneFil og leggTilStudent
		}
		else if (valg == 2)
		{
			//genererStudentliste();// starter metoden genererStudentliste
		}else if (valg == 0)
		{
			System.exit(0); // Avslutt
		}

	}
	
	public void aapneFil()
	{
		try
		{
			output = new Formatter ("Studentliste.txt");
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
	}
	
	public void leggTilStudent()
	{
		Student stud = new Student();
		int svar;
		
		do
		{
			String elevFornavn = JOptionPane.showInputDialog(null, "Skriv inn fornavnet på eleven", "Fornavn", JOptionPane.QUESTION_MESSAGE);
			String elevEtternavn = JOptionPane.showInputDialog(null, "Skriv inn etternavn på eleven", "Etternavn", JOptionPane.QUESTION_MESSAGE);
			String elevKjonn = JOptionPane.showInputDialog(null, "Skriv inn kjønn, \n(M)ann eller (D)ame?", "Kjønn", JOptionPane.QUESTION_MESSAGE);
			int studieStart = Integer.parseInt(JOptionPane.showInputDialog(null, "Hvilket år startet studenten?", "Studiestart", JOptionPane.QUESTION_MESSAGE));
			String fagomrade = JOptionPane.showInputDialog(null, "Hvilket fag har studenten?", "Fagområde", JOptionPane.QUESTION_MESSAGE);
			
			try
			{
				stud.setForNavn(elevFornavn);
				stud.setEtterNavn(elevEtternavn);
				stud.setKjonn(elevKjonn);
				stud.setStudieStart(studieStart);
				stud.setFagomrade(fagomrade);			

//				if (getKjonn.toLowerCase().equals("m"))
//				{
//					stud.setKjonn(true);
//				}
//				else
//				{
//					stud.setKjonn(false);
//				}


				if (stud.getForNavn() != null)
				{
					output.format("%s %s \n",
							stud.getForNavn(),
							stud.getEtterNavn());
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
	}

//
//	private void leggTilStudent()
//	{
//				
//		Student stud = new Student();
//		
//		//Spør om informasjon
//		JOptionPane.showInputDialog("LEGG TIL NY STUDENT\n\nStudentens fornavn:");
//		stud.setForNavn(innData.next());
//		JOptionPane.showInputDialog("Etternavn:");
//		stud.setEtterNavn(innData.next());
//		JOptionPane.showInputDialog("(M)ann eller (D)ame:");
//		if (innData.next().toLowerCase().equals("m"))
//		{
//			stud.setKjonn(true);
//		}
//		else
//		{
//			stud.setKjonn(false);
//		}
//		JOptionPane.showInputDialog("Studiestart (årstall): ");
//		stud.setStudieStart(innData.next());
//		JOptionPane.showInputDialog("Fagområde: ");
//		stud.setFagOmrade(innData.next());
//		
//		//Legge til Studentobjekten i Gruppa
//		gruppe.leggTilStudent(stud);
//		
//		//Lagre Gruppa
//		Filbehandling.lagreGruppe(gruppe);
//		
//		visMeny();
//	}
}	