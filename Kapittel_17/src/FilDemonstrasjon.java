import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FilDemonstrasjon extends JFrame
{
	private JTextArea utskrift;
	private JScrollPane scrollPane;
	
	public FilDemonstrasjon()
	{
		super ("Tester class File");
		utskrift = new JTextArea();
		scrollPane = new JScrollPane(utskrift);
		
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		analyzePath();
	}
	
	private File getFilEllerPlassering ()
	{
		JFileChooser filVelger = new JFileChooser();
		filVelger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int resultat = filVelger.showOpenDialog(this);
		
		if (resultat == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		File filNavn = filVelger.getSelectedFile();
		
		if ((filNavn == null) || (filNavn.getName().equals("")))
		{
			JOptionPane.showMessageDialog (this, "Invalid name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return filNavn;
	}
	
	public void analyzePath()
	{
		File navn = getFilEllerPlassering();
		
		if (navn.exists())
		{
			utskrift.setText(String.format("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", 
					navn.getName(), " eksisterer", 
					(navn.isFile() ? "er en fil":"er ikke en fil"),
					(navn.isDirectory()? "er en Plassering":"er ikke en plassering"),
					(navn.isAbsolute()? "er den endelige plasseringen":"er ikke den endelige plasseringen"),
					"Sist redigert: ", navn.lastModified(),
					"Lengde: ", navn.length(),
					"Plassering: ", navn.getPath(),
					"Absolutt plassering: ", navn.getAbsolutePath(),
					"Foreldre: ", navn.getParent()));
			if (navn.isDirectory())
			{
				String[] directory = navn.list();
				utskrift.append("\n\n Inneholder: \n");
				for (String directoryName:directory)
					utskrift.append(directoryName + "\n");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, navn + " eksisterer ikke", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}