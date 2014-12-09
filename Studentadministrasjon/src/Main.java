 /***********************************************************
 * @author AnneLine
 * Denne klassen skal først og fremst starte opp en meny
 * slik at brukeren får noen valg å gjøre. Valgene brukeren
 * får er å legge til student, generere grupper, endre student
 * eller legge til oppgaver, eller å avslutte programmet.
 * Alt etter hva brukeren velger å gjøre i menyen så vil det
 * bli kalt opp en metode som så starter, enten innad i klassen
 * eller i andre klasser.
 * 
 * Det første som skjer i denne klassen er at vi initialiserer 
 * en variabel som kalles gruppe, og setter den til null. Dette
 * gjør vi fordi vi vil at denne variabelen skal være
 * tilgjengeig i hele klassen. Etter dette kaller vi opp klassen
 * Gruppe og setter verdier fra den inn i variabelen gruppe.
 * Når dette er gjort så vises menyen til brukeren på skjermen.
 * 
 * Når visMeny starter får brukeren fire valg og skal så trykke
 * det tallet som tilsvarer det brukeren ønsker å gjøre. Her får
 * brukeren en feilmelding om den skriver et annet tall som ikke
 * finnes eller om den skriver bokstaver.
 * Etter at brukeren har valgt sitt tall blir det gjort en sjekk
 * som sender brukeren dit den ønsker, altså kaller opp ulike
 * metoder innad i klassen eller i andre klasser.
 * 
 * I metoden leggTilStudent blir opprettet en konstruktør 
 * student som viser til klassen Student. I tillegg blir det 
 * opprettet to variabler; en boolean og en int. Før det settes
 * i gang en do/while-løkke som kjører så lenge brukeren velger 
 * å trykke ja på spørsmål om den vil lese inn flere studenter.
 * Inne i denne do/while-løkka får brokered beskjed om å legge 
 * til informasjon om studenter. Informasjon som skal legges 
 * inn er fornavn, etternavn, kjønn, studiestart og fagområde.
 * Fornavn, etternavn, kjønn og studiestart er input der  
 * brukeren kan bruke fritekst. Dette blir sjekket for noen 
 * feil, men til forbedring av programmet så kunne man ha 
 * sjekket om det ble lagt inn stor bokstav i navnene. På 
 * fagområde inputen skal brukeren velge mellom tre ulike fag og 
 * skrive inn tallet som stemmer overens med det faget studenten 
 * har. Dette gjorde vi fordi vi så at det ble for omfattende 
 * sjekker om brukeren skulle få lov til å skrive inn fritekst. 
 * Til senere forbedring kan det bli sett på hvordan man skal 
 * gjøre disse sjekkene slik at man kan bruke informasjonen fra 
 * brukeren her til å dele inn i grupper senere. Etter at vi har 
 * fått all informasjonen fra brukeren skal vi plassere dette 
 * inn i klassen Student. Vi sender dermed en og en 
 * informasjonsbolk inn i klassen Student og til de ulike 
 * set.metodene. Når dette er gjort kaller vi på klassen Gruppe 
 * og sender inn informasjonsbolkene om studenten inn der til 
 * leggTilStudent metoden. Helt til slutt kaller vi på klassen 
 * Filbehandling og metoden lagreGruppe og sender inn gruppe-
 * objektene til denne klassen slik at de blir lagret.
 * 
 * I metoden lagDiverseGrupper blir det laget en do/while-løkke
 * som kjører så lenge brukeren velger å lage nye grupper, hvis 
 * ikke så vises start menyen på nytt. Valgene brukeren får i 
 * lagDiverseGrupper er 1. Sortere etter kjønn, 2. Sortere etter 
 * fag, 3. Sortere etter studiestart, 4. Sorter alfabetisk, 5. 
 * Lage tilfeldig sammensetning, 6. Lage liste over de som kan 
 * gå opp til eksamen og 0. avslutte programmet. Alt etter hva 
 * brukeren velger å gjøre, så blir den sendt videre til til 
 * klassen GenererGruppe klassen og forskjellige metoder innad i 
 * den klassen.
 ***********************************************************/
