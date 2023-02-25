import java.util.Map;
import java.util.Map;
import java.io.*;
import java.util.*;
import java.lang.String;
import java.lang.Integer;

public class Ausgabe {
    Map<String, Integer> wortUndHaeufigkeit;

    public Ausgabe(Map wortUndHaeufigkeit){
        this.wortUndHaeufigkeit = wortUndHaeufigkeit;
    }

    public void schreibeStatistik(String dateiName){
        File file = new File(dateiName);
    try (
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            )
    {
        writeLine(pw);
    }
    catch (FileNotFoundException fnfEx){
        fnfEx.printStackTrace(System.err);
    }
    catch (IOException ioEx){
        ioEx.printStackTrace(System.err);
    }
    }

    private void writeLine(PrintWriter pw){
        for (String wort : wortUndHaeufigkeit.keySet()){
            pw.println(wort + " : " + wortUndHaeufigkeit.get(wort));
        }
    }
}
