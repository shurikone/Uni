/**
 * Die Klasse Chiffre stellt Methoden zum Verschluesseln von Text mithilfe der XOR-Chiffre zur Verfuegung.
 */
public class Chiffre {
    private String verschluesselungssequenz;
    private String klarerText;

    /**
     * Konstruktor: Erzeugt eine neue Instanz der Klasse Chiffre mit den gegebenen Parametern.
     *
     * @param verschluesselungssequenz Die Verschluesselungssequenz, die für die XOR-Chiffre verwendet wird.
     * @param klarerText               Der zu verschluesselnde Klartext.
     */
    public Chiffre(String verschluesselungssequenz, String klarerText) {
        this.verschluesselungssequenz = verschluesselungssequenz;
        this.klarerText = klarerText;
    }

    /**
     * Verschluesselt den Klartext mithilfe der XOR-Chiffre.
     *
     * @return Der verschluesselte Text.
     */
    public String chiffrieren() {
        StringBuilder verschluesselterText = new StringBuilder();
        byte[] verschluessSequenzByArr = stringToBin(verschluesselungssequenz);
        byte[] klarerTextByArr = stringToBin(klarerText);
        byte[] verschluessTextByArr = new byte[klarerTextByArr.length];
        for (int i = 0; i < klarerTextByArr.length; i++) {
            verschluessTextByArr[i] = (byte) (klarerTextByArr[i] ^ verschluessSequenzByArr[i % verschluessSequenzByArr.length]);
        }
        int[] entschluessTextIntArr = binToDec(verschluessTextByArr);
        for(int a : entschluessTextIntArr)
            verschluesselterText.append((char) a);
        return verschluesselterText.toString();
    }

    /**
     * Konvertiert einen String in ein Byte-Array, das die binaere Darstellung des Texts enthaelt.
     *
     * @param str Der zu konvertierende String.
     * @return Das Byte-Array mit der binaeren Darstellung des Texts.
     */
    public byte[] stringToBin(String str) {
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

        return byteArr; // Gibt das Byte-Array mit der binaeren Darstellung des Texts zurueck
    }

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
}

