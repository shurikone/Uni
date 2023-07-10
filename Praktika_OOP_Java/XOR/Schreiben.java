import java.io.*;
/**
 * Die Klasse Schreiben stellt Methoden zum Schreiben in eine neue Datei zur Verfügung.
 */

public class Schreiben {
    private String neueDateiName;
    private File datei;


/**
     * Der Konstruktor initialisiert die Variablen der Instanz mit den Werten der Parameter.
     * @param neueDateiName der Name der neuen Datei
     */

    public Schreiben(String neueDateiName) {
        this.neueDateiName = neueDateiName;
        this.datei = new File(neueDateiName);
    }


/**
     * Die Methode schreibt den übergebenen Text in die Datei.
     * @param text der zu schreibende Text
     */

    public void schreibe(String text) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(datei)))) {
            pw.write(text);
        } catch (FileNotFoundException e) {
            System.err.println("Die Datei konnte nicht erstellt werden: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }
}

