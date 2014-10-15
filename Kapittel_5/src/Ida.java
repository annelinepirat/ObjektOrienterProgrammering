import javax.swing.JOptionPane;
public class Ida
{
	public static void main (String [] args)
	{
		String førsteSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String andreSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String tredjeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String fjerdeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String femteSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String sjetteSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String syvendeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String åttendeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String niendeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String tiendeSifferstreng = JOptionPane.showInputDialog( "Skriv inn et heltall:" );
		String utskrift = "";
		
		int førstetall = Integer.parseInt( førsteSifferstreng );
		int andretall = Integer.parseInt( andreSifferstreng );
		int tredjetall = Integer.parseInt( tredjeSifferstreng );
		int fjerdetall = Integer.parseInt( fjerdeSifferstreng );
		int femtetall = Integer.parseInt( femteSifferstreng );
		int sjettetall = Integer.parseInt( sjetteSifferstreng );
		int syvendetall = Integer.parseInt( syvendeSifferstreng );
		int åttendetall = Integer.parseInt( åttendeSifferstreng );
		int niendetall = Integer.parseInt( niendeSifferstreng );
		int tiendetall = Integer.parseInt( tiendeSifferstreng );
		int max;
		
		max = ( førstetall <= andretall ) ? andretall : førstetall;
		max = ( andretall <= tredjetall ) ? tredjetall : andretall;
		max = ( tredjetall <= fjerdetall ) ? fjerdetall : tredjetall;
		max = ( fjerdetall <= femtetall ) ? femtetall : fjerdetall;
		max = ( femtetall <= sjettetall ) ? sjettetall : femtetall;
		max = ( sjettetall <= syvendetall ) ? syvendetall : sjettetall;
		max = ( syvendetall <= åttendetall ) ? åttendetall : syvendetall;
		max = ( åttendetall <= niendetall ) ? niendetall : åttendetall;
		max = ( niendetall <= tiendetall ) ? tiendetall : niendetall;
		
		utskrift = max + " er det største tallet. ";
		
		JOptionPane.showMessageDialog(null, utskrift);
	}
}