import java.util.Stack;

/**
 * Diese Klasse beinhaltet die ganze Logik von Zahlspiegeln, Addieren und Pruefen, ob das Addieren von Spiegelzahlen
 * eine Palindromzahl ergibt.
 * @author Daniil Shirokov
 * @version 1.2
 * @see java.util.Stack
 *
 */
public class Spiegelzahlen {

    /**
     * Diese Methode beinhaltet die Hauptlogik, indem die Hilfsmethode dadurch benutzt werden.
     * @param eingabeZahl zu eingebende Zahl
     * @param aMI Anzahl maximaler Versuche
     */
    public Spiegelzahlen(String eingabeZahl, int aMI){
        if (eingabeZahl.matches("^[0-9]*")){ //Bedingung fuer eine korrekte Eingabe. Erlaubte Zeichen: "123456789"
            String spiegelZahl = zahlSpiegeln(eingabeZahl);
            String summe;
            int i = 1;
            System.out.println("Sie haben " + eingabeZahl + " als Zahl eingegeben");
            System.out.println("Die Spiegel Zahl dazu ist " + zahlSpiegeln(eingabeZahl) + "\n");
            do{ //Schleife fuer das Addieren von Zahl und ihrer Spiegelzahl, bis aMI erreicht oder
                // eine Palindromzahl enstanden ist
                summe = addieren(eingabeZahl, spiegelZahl);
                System.out.println("Die " + i + ".te Summe = " + summe);
                i++;
                if(!paliChecken(summe))
                    System.out.println("Die Spiegelzahl von dieser Summe ist " + zahlSpiegeln(summe));
                eingabeZahl = summe; spiegelZahl = zahlSpiegeln(summe);
            }while(!(paliChecken(summe)) && (i<aMI+1));
            if(paliChecken(summe))
                System.out.println("und das ist eine Palindromzahl!");
            else
                System.out.println("Leider wurde die maximale Anzahl von " +
                        "Iterationen (" + (i-1) + ") erreicht und keine Palindromzahl erzeugt");}
        else
            System.out.println("keine valide Eingabe");

    }

    /**
     * Die Methode bekommt eine Zahl als Zeichenkette als ihre Parameter
     * und gibt gespiegelte Version von dieser Zahl zurueck.
     * @param zuSpiegelndeZahl
     * @return gespiegelte Zahl als Zeichenkette
     */
    private String zahlSpiegeln(String zuSpiegelndeZahl){
        StringBuilder sb = new StringBuilder(zuSpiegelndeZahl);
        sb.reverse();
        String gespiegelteZahl = sb.toString();
        return gespiegelteZahl;
    }

    /**
     * Diese Methode bekommt eine Zahl als Zeichenkette als ihre Parameter
     * und erstellt ein Stack daraus
     * @param zahl eine Zahl als Zeichenkette
     * @return ein Stack mit allen Ziffern dieser Zahl als Elemente
     */
    private Stack<Integer> ausZahlStackErstellen(String zahl){
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < zahl.length(); i++) {
            stk.push(Integer.parseInt(zahl.substring(i, i+1)));
        }
        return stk;
    }


    /**
     * Diese Methode bekommt ein Stack mit Ziffern als Elemente und erstellt eine Zahl aus Elementen dieses Stacks
     * @param stkZahl ein Stack mit Ziffern einer Zahl als Elemente
     * @return eine Zahl als Zeichenkette
     */
    private String ausStackZahlErstellen(Stack<Integer> stkZahl){

        StringBuilder sb = new StringBuilder("");
        while(!stkZahl.empty()) {
            sb.append(stkZahl.peek());
            stkZahl.pop();
        }
        String str = sb.toString();
        return str;
    }


    /**
     * Die Methode bekommt zwei Zahlen als Zeichenketten, addiert diese und gibt die Summe zurueck
     * @param summand1 erste Summand als Zeichenkette
     * @param summand2 zweite Summand als Zeichenkette
     * @return Summe als Zeichenkette
     */
    private String addieren(String summand1, String summand2){
        String summe;
        int zwischenSumme;
        int uebertrag = 0;
        Stack<Integer> summeStk = new Stack<>();
        Stack<Integer> summand1AlsStk;
        Stack<Integer> summand2AlsStk;
        summand1AlsStk = ausZahlStackErstellen(summand1);
        summand2AlsStk = ausZahlStackErstellen(summand2);
        while(!summand1AlsStk.empty()){
            zwischenSumme = summand1AlsStk.peek()+summand2AlsStk.peek();
            summand1AlsStk.pop();
            summand2AlsStk.pop();
            if(zwischenSumme<10){
                summeStk.push(zwischenSumme+uebertrag);
                uebertrag = 0;
            }
            else{
                summeStk.push(zwischenSumme-10+uebertrag);
                uebertrag = 1;
            }
        }
        if(summand1AlsStk.empty() && uebertrag == 1)
            summeStk.push(1);
        summe = ausStackZahlErstellen(summeStk);
        return summe;
    }
    /**
     * Diese Methode prueft, ob eingegebene Zahl eine Palindromzahl ist.
     * @param zuPruefendeZahl
     * @return boolean
     */
    private boolean paliChecken(String zuPruefendeZahl){

        Stack<Integer> zahlAlsStk = ausZahlStackErstellen(zuPruefendeZahl);
        String gespiegelteZahl = zahlSpiegeln(zuPruefendeZahl);
        Stack<Integer> gespiegelteZahlAlsStk = ausZahlStackErstellen(gespiegelteZahl);
        while(!zahlAlsStk.empty()){
            if(zahlAlsStk.peek() == gespiegelteZahlAlsStk.peek());
                // tue nichts;
            else
                return false;
            zahlAlsStk.pop(); gespiegelteZahlAlsStk.pop();
        }
        return true;
    }
}
