import static java.lang.Integer.*;

/**
 * Die Klasse Dechiffre stellt Methoden zum Dechiffrieren der XOR-Chiffre zur verfuegung.
 */
public class Dechiffre {
    private String verschluesselungssequenz;
    private String verschluesselterText;

    /**
     * Der Konstruktor initialisiert die Werte der Instanz mit gegebenen Parametern.
     * @param verschluesselungssequenz
     * @param verschluesselterText
     */
    Dechiffre(String verschluesselungssequenz, String verschluesselterText){
        this.verschluesselungssequenz = verschluesselungssequenz;
        this.verschluesselterText = verschluesselterText;
    }

    /**
     * Die Methode entschluesselt einen Text, indem die XOR Chiffrierung benutzt wird.
     * @return klarer Text
     */
    public String dechiffrieren(){
        StringBuilder entschluesselterText = new StringBuilder();
        byte[] verschluessSequenzByArr = stringToBin(verschluesselungssequenz);
        byte[] verschluessTextByArr = stringToBin(verschluesselterText.substring(0, verschluesselterText.length()-1));
        byte[] entschluessTextByArr = new byte[verschluessTextByArr.length];
        for(int i = 0; i < verschluessTextByArr.length; i++){
            entschluessTextByArr[i] = (byte) ((int) verschluessTextByArr[i] ^ (int) verschluessSequenzByArr[i % verschluessSequenzByArr.length]);
        }
        int[] entschluessTextIntArr = binToDec(entschluessTextByArr);
        for(int a : entschluessTextIntArr)
            entschluesselterText.append((char) a);
        return entschluesselterText.toString().replaceAll("ue", "ü").replaceAll("ss", "ß");
    }

    /**
     * Die Methode wandelt einen Array mit einzigen Bytes, die Buchstaben repraesentieren in einen Array mit Zahlen,
     * die auch Buchstaben repraesentieren.
     * @param byteArr Array mit dualer Darstellung von Text
     * @return Array mit dezimaler Darstellung von Text
     */
    private int[] binToDec(byte[] byteArr){
        int[] intBinArr = new int[byteArr.length/7]; //Array mit binaeren Werten von Buchstaben
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int[] intDecArr = new int[intBinArr.length];
        for (int j = 0; j < intBinArr.length; j++){
            for (int i = j*7; i < (j+1)*7; i++) { // aus [1,1,1,1,1,1,1] macht [1111111]
                sb.append(byteArr[i]);
            }
            intDecArr[j] = Integer.parseInt(sb.toString(), 2);
            sb = new StringBuilder();
        }
        return intDecArr;
    }

    /**
     * Die Methode wandelt einen Text in Dualdarstellung
     * @param str der Text
     * @return ein Array vom typ "byte"
     */
    private byte[] stringToBin(String str) {
        byte[] byteArr = new byte[7 * str.length()]; // Erstellt ein Byte-Array mit der Länge 7 * Laenge des Eingabetexts

        for (int i = 0; i < str.length(); i++) { // Iteriert über jeden Buchstaben im Text
            int decimalValue = str.charAt(i); // Wandelt den Buchstaben in seinen dezimalen Wert um

            String binaryString = Integer.toBinaryString(decimalValue); // Konvertiert den dezimalen Wert in einen binaeren String
            int padding = 7 - binaryString.length(); // Berechnet die Anzahl der fehlenden fuehrenden Nullen

            StringBuilder binaryBuilder = new StringBuilder();
            for (int j = 0; j < padding; j++) {
                binaryBuilder.append('0'); // Fuegt fehlende fuehrende Nullen hinzu
            }
            binaryBuilder.append(binaryString); // Fuegt den binaeren Wert hinzu

            String paddedBinaryString = binaryBuilder.toString();

            for (int j = 0; j < paddedBinaryString.length(); j++) {
                byteArr[i * 7 + j] = (byte) (paddedBinaryString.charAt(j) - '0'); // Konvertiert jedes Zeichen im binaeren String in ein Byte und speichert es im Byte-Array
            }
        }
        return byteArr;
    }


}
