//Personregister.java
public class Personregister
{
  private Person[] register;
  private final int KAPASITET = 10;
  private int antall;

  public Personregister()
  {
    register = new Person[ KAPASITET ];
    antall = 0;
  }

  //Setter inn ny person i registeret i tilfelle det er plass.
  public boolean nyPerson( Person p )
  {
    if ( antall < KAPASITET && p != null )
    {
      register[ antall ] = p;
      antall++;
      return true;
    }
    else
      return false;
  }

  //Returnerer data om person med gitt nummer.
  public String visPerson( int nr )
  {
    for ( int i = 0; i < antall; i++ )
      if ( register[ i ].getNummer() == nr )
        return register[ i ].toString();
    return null;  //personen var ikke der
  }

  //Returnerer navneliste over alle registrerte personer.
  public String visAlleNavn()
  {
    String navneliste = "";
    for ( int i = 0; i < antall; i++ )
      navneliste += register[ i ].getNavn() + "\n";
    return navneliste;
  }
}