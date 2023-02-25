import java.io.File;
import java.lang.String;
import java.util.Map;

public class TextStatistik {
    public static void main(String[] args) {
        String pfad = "C:\\Werke-Shakespeare\\";
        String[] alleDateien = {pfad + "Coriolanus.txt",
                                pfad + "Der-Kaufmann-von-Venedig.txt",
                                pfad + "Die-Irrungen.txt",
                                pfad + "Hamlet.txt",
                                pfad + "Julius-Caesar.txt",
                                pfad + "Macbeth.txt",
                                pfad + "Timon-von-Athen.txt",
                                pfad + "Was-ihr-wollt.txt",
                                pfad + "Wie-es-Euch-gefaellt.txt"};
        for (int i = 0; i < alleDateien.length; i++) {
            Text text = new Text();
            text.leseTextAusDatei(alleDateien[i]);
            Statistik stats = new Statistik(text.toString());
            Ausgabe ausgabe = new Ausgabe(stats.berecheStatistik());
            ausgabe.schreibeStatistik(alleDateien[i].replaceAll(".txt", ".stat"));
        }
    }
}