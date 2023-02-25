import java.util.HashMap;
import java.util.Map;
import java.util.Map;

public class Statistik {
    String text;
    Map<String, Integer> wortUndHaeufigkeit = new HashMap<>();

    public Statistik(String textStrNeu){
        text = textStrNeu;

    }

    public Map<String, Integer> berecheStatistik(){
        text = sndZEntfernen();
        String[] textWoerteEinzeln = text.split("\\s+");
        for (int j = 0; j < textWoerteEinzeln.length; j++){

            if (!wortUndHaeufigkeit.containsKey(textWoerteEinzeln[j]))
            {
                wortUndHaeufigkeit.put( textWoerteEinzeln[j], 1);
            }
            else {
                int count = wortUndHaeufigkeit.get(textWoerteEinzeln[j]);
                wortUndHaeufigkeit.put(textWoerteEinzeln[j], count + 1);
            }
        }
        return wortUndHaeufigkeit;
    }


    public Map<String, Integer> getWortHaeufigkeit(){
        return wortUndHaeufigkeit;
    }

    private String sndZEntfernen(){
        char[] buchstaben = text.toCharArray();
        StringBuilder textMitBuchstaben = new StringBuilder();
        for (int i = 0; i < buchstaben.length; i++){
            if ((Character.isAlphabetic(buchstaben[i]) || (buchstaben[i] == 32)))
                textMitBuchstaben.append(buchstaben[i]);
            else
                textMitBuchstaben.append(" ");
        }
        /*
        In der Aufgabestellung war es nicht genau definiert, wie wir den Fall mit z.B. "das Lesen", "Lesen"
        (Als Verb am Anfang eines Satzes) und "lesen" behandeln müssen.
        z.B. Auf den ganzen Text könnte Methode .toLowerCase() angewendet werden, damit aber der
        Unterschied zwischen "das Lesen" und "lesen" verloren geht. Wenn diese Methode nicht angewendet würde,
         sind z.B. "Hallo" und "hallo" zwei verschiedene Wörter und deren Häufigkeit nicht zusammengezählt wird.
         Aus diesem Grund habe ich die Methode .toLowerCase() gar nicht benutzt.
         */
        return textMitBuchstaben.toString();
    }
}
