import de.oop2023.util.UserInterface;

/**
 * Main Klasse fuer die Ausfuehrung alle anderer Klassen
 *
 * @author Daniil Shirokov
 */
public class Main {
    /**
     * Main Funktion, die alle andere Klassen startet.
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Herzlich willkommen!");
        Spiel.spielregelnAusgeben();
        String spielFortsetzen;
        do {
            Spiel spiel = new Spiel();
            spielFortsetzen = UserInterface.in.requestString("\nWünschen Sie ein neues Spiel? (zustimmen = \"Ja\" eintippen): ");
        }while (spielFortsetzen.toLowerCase().equals("ja"));
        System.out.println("Dabei ist Spiel beendet. Vielen Dank für die Teilnahme");
    }
}