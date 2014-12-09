/************************************************************
 * @author Øystein
 * 
 * GUIOppgaver.class
 * 
 * Hovedvindu for å vise alle oppgaver en student har levert.
 **********************************************************/
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUIOppgaver extends Dialog implements MouseListener{
	
	private JPanel panelEast = new JPanel(new GridLayout(0,1));
	
	private JList listOppgaver = null;
	private JScrollPane scrollOppgaver = null;
	private DefaultListModel listModel = new DefaultListModel();
	
	private JButton btnLeggTilOppgave = new JButton("Legg til...");
	private JButton btnRedigerOppgave = new JButton("Rediger...");
	private JButton btnSlettOppgave = new JButton("Slett");
	private JButton btnLukk = new JButton("Lukk");

	private Student stud = null;
	
	public GUIOppgaver(Student stud){
		this.stud = stud;
		setup();
		
		this.setVisible(true);
	}

	//Ordner vinduet klart til førstegangsvisning
	protected void setup(){
		//Kjører setup-metoden fra Dialog-klassen (som denne klassen arver fra)
		super.setup(); 
		this.setTitle(stud.getFornavn() + " - Oppgaveadministrasjon");
		this.setSize(320,240);
		this.setModal(true);

		
		//Gjør klar listen med oppgaver
		updateListe();		
		listOppgaver = new JList(listModel);		
		scrollOppgaver = new JScrollPane(listOppgaver);
		
		/*listOppgaver = new JList(stud.getOppgaver());
		 * //Lar deg kun velge en og en ting i lista.
		listOppgaver.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		scrollOppgaver = new JScrollPane(listOppgaver); //Skrur på scrollbar*/
		
		//Legg alle komponenter og knapper til paneler
		panelEast.add(btnLeggTilOppgave);
		panelEast.add(btnRedigerOppgave);
		panelEast.add(btnSlettOppgave);
		panelEast.add(btnLukk);
		
		//Legg komponenter og paneler til i dialogvinduet
		this.add(scrollOppgaver, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.EAST);
		
		//Legg til lytterer etter knappetrykk
		btnLeggTilOppgave.addActionListener(this);
		btnRedigerOppgave.addActionListener(this);
		btnSlettOppgave.addActionListener(this);
		btnLukk.addActionListener(this);
		listOppgaver.addMouseListener(this);
		
		//Sentrer dialogen på PC-skjermen
		centerScreen();
		
	}
	
	//Tar hånd om hva som skjer når noe blir klikket på
	public void actionPerformed(ActionEvent ae) { 
		
		if (ae.getSource() == btnLeggTilOppgave){
			new GUIOppgave(stud);
			updateListe();		
		}else if (ae.getSource() == btnRedigerOppgave){
			//åpner et oppgavevindu, sender med valgte oppgave.
			new GUIOppgave( getValgteOppgave()); 
			updateListe();		
		}else if (ae.getSource() == btnSlettOppgave){
			//Sletter valge oppgaven
			stud.getOppgaverAsVector().removeElementAt(listOppgaver.getSelectedIndex()); 
			updateListe();		
		}else if (ae.getSource() == btnLukk){
			this.setVisible(false);
		}
	}

	//Returnerer oppgaveobjektet som tilsvarer oppgaven som er valgt i lista.
	private Oppgave getValgteOppgave(){ 
		return stud.getOppgaverAsVector().elementAt( listOppgaver.getSelectedIndex());
	}

	
	private void updateListe(){//Oppdaterer innholdet i listboksen
		Oppgave[] oppgtemp = stud.getOppgaver();
		listModel.clear();
		
		for (int i = 0; i < oppgtemp.length; i++) {
			listModel.addElement(oppgtemp[i]);
		}
		
	}
	
	
	public void mouseClicked(MouseEvent me) { //Tar hånd om museklikk
		  if (me.getClickCount() == 2) {
			//åpner et oppgavevindu, sender med valgte oppgave.
				new GUIOppgave( getValgteOppgave()); 
				updateListe();		
			 }		
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}		
}