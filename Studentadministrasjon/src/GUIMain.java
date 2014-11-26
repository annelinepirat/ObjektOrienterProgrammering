import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;


/*
 * GUIMain.class
 * 
 * Hovedvinduet for Â utf¯re endringer pÂ studenter.
 * 
 * LAGET AV ÿYSTEIN MÿRKESDAL
 * 
 * 
 * 
 */

public class GUIMain extends Dialog implements MouseListener, WindowListener{

	
	//Main
	//Vis valg (legg til studenter ELLER lag lister)
	//Hvis legg til studenter
	//--Sp¯r om informasjon, lag nytt studentobjekt
	//Hvis lag lister
	//--Sp¯r hva slags liste, sÂ skriv ut.
	
	private Gruppe gruppe = null;
	
	private JList listStudenter = null;
	private DefaultListModel listModel = new DefaultListModel();
	private JScrollPane scrollStudenter = null;
	
	private JButton btnRedigerElev = new JButton("Rediger elev og oppgaver");
	private Main m = null;
	
	public GUIMain(Gruppe grp, Main m){
		gruppe = grp;
		this.m = m;
		setup();
		
		this.setVisible(true);
	}
	
	protected void setup(){ //Ordner vinduet klart til f¯rstegangsvisning
		super.setup(); //Kj¯rer setup-metoden fra Dialog-klassen (som denne klassen arver fra)
		this.setTitle("Studentadministrasjon");
		this.setSize(320, 240);

		//Legger til en vinduslytter (Dette for Â vite nÂr vinduet lukkes, slik at visMeny() fra Main kan kalles opp igjen.
	    this.addWindowListener(this);
	    
		//Gj¯r klar listen med studenter
		updateListe();
		listStudenter = new JList(listModel);		
		scrollStudenter = new JScrollPane(listStudenter); //Aktiverer en scrollbar dersom det trengs til lista.
		
		//Legg komponenter og paneler til i dialogvinduet
		this.add(scrollStudenter, BorderLayout.CENTER);
		this.add(btnRedigerElev, BorderLayout.SOUTH);
		
		//Legg til lytterer etter knappetrykk og museklikk
		btnRedigerElev.addActionListener(this);
		listStudenter.addMouseListener(this);
		
		//Sentrer dialogen pÂ PC-skjermen
		centerScreen();
	}
	
	private Student getValgteStudent(){ //Returnerer studentobjektet som tilh¯rer studenten som er valg i lista.
		return gruppe.hentStudenterAsVector().elementAt( listStudenter.getSelectedIndex());
	}
	
	private void updateListe(){//Oppdaterer innholdet i listboksen
		Student[] stud = gruppe.hentStudenterAsArray();
		
		listModel.clear(); //t¯m lista
		
		//Legg til alle studenter i lista
		for (int i = 0; i < stud.length; i++) {
			listModel.addElement(stud[i]);
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae) { //Tar hÂnd om hva som skjer nÂr noe blir klikket pÂ
		
		if (ae.getSource() == btnRedigerElev){ //Hvis knappen "btnRedigerElev" klikkes
			new GUIStudent(gruppe, getValgteStudent()); //Vis et vindu for redigering av studenten som er valgt
			Filbehandling.lagreGruppe(gruppe);//Lagre
			updateListe(); //oppdater lista (i tilfelle navnendringer etc.).
		}
	}

	
	
	public void mouseClicked(MouseEvent me) { //Hvis brukeren dobbeltklikker
		  if (me.getClickCount() == 2) {
				new GUIStudent(gruppe, getValgteStudent()); //Vis et vindu for redigering av studenten som har blitt klikket.
				Filbehandling.lagreGruppe(gruppe); //Lagre
				updateListe(); //oppdater lista (i tilfelle navnendringer etc.).
			 }		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		m.visMeny();
	}

	//Under her er alle (ubrukte) metodene som kreves av ActionListener og WindowsListener
	
	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
