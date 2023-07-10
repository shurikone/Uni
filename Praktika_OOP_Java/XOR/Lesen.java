import java.io.*;

/**
 * Die Klasse Lesen stellt Funktionen zum Lesen und Verarbeiten von Textdateien bereit.
 */
class Lesen {
    private StringBuilder text;

    /**
     * Der Konstruktor initialisiert die Instanz der Klasse Lesen.
     */
    public Lesen() {
        this.text = new StringBuilder();
    }

    /**
     * Liest den Inhalt einer Textdatei und speichert ihn im StringBuilder-Objekt.
     *
     * @param dateipfad der Pfad zur Textdatei
     * @return null (Rückgabewert dient nur der Vollständigkeit und hat keine Bedeutung)
     */
    public void lese(String dateipfad) {
        try {
            File file = new File(dateipfad);
            FileReader fReader = new FileReader(file);
            BufferedReader bfReader = new BufferedReader(fReader);

            if (bfReader.ready()) {
                String line = bfReader.readLine();
                char x = 10;
                while (line != null) {
                    text.append(line).append(x);
                    line = bfReader.readLine();
                }
            }
            bfReader.close();
            fReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Datei " + dateipfad + " nicht gefunden!");
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei " + dateipfad + " aufgetreten!");
        }
    }

    /**
     * Gibt den gespeicherten Text als String zurück.
     *
     * @return der gespeicherte Text als String
     */
    public String getText(){
        return text.toString();
    }
}



