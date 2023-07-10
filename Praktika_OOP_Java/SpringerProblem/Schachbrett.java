import javax.security.auth.login.AccountNotFoundException;

/**
 * Die Klasse Schachbrett repraesentiert ein Schachbrett mit einer bestimmten Groeße und Startposition.
 */
public class Schachbrett {
    private int groesse;
    private int[][]Spielbrett;
    private String startPosition;
    private int anzahlAusgabe;
    public int variante;
    private int[] posX = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int[] posY = { 1, 2, 2, 1, -1, -2, -2, -1 };
    /**
     * Konstruktor für die Klasse Schachbrett.
     *
     * @param groesse         die Groeße des Schachbretts
     * @param startPosition   die Startposition auf dem Schachbrett
     * @param variante        die Variante des Spiels
     * @param anzahlAusgabe   die Anzahl der Ausgaben
     */
    public Schachbrett(int groesse, String startPosition,int variante, int anzahlAusgabe){
        this.variante = variante;
        this.anzahlAusgabe = anzahlAusgabe;
        this.startPosition = startPosition;
        this.groesse = groesse;
        this.Spielbrett = new int[groesse][groesse];
    }

    /**
     * Fuehrt die klassische Variante des Springerproblems aus und gibt die Loesung dazu aus.
     */
    public void doKV(){
        Klassisch klassisch = new Klassisch(anzahlAusgabe,Spielbrett, posX, posY);
        int [] koordinaten = klassisch.SchachZuKooardinaten(startPosition);
        int x = koordinaten[0];
        int y = koordinaten[1];
        klassisch.offeneV(Spielbrett, groesse, x-1, y-1,1);
        System.out.println("Anzahl Loesungen: " + klassisch.anzahlLoesung);
        //falls wir nur die Anzahl der Loesungen ausgeben muessen kann die if Klausel weg
        if(klassisch.istMoeglich == false){
            System.out.println("Keine Loesung moeglich.");
        }
    }

    public void doEV(){
        Einfach einfach = new Einfach(anzahlAusgabe, Spielbrett, posX, posY);
        int [] koordinaten = einfach.SchachZuKooardinaten(startPosition);
        int x = koordinaten[0];
        int y = koordinaten[1];
        einfach.einfachBerechnen(Spielbrett, groesse, x-1, y-1,1);
        System.out.println("Anzahl Loesungen: " + einfach.anzahlLoesung);
        if(einfach.istMoeglich == false){
            System.out.println("Keine Loesung moeglich.");
        }
    }



}
