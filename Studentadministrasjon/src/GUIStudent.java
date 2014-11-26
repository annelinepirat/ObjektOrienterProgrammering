import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;


/*
 * GUIStudent.class
 * 
 * Hovedvindu for Â redigere informasjon om et studentobjekt.
 * 
 * LAGET AV ÿYSTEIN MÿRKESDAL
 * 
 */


public class GUIStudent extends Dialog{

	
	private Student stud = null;
	private Gruppe gruppe = null;
	private Vector<Oppgave> oppgaver = new Vector();

	
	private JPanel panelSouth = new JPanel(new GridLayout(0,3));
	private JPanel panelRadioKjonn = new JPanel(new FlowLayout());
	private JPanel panelCenter = new JPanel(new GridLayout(0,2));
	
	private JButton btnSlett = new JButton("Slett");
	private JButton btnLagre = new JButton("Lagre");
	private JButton btnAvbryt = new JButton("Avbryt");
	private JButton btnOppgaver = new JButton("Oppgaver");

	private JRadioButton radioMann = new JRadioButton("Mann");
	private JRadioButton radioDame = new JRadioButton("Dame");
	private ButtonGroup groupKjonn = new ButtonGroup();
	
	private JLabel lblFornavn = new JLabel("Fornavn");
	private JLabel lblEtternavn = new JLabel("Etternavn");
	private JLabel lblFag = new JLabel("Fag");
	private JLabel lblOppgaver = new JLabel("Oppgaver");
	private JLabel lblKjonn = new JLabel("Kj¯nn");
	private JLabel lblStudieStart = new JLabel("Studiestart");
	
	private JTextField txtFornavn = new JTextField(); 
	private JTextField txtEtternavn = new JTextField(); 
	private JTextField txtFag = new JTextField();
	private JFormattedTextField txtStudieStart = null;	
	
	
	public GUIStudent(Gruppe gruppe){//Konstrukt¯r brukt for Â opprette en ny student.
	
		this.gruppe = gruppe;
		
		setup();
		btnSlett.setVisible(false); //Hjemmer knappen ettetsom den kun skal vises ved endring av student
		btnOppgaver.setVisible(false); //Hjemmer knappen ettetsom den kun skal vises ved endring av student
		lblOppgaver.setVisible(false); //Hjemmer knappen ettetsom den kun skal vises ved endring av student
		
		this.setVisible(true);
	}
	
	public GUIStudent(Gruppe gruppe, Student stud){ //Konstrukt¯r brukt for Â endre en eksisterende student.
		this.gruppe = gruppe;
		this.stud = stud;
		setup();
		oppdaterFelt();
		
		this.setVisible(true);
	}


	protected void setup(){ //Ordner vinduet klart til f¯rstegangsvisning
		super.setup(); //Kj¯rer setup-metoden fra Dialog-klassen (som denne klassen arver fra)
		this.setTitle("Studentadministrasjon - Student");
		this.setSize(300,220);
		this.setModal(true); //For Â lÂse hovedvinduet mens man har dette studentvinduet Âpent.
		
		//Konfigurere tekstfelt for integer (Ârstall)
		NumberFormat intFormat = NumberFormat.getNumberInstance();
		intFormat.setGroupingUsed(false); //slÂ av gruppering av tall (noe som f¯rer til mellomrom i tallrekken, og feil i integer konvertering fra string.
		NumberFormatter numberFormatter = new NumberFormatter(intFormat);
		txtStudieStart = new JFormattedTextField(numberFormatter);
		numberFormatter.setValueClass(Integer.class); 
		numberFormatter.setAllowsInvalid(false); //tillat kun nummer
		txtStudieStart.setToolTipText("≈rstall for studiestart. F.eks. \"2014\"");
		
		
		//Gruppere radioknapper
		groupKjonn.add(radioMann);
		groupKjonn.add(radioDame);
		radioDame.setSelected(true);
		panelRadioKjonn.add(radioDame);
		panelRadioKjonn.add(radioMann);

		//Legg alle komponenter og knapper til paneler
		panelCenter.add(lblFornavn);
		panelCenter.add(txtFornavn);
		panelCenter.add(lblEtternavn);
		panelCenter.add(txtEtternavn);
		panelCenter.add(lblFag);
		panelCenter.add(txtFag);
		panelCenter.add(lblOppgaver);
		panelCenter.add(btnOppgaver);
		panelCenter.add(lblKjonn);
		panelCenter.add(panelRadioKjonn);
		panelCenter.add(lblStudieStart);
		panelCenter.add(txtStudieStart);
		
		panelSouth.add(btnAvbryt);
		panelSouth.add(btnSlett);
		panelSouth.add(btnLagre);
		
		
		//Legg komponenter og paneler til i dialogvinduet
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
		
		//Legg til lytterer etter knappetrykk
		btnAvbryt.addActionListener(this);
		btnLagre.addActionListener(this);
		btnSlett.addActionListener(this);
		btnOppgaver.addActionListener(this);
		
		//Sentrer dialogen pÂ PC-skjermen
		centerScreen();
		
	}	
	
	public void actionPerformed(ActionEvent ae) { //Tar hÂnd om knappetrykk
		
		if (ae.getSource() == btnAvbryt){
			this.setVisible(false);
		}else if (ae.getSource() == btnLagre){
			klikkLagre();
		}else if (ae.getSource() == btnOppgaver){
			System.out.println(stud.getOppgaverAsVector().size());
			new GUIOppgaver(stud);
			System.out.println(stud.getOppgaverAsVector().size());
		}
	}
	

	private void oppdaterFelt(){ //Oppdaterer alle felt ved endring
		txtFornavn.setText( stud.getFornavn());
		txtEtternavn.setText( stud.getEtternavn());
		txtStudieStart.setText( Integer.toString(stud.getStudiestart()));
		if (stud.isDame()) radioDame.setSelected(true); else radioMann.setSelected(true);
		txtFag.setText(stud.getFag());
	}
	
	
	private boolean sjekkFelt(){//Kontrollerer at alle felt er utfylt
		
		if (txtFornavn.getText().isEmpty()) return false;
		if (txtFornavn.getText().equals("")) return false;
		if (txtEtternavn.getText().isEmpty()) return false;
		if (txtEtternavn.getText().equals("")) return false;
		if (txtFag.getText().isEmpty()) return false;
		if (txtFag.getText().equals("")) return false;
		if (txtStudieStart.getText().isEmpty()) return false;
		if (txtStudieStart.getText().equals("")) return false;
		
		
		return true;
		
	}
	
	private void klikkLagre(){ //Endrer/oppretter og lagrer studentobjektet.
		
		
		if (sjekkFelt()){
			if (stud == null){//Ny student
				stud = new Student(txtFornavn.getText(), txtEtternavn.getText(), Integer.parseInt(txtStudieStart.getText()), radioMann.isSelected(), txtFag.getText(), oppgaver);
				gruppe.leggTilStudent(stud);
			}else{ // Endre student
				stud.setFornavn(txtFornavn.getText());
				stud.setEtternavn(txtEtternavn.getText());
				stud.setStudiestart(txtStudieStart.getText());
				stud.setKjonn(radioMann.isSelected());
				stud.setFag(txtFag.getText());
			}
		
			Filbehandling.lagreGruppe(gruppe); //Lagrer endringer til disk.
			this.setVisible(false);
		}
	}
	

}