// importerer ulike klasser 
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Main
{
	/*Dette er en konstruktør som initialiserer
	 * variabelen gruppe og setter denne til null
	 * i første omgang, for at denne skal være
	 * tilgjengelig i hele klassen.*/
	private Gruppe gruppe = null; 
	
	// sender inn verdier fra klassen Gruppe
	public Main(Gruppe grp)
	{
		/*Setter verdiene fra klassen Gruppe til
		 * den lokale gruppevariablen slik at verdien
		 * i gruppe blir fylt opp med objekter.*/
		gruppe = grp;
		
		//Viser menyen (starter programmet)
		visMeny();
	}

	public void visMeny()
	{
		// gir brukeren ulike valg som kan taes
		String valg =JOptionPane.showInputDialog(
						null,
						"Skriv inn tallet p\u00E5 hva du vil gj\u00F8re:\n"
						+ "1: Legg til student.\n"
						+ "2: Generer gruppe.\n"
						+ "3: Endre student eller legg til oppgaver.\n"
						+ "0: Avslutt.");
		/* sjekker om brukeren trykker på cancel og gir 
		mulighet til å starte på nytt*/
		if (valg == null)
		{
				System.exit(0);
		}
		if (valg.equals("1"))// hvis brukeren skriver 1 slår denne til
		{
			// starter opp metoden aapneFil og leggTilStudent
			leggTilStudent();
		}
		else if (valg.equals("2"))// hvis brukeren skriver 2 slår dette til
		{
			// starter metoden lagDiverseGrupper-GenererGruppe fra Ida
			lagDiverseGrupper();
		}
		else if (valg.equals("3"))
		{
			// kaller opp vindus klassen GUIMain til Øystein
			new GUIMain(gruppe, this);
		}
		else if (valg.equals("0"))// hvis brukeren skriver 0 så slår dette til
		{
			System.exit(0); // Avslutt
		}
		else/* sjekker om brukeren skriver inn noe feil eller trykker 
			ok/kryss og gir brukeren mulighet til å starte på nytt*/
		{
				int ja = JOptionPane.showOptionDialog(null, "Du skrev ikke riktig,"
						+ " pr\u00F8ve igjen?",
						"Feil", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						null, 
						null);
				if (ja == JOptionPane.YES_OPTION)
				{
					// start på nytt om bruker trykker ja
					visMeny();
				}
				else
				{
					// avslutt om bruker trykker nei eller cancel/kryss
					System.exit(0);
				}
		}// slutt på else/if tester
	}// slutt på visMeny-metode
	
	public void leggTilStudent()
	{	
		// oppretter en konstruktør til klassen Student
		Student student = null;
		// gjør mann tilgjengelig gjennom hele metoden
		boolean mann = false;
		// gjør svar tilgjengelig gjennom hele metoden
		int svar;
		
		// starter en løkke der brukeren kan skrive inn input
		do
		{
			// kaller opp Studentklassen
			student = new Student();
			// fornavn fra brukeren
			String elevFornavn = JOptionPane.showInputDialog(null, 
					"Skriv inn fornavnet p\u00E5 eleven:", 
					"Fornavn", 
					JOptionPane.QUESTION_MESSAGE);
			/* sjekker om brukeren trykker cancel eller kryss 
			og avslutter programmet*/
			if (elevFornavn == null || elevFornavn == "")
			{
				System.exit(0);
			}
			// hvis brukeren lar input stå tomt får sjans på nytt
			if (elevFornavn.isEmpty())
			{
				do
				{
					elevFornavn = JOptionPane.showInputDialog(null, 
							"M\u00E5 ha et fornavn, skriv inn p\u00E5 nytt:");
					// avslutt om det blir trykket cancel/kryss
					if (elevFornavn == null || elevFornavn == "")
					{
						System.exit(0);
					}
				}while (elevFornavn.isEmpty());// fortsett så lenge input er tom
			}
			// input fra brukeren
			String elevEtternavn = JOptionPane.showInputDialog(null,
					"Skriv inn etternavn p\u00E5 eleven:", 
					"Etternavn", 
					JOptionPane.QUESTION_MESSAGE);
			// sjekker om brukeren trykker cancel eller kryss avslutt program
			if (elevEtternavn == null || elevEtternavn == "")
			{
				System.exit(0);
			}
			// hvis brukeren lar input stå tomt får sjans på nytt
			if (elevEtternavn.isEmpty())
			{
				do
				{
					elevEtternavn = JOptionPane.showInputDialog(null,
							"M\u00E5 ha et etternavn, skriv inn p\u00E5 nytt:");
					// sjekker om bruker trykker cancel/kryss og avslutter
					if (elevEtternavn == null || elevEtternavn == "")
					{
						System.exit(0);
					}
				}while (elevFornavn.isEmpty());// fortsett så lenge input er tom
			}
			// input fra brukeren
			String elevKjonn = JOptionPane.showInputDialog(null, 
					"Skriv inn hvilket kj\u00F8nn, mann eller dame?", 
					"Kj\u00F8nn", 
					JOptionPane.QUESTION_MESSAGE);
			// sjekker om bruker trykker cancel/kryss og avslutter
			if (elevKjonn == null || elevKjonn == "")
			{
				System.exit(0);
			}
			// hvis brukeren lar input stå tom, gi en ny sjans
			if (elevKjonn.isEmpty())
			{
				do
				{
					elevKjonn = JOptionPane.showInputDialog(null, 
							"M\u00E5 ha et kj\u00F8nn, skriv inn p\u00E5 nytt:");
					// hvis bruker trykker cancel/kryss avslutt
					if (elevKjonn == null || elevKjonn == "")
					{
						System.exit(0);
					}
				}while (elevKjonn.isEmpty());// fortsett så lenge input er tom
			}
			// sjekker om brukeren har skrevet inn mann
			if (elevKjonn.toLowerCase().equals("mann"))
				mann = true;// setter da mann til true
			// sjekker om brukeren har skrevet inn noe annet enn mann
			else
				mann = false;// setter da mann til false
			// input fra brukeren
			String studieStart = JOptionPane.showInputDialog(null, 
					"Hvilket \u00E5r startet studenten?", 
					"Studiestart", 
					JOptionPane.QUESTION_MESSAGE);
			// hvis brukeren trykker cancel skriv ut beskjed og ny input
			if (studieStart == null || studieStart == "")
			{
				System.exit(0);
			}
			// hvis brukeren lar input stå tom start på nytt
			if (studieStart.isEmpty())
			{
				do
				{
					studieStart = JOptionPane.showInputDialog(null, 
							"M\u00E5 ha et studie\u00E5r, skriv inn p\u00E5 nytt:");
					if (studieStart == null || studieStart == "")
					{
						System.exit(0);
					}
				}while (studieStart.isEmpty());// fortsett så lenge input er tom
			}
			int studStart = Integer.parseInt(studieStart);// parse til integer
			// hvis input er mindre enn 2010 eller større enn 2014
			if (studStart < 2010 || studStart > 2014)
			{
				do
				{
					studieStart = JOptionPane.showInputDialog(null, 
							"Studenter som g\u00E5r p\u00E5 dette "
							+ "studiet har startet mellom 2010 og 2014, "
							+ "skriv inn \u00E5rstall p\u00E5 nytt.");
					// hvis bruker trykker cancel/kryss avslutt
					if (studieStart == null || studieStart == "")
					{
						System.exit(0);
					}
					studStart = Integer.parseInt(studieStart);
				}while (studStart < 2010 || studStart > 2014);/* fortsett 
				så lenge input er mindre enn 2010 eller større enn 2014*/
			}
			// input fra brukeren
			String fagomrade = JOptionPane.showInputDialog(
					"Velg nr. for faget til studenten:\n"
					+ "1. Norsk\n"
					+ "2. Engelsk\n"
					+ "3. Matematikk");	
			// hvis bruker trykker cancel/kryss avslutt
			if (fagomrade == null || fagomrade == "")
			{
				System.exit(0);
			}
			// hvis input står tom, gi en ny sjans
			if (fagomrade.isEmpty())
			{
				do
				{
					fagomrade = JOptionPane.showInputDialog(
							"M\u00E5 ha et fag, pr\u00F8v p\u00E5 nytt.\n"
							+ "1. Norsk\n"
							+ "2. Engelsk\n"
							+ "3. Matematikk");
					if (fagomrade == null || fagomrade =="")// hvis kryss/cancel avslutt
					{
						System.exit(0);
					}
				}while (fagomrade.isEmpty());// fortsett så lenge input er tom
			}
			int fag = Integer.parseInt(fagomrade);// parse til integer
			// hvis bruker har tatt et tall utenfor intervallet, start på nytt
			if (fag < 1 || fag > 3)
			{
				do
				{
				JOptionPane.showMessageDialog(null, 
						"Feil nr, pr\u00F8v igjen.");
				fagomrade = JOptionPane.showInputDialog(
						"Velg nr. for faget til studenten:\n"
						+ "1. Norsk\n"
						+ "2. Engelsk\n"
						+ "3. Matematikk");
				if (fagomrade == null || fagomrade == "")// hvis kryss/cancel, avslutt
				{
					System.exit(0);
				}
				fag = Integer.parseInt(fagomrade);
				}while (fag < 1 || fag > 3);/* fortsett så 
				lenge tallet er utenfor intervallet*/
			}
			// slutt på input fra brukeren
			// start å sende input fra brukeren til klassen Student for senere arbeid
			try
			{
				student.setFornavn(elevFornavn);// 
				student.setEtternavn(elevEtternavn);
				student.setKjonn(mann);
				student.setStudiestart(studieStart);
				if (fagomrade.equals("1"))
				{
					// her bestemmes det hvilket fag studenten har
					student.setFag("Norsk");
				}
				else if (fagomrade.equals("2"))
				{
					// her bestemmes det hvilket fag studenten har
					student.setFag("Engelsk");
				}
				else if (fagomrade.equals("3"))
				{
					// her bestemmes det hvilket fag studenten har
					student.setFag("Matematikk");
				}
				// sender studentene til klassen Gruppe for å gjøre til objekter
				gruppe.leggTilStudent(student);
				/* etter hver gang leggTilStudent har kjørt så 
				sendes de inn i filbehandlings-klassen og lagres i objekter der*/
				Filbehandling.lagreGruppe(gruppe);
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
						"Feil input, pr\u00F8v igjen", 
						JOptionPane.PLAIN_MESSAGE);// feilmelding
			}
			// brukeren får valg om å starte innlesing av flere elever på nytt
			svar = JOptionPane.showOptionDialog(null, 
					"Vil du lese inn flere elever?", 
					"Klasseliste", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);
			if (svar == JOptionPane.NO_OPTION)
			{
				visMeny();
			}
		}while (svar == JOptionPane.YES_OPTION);
		System.exit(0);
	}// slutt på metoden leggTilStudent

	public void lagDiverseGrupper()
	{
		//lokal variabel
		int igjen;
		// start en løkke for å finne ut hvilke grupper brukeren vil generere
		do
		{
			// hvis et valg-tre som sender brukeren videre på riktig gren
			String valgtre = JOptionPane.showInputDialog(null,
							"Skriv inn tallet p\u00E5 hva du vil gj\u00F8re:\n"
							+ "1: Sorter etter kj\u00F8nn.\n"
							+ "2: Sorter etter fag.\n"
							+ "3: Sorter etter studiestart.\n"
							+ "4: Sorter alfabetisk.\n"
							+ "5: Lag tilfeldig sammensetting.\n"
							+ "6: Lag liste over de som er godkjent til eksamen.\n"
							+ "0: Avslutt.");
			// kaller opp og konstruerer en konstruktør for klassen GenererGruppe
			GenererGruppe kjor = new GenererGruppe(gruppe);
			// sortere etter kjønn
			if (valgtre == null){ //Brukeren lukker dialogen.
				visMeny(); //GÂ tilbake til hovedmeny
			}
			
			if (valgtre.equals("1"))
			{
				// start metoden sortereKjonn i klassen GenererGruppe (Ida)
				kjor.sortereKjonn();
			}
			// sortere etter fag
			else if (valgtre.equals("2"))
			{
				// start metoden sortereFag i klassen GenererGruppe (Ida)
				kjor.sortereFag();
			}
			// sortere etter studiestartår
			else if (valgtre.equals("3"))
			{
				// start metoden sortereStudiestart i klassen GenererGruppe (Ida)
				kjor.sortereStudiestart();
			}
			// sorterer alfabetisk
			else if (valgtre.equals("4"))
			{
				/* start metoden sortereAlfabetisk i klassen GenererGruppe (Ida),
				sender inn studenter fra klassen Gruppe*/
				kjor.sortereAlfabetisk(gruppe.hentStudenterAsArray());
			}
			// sett sammen tilfeldig
			else if (valgtre.equals("5"))
			{	
				/* start metoden sortereTilfeldig i klassen GenererGruppe (Ida), 
				sender inn studenter fra klassen Gruppe*/
				kjor.sortereTilfeldig(gruppe.hentStudenterAsArray());
			}
			// sorterer etter de som kan gå til eksamen
			else if (valgtre.equals("6"))
			{
				// start metoden sortereGodkjent i klassen GenererGruppe (Ida)
				kjor.sortereGodkjent();
			}
			// avslutter
			else if (valgtre.equals("0"))
			{
				System.exit(0);
			}
			// hvis det er skrevet feil tall eller en bokstav så får bruker ny sjans
			else
			{
				igjen = JOptionPane.showOptionDialog(null, 
						"Du skrev inn et valg som ikke finnes, pr\u00F8ve p\u00E5 nytt?",
						"Lister",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						null, 
						null);
				// hvis brukeren velger ja, start gruppevalg igjen
				if (igjen == JOptionPane.YES_OPTION)
					lagDiverseGrupper();
				// hvis brukeren gjør noe annet start hele programmet på nytt
				else
				{
					visMeny();
				}
			}
			// brukeren får valg om å lage nye lister
			igjen = JOptionPane.showOptionDialog(null,
					"Vil du generere nye lister?", 
					"Lister",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					null, 
					null);
			// hvis brukeren trykker nei start hele programmet på nytt
			if (igjen == JOptionPane.NO_OPTION)
			{
				visMeny();
			}
		}while(igjen == JOptionPane.YES_OPTION);/* fortsett løkke med å 
		generere grupper så lenge igjen er ja*/
		System.exit(0);
	}// slutt på metoden lagDiverseGrupper
}// slutt på klassen Main
