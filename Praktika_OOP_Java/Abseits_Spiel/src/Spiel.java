import de.oop2023.util.UserInterface;

/**
 * Diese Klasse simuliert das Abseitsspiel mithilfe von Klassen Runde und Spieler
 *
 *
 * @author Daniil Shirokov
 * @see de.oop2023.util.UserInterface
 */
public class Spiel
{
    private static int spielerAnzahl;


    /**
     * Simuliert das Abseitsspiel mithilfe von Hilfsklassen "Runde" und "Spieler".
     *
     */
    public Spiel(){
        boolean spielIstVorbei = false;
        Spieler[] auswertArr;
        spielerAnzahl = spielerAnzahl();
        Spieler[] alleSpieler = spielerErstellen(spielerAnzahl);
        int rundeNummer = 0;
        int nextDran = 0;
        auswertArr = new Spieler[spielerAnzahl];
        do{     //Schleife fuer wiederholenden Runden
            rundeNummer += 1;
            System.out.println("--------------------------------------");
            System.out.println("        Es fängt die " + rundeNummer + ". Runde!");
            System.out.println("--------------------------------------");
            System.out.println("  Zum Generieren einer Abseitszahl");
            System.out.print("   ");
            UserInterface.in.requestUserPressReturn();
            Runde runde = new Runde(alleSpieler, nextDran); /*Erstellt eine neue Runde mit dem Behalten
             der Reihenfolge des Spielers (Damit nicht jedes Mal derselbe Spieler die neue Runde beginnt)*/
            alleSpieler = runde.getSpielerArray();
            alleSpieler = arraySauberMachen(alleSpieler);
            nextDran = runde.getNextDran();
            if(alleSpieler.length == 1){
                System.out.println("\nHooray, and the winner is ..... " + alleSpieler[0].name1);
                spielIstVorbei = true;
                auswertArr[auswertArr.length - 1] = alleSpieler[0];
            }
            auswertArr[rundeNummer-1] = runde.getGeradeAusgeschiedener();
        }while(!spielIstVorbei);
        auswerten(auswertArr);
    }

    /**
     * Entfernt die Null-Objekten aus dem gegebenen Feld mit dem Behalten der Reihenfolge
     * @param arr mit Null´en als Objekten
     * @return Feld ohne Null´en als Objekten
     */
    private Spieler[] arraySauberMachen(Spieler[] arr){
        int PosDesNulls = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == null)
                PosDesNulls = i;
        }
        while(PosDesNulls < arr.length - 1){
            arr[PosDesNulls] = arr[PosDesNulls + 1];
            PosDesNulls += 1;
        }

        Spieler[] neuArr = new Spieler[arr.length-1];
        for (int j = 0; j < neuArr.length; j++){
            neuArr[j] = arr[j];
        }

        return neuArr;
    }

    /**
     * Gibt die Auswertung von Spielerplaetzen in der Konsole aus, basierend auf dem Parameter.
     * @param sortArr ein Feld mit Objekten vom Typ Spieler.
     */
    public void auswerten(Spieler[] sortArr){
        System.out.println("\nDie Ergebnisse: ");
        int j = 0;
        for (int i = sortArr.length-1; i >= 0; i--){
            System.out.print(j + 1);
            System.out.println(". Platz - " + sortArr[i].name1);
            j += 1;
        }
    }

    /**
     * Fordert den User auf Eingabe einer ganzen Zahl, damit um die Anzahl der Spieler zu bestimmen.
     * @return Spieleranzahl (ganze Zahl)
     */
    private int spielerAnzahl(){
        return UserInterface.in.requestInt("Geben Sie ein, wie viele Spieler mitspielen möchten: ", 1);
    }

    /**
     * Die Methode gibt die Spielregeln in der Konsole aus.
     */
    public static void spielregelnAusgeben(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("SPIELREGELN:\n Mehrere Spieler wuerfeln hintereinander.\n Ziel des Spiels ist es, " +
                "als Augensumme eine festgelegte Augensumme (abseits) nicht zu ueberschreiten");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    /**
     * Die Methode erstellt ein Feld mit Objekten vom Typ Spieler, indem den Namen fuer jeden Spieler durch Hilfsmethode
     * UserInterface abgefragt ist.
     *
     * @param spielerAnzahl vom Typ ganze Zahl
     * @return ein Feld mit Objekten vom Typ Spieler
     */
    private Spieler[] spielerErstellen(int spielerAnzahl){

        Spieler[] alleSpieler = new Spieler[spielerAnzahl];
        for (int j = 0; j < spielerAnzahl; j++){
            String spielerName = UserInterface.in.requestString("Bitte Spielernamen eingeben: ");
            alleSpieler[j] = new Spieler(spielerName, false);
        }
        return alleSpieler;
    }
}
