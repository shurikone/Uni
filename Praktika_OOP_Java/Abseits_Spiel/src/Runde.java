
import de.oop2023.util.UserInterface;


/**
 * Diese Klasse simuliert das Spiel einer Runde mit einigen Methoden, die es ermoeglichen
 *
 * @author Daniil Shirokov
 * @see de.oop2023.util.UserInterface
 */
public class
Runde{

    private int nextDran;
    private int abseitszahl;
    private boolean rundeIstVorbei;
    private Spieler[] spielerArray;
    public Spieler geradeAusgeschiedener;

    /**
     * Simuliert das Spiel einer Runde mit gegebenen Spielern
     * @param spielerArray ein Feld mit Objekten vom Typ Spieler
     * @param i naechste Spieler, der ist dran
     */
    protected Runde(Spieler[] spielerArray, int i){

        rundeIstVorbei = false;
        this.spielerArray = spielerArray;
        abseitszahl = abseitszahlErstellen();
        do{     //Schleife fuer das Spiel bis einer von Spielern ausgeschieden ist
            while (i < spielerArray.length) {     //Schleife fuer den Durchlauf jedes Spielers in dem Feld von Objekten vom Typ Spieler
                System.out.println("Jetzt ist " + spielerArray[i].name1 + " dran");
                spielerArray[i].augensumme = spielerArray[i].augensumme + wuerfeln();
                System.out.println("Du (" + spielerArray[i].name1 + ") hast insgesamt "
                        + spielerArray[i].augensumme + " Punkte gesammelt!" + "\n");

                if (spielerArray[i].augensumme > abseitszahl) {         //Bedingung fürs Ausscheiden
                    spielerArray[i].istAusgeschieden = true;
                    System.out.println(spielerArray[i].name1 + " ist leider raus! \n");
                    rundeIstVorbei = true;
                    geradeAusgeschiedener = spielerArray[i];
                    spielerArray[i] = null;
                    if (i == spielerArray.length - 1)       //Rückgabe ausgeschiedenes Spielers
                        nextDran = 0;
                    else
                        nextDran = i;
                    i = spielerArray.length + 1;            //Schleifezwangsabbruch
                }
                i++;
            }
            i = 0;
        }while (!rundeIstVorbei);

        for (Spieler spieler : spielerArray){
            if (spieler != null)
                spieler.augensumme = 0;         //augensumme reset
        }

    }

    /**
     * Getter fuer einen gerade ausgeschiedenen Spieler
     * @return Objekt vom Typ Spieler
     */
    public Spieler getGeradeAusgeschiedener() {
        return geradeAusgeschiedener;
    }


    /**
     * Getter fuer naechste Spieler
     * @return Index des naechsten Spielers
     */
    public int getNextDran(){
        return this.nextDran;
    }

    /**
     * Getter fuer ein Feld mit Spieler Objekten
     * @return Feld mit Objekten vom Typ Spieler
     */
    public Spieler[] getSpielerArray(){
        return spielerArray;
    }

    /**
     * Erstellt die Abseitszahl
     * @return Abseitszahl von 30 bis 50
     */
    public int abseitszahlErstellen(){
        int abseitszahl = (int) (Math.random() * 21) + 30;
        System.out.println("die Abseitszahl für diese Runde ist " + abseitszahl);
        System.out.println("--------------------------------------");

        return abseitszahl;
    }

    /**
     * Simuliert das Wuerfeln von 2 Wuerfel
     * @return eine Zahl von 2 bis 12
     */
    public int wuerfeln() {
        UserInterface.in.requestUserPressReturn();

        int wuerfel1;
        int wuerfel2;

        wuerfel1 = (int) (Math.random() * 6) + 1;
        wuerfel2 = (int) (Math.random() * 6) + 1;


        int wuerfelGesamt = wuerfel1 + wuerfel2;
        System.out.println("Ihr Wurf gibt Sie " + wuerfelGesamt + " Punkten");
        return wuerfelGesamt;
    }
}
