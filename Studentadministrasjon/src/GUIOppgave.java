/**********************************************************
 * @author Øystein
 * 
 * GUIOppgave.class
 * Vindu for Â vise informasjon om ett enkelt oppgaveobjekt.
 *********************************************************/
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class GUIOppgave extends Dialog{

	
	private JPanel panelNorth = new JPanel(new GridLayout(0,1));
	private JPanel panelNorthNavn = new JPanel( new GridLayout(0,1));
	private JPanel panelNorthDato = new JPanel( new GridLayout(0,1));
	private JPanel panelNorthRadio = new JPanel( new FlowLayout());
	private JPanel panelSouth = new JPanel( new FlowLayout());
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnAvbryt = new JButton("Avbryt");
	
	private JRadioButton radioBestatt = new JRadioButton("Best/u00E5tt");
	private JRadioButton radioIkkeBestatt = new JRadioButton("Ikke best/u00E5tt");
	private ButtonGroup groupBestatt = new ButtonGroup();
	
	private JTextArea txtTilbakemelding = new JTextArea();
	private JScrollPane scroll = new JScrollPane(txtTilbakemelding); 

	private JFormattedTextField txtLevertDato = null;	
	private JLabel lblLevertDato = new JLabel("Levert dato:");
	
	private JLabel lblOppgaveNavn = new JLabel("Oppgavenavn:");
	private JTextField txtOppgaveNavn = new JTextField();
	
	private Oppgave oppg = null;
	private Student stud = null;

	//Konstruktur med studentobjekt (for Â opprette ny oppgave)
	public GUIOppgave(Student stud){
		this.stud = stud;
		setup();
		this.setVisible(true);
	}
	
	//Konstruktør med oppgaveobjekt (for redigering)
	public GUIOppgave(Oppgave oppg){ 
		this.oppg = oppg;
		setup();
		oppdaterFelt();
		this.setVisible(true);
	}
	
	/*Oppdaterer felt med informasjon fra oppg-objekt 
	(brukt ved endring av eksisterende objekt).*/
	private void oppdaterFelt(){ 
		txtLevertDato.setText( oppg.getLevertDato());
		txtOppgaveNavn.setText( oppg.getOppgaveNavn());
		txtTilbakemelding.setText( oppg.getTilbakeMelding());
		if (oppg.isGodkjent()) radioBestatt.setSelected(true); 
		else radioIkkeBestatt.setSelected(true);
	}

	private boolean sjekkFelt(){ //Kontrollerer at alle felt er utfyllt
		if (txtLevertDato.getText().isEmpty()) return false;
		if (txtLevertDato.getText().equals("")) return false;
		if (txtOppgaveNavn.getText().isEmpty()) return false;
		if (txtOppgaveNavn.getText().equals("")) return false;
		
		return true;
		
	}
	
	protected void setup(){
		super.setup(); //Kjører setup fra moderklassen
		this.setTitle("Oppgaver");
		this.setSize(190, 280);
		this.setModal(true); //Kun dette vinduet aktivt
		
		//Konfigurere tekstfelt for integer (Ârstall)
		txtLevertDato = new JFormattedTextField( datoFormatter("##.##.####"));
		
		//Ordne radioknapper
		groupBestatt.add(radioBestatt);
		groupBestatt.add(radioIkkeBestatt);
		radioIkkeBestatt.setSelected(true);
		
		//Legge til komponenter i panelene
		panelNorthNavn.add(lblOppgaveNavn);
		panelNorthNavn.add(txtOppgaveNavn);
		panelNorthDato.add(lblLevertDato);
		panelNorthDato.add(txtLevertDato);
		panelNorthRadio.add(radioBestatt);
		panelNorthRadio.add(radioIkkeBestatt);
		panelNorth.add(panelNorthNavn);
		panelNorth.add(panelNorthDato);
		panelNorth.add(panelNorthRadio);
		panelSouth.add(btnAvbryt);
		panelSouth.add(btnOk);
		
		//Legge til klikklytter
		btnAvbryt.addActionListener(this);
		btnOk.addActionListener(this);
		
		
		//Legge komponentene ut i vinduet/dialogen
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
		
		
		centerScreen();
	}

	
	public void actionPerformed(ActionEvent ae) { //Sjekker etter knappetrykk
		
		if (ae.getSource() == btnOk){
			clickOk();
		}else if (ae.getSource() == btnAvbryt){
			this.setVisible(false);
		}
	}	
	
	private void clickOk(){ /*Hva som skjer nÂr knappen "OK" 
		klikker - Setter variablene i oppgaveobjektet.*/
			
		if (sjekkFelt()){
			if (oppg != null){ //AltsÂ redigerer en eksisterende oppgave
				oppdaterOppgaveObjekt();
			}else{ //AltsÂ oppretter en ny oppgave
				oppg = new Oppgave();
				oppdaterOppgaveObjekt();
				stud.addOppgave(oppg);
			}
			this.setVisible(false);
		}
			
	}
	
	private void oppdaterOppgaveObjekt(){ /*Oppdaterer oppgaveobjektet ut i 
		fra hva brukeren har skrevet i vinduet.*/
		oppg.setOppgaveNavn( txtOppgaveNavn.getText());
		oppg.setLevertDato(txtLevertDato.getText());
		oppg.settTilbakeMelding(txtTilbakemelding.getText());
		if (radioBestatt.isSelected()) oppg.setGodkjent(true); else oppg.setGodkjent(false);
	}

	//Sørger for at det kun blir tastet inn datoer i formatet XX.XX.XXXX
	protected MaskFormatter datoFormatter(String datoString) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(datoString);
	      //Hvis feil, si i fra om dette og sett dato til 01/01/2001.
	    } catch (java.text.ParseException pe) { 
	        System.err.println("Feil med datotekstfeltet for innlevering" + pe);
	        txtLevertDato.setText("01.01.2001");
	    }
	    return formatter;
	}
}