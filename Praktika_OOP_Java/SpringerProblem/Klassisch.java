import java.util.HashMap;
import java.util.Map;

/**
 * Die Klasse Klassisch implementiert die Logik fuer die klassische Variante des Springerproblems.
 */
class Klassisch {

    private int[][]Schachbrett;
    private int groesse;
    public int anzahlLoesung = 0;
    private int ausgabenAnzahl;
    private int[] posY;
    private int[] posX;
    /**
     * Gibt an ob ueberhaupt eine Loesung existiert.
     */
    public boolean istMoeglich = false;

    /**
     * Konstruktor fuer die Klasse Klassisch.
     *
     * @param ausgabenAnzahl die Anzahl der auszugebenden Loesungen
     * @param Spielbrett     das Schachbrett als zweidimensionales Array
     */
    public Klassisch(int ausgabenAnzahl, int[][] Spielbrett, int[] posX, int[] posY){
        this.Schachbrett = Spielbrett;
        this.groesse = Schachbrett.length;
        this.ausgabenAnzahl = ausgabenAnzahl;
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Ueberprueft, ob eine gegebene Position auf dem Schachbrett gueltig ist.
     *
     * @param x           die x-Koordinate der Position
     * @param y           die y-Koordinate der Position
     * @param groesse     die Groeße des Schachbretts
     * @param Schachbrett das Schachbrett als zweidimensionales Array
     * @return true, wenn die Position gueltig ist, andernfalls false
     */
    public boolean valid(int x, int y, int groesse, int[][] Schachbrett) {
        return (x >= 0 && y >= 0 && x < groesse && y < groesse && Schachbrett[x][y] == 0);
    }

    /**
     * Fuehrt den Backtracking-Algorithmus aus, um die Loesungem der klassische Variante auf dem Schachbrett zu berechnen.
     *
     * @param aktuellerZustand das aktuelle Schachbrett als zweidimensionales Array
     * @param groesse          die Groeße des Schachbretts
     * @param x                die x-Koordinate des aktuellen Feldes
     * @param y                die y-Koordinate des aktuellen Feldes
     * @param besucht          die Anzahl der bereits besuchten Felder
     */
    public void offeneV(int[][] aktuellerZustand, int groesse, int x, int y, int besucht)
    {
        aktuellerZustand[x][y] = besucht;

        if (besucht == groesse * groesse) {
            istMoeglich = true;
            anzahlLoesung++;

            if (anzahlLoesung <= ausgabenAnzahl) {
                ausgabe(aktuellerZustand);
            }
            // Backtrack zum vorherigen
            aktuellerZustand[x][y] = 0;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int newX = x + posX[i];
            int newY = y + posY[i];

            if (valid(newX, newY, groesse, aktuellerZustand) && aktuellerZustand[newX][newY] == 0) {
                offeneV(aktuellerZustand, groesse, newX, newY,
                        besucht + 1);
            }
        }

        // Backtrack
        aktuellerZustand[x][y] = 0;
    }

    /**
     * Gibt die Pfade des Springers in Schachnotation aus.
     *
     * @param aktuellerZustand das aktuelle Schachbrett als zweidimensionales Array
     */
    public void ausgabe(int aktuellerZustand[][]){
        String[] ausgabe = new String[groesse * groesse +1];
        for (int i = 0; i < groesse; i++) {
            for (int j = 0; j < groesse; j++) {
                int num = aktuellerZustand[i][j];
                ausgabe[num] = KoordinatenZuSchach(i+1,j+1);
            }
        }
        for(int i = 1; i < ausgabe.length; i++){
            if(i!=ausgabe.length-1){
                System.out.print(ausgabe[i] + "-> ");
            }else{
                System.out.print(ausgabe[i]);
            }
        }
        System.out.println();
    }

    /**
     * Wandelt eine Schachnotation in Koordinaten um.
     *
     * @param schachnotation die Schachnotation
     * @return ein Array mit den Koordinaten [x, y]
     */
    public int[] SchachZuKooardinaten(String schachnotation){
        int[] coordinates = new int[2];
        Map<Character, Integer> columnMap = new HashMap<>();
        columnMap.put('a', 1);
        columnMap.put('b', 2);
        columnMap.put('c', 3);
        columnMap.put('d', 4);
        columnMap.put('e', 5);
        columnMap.put('f', 6);
        columnMap.put('g', 7);
        columnMap.put('h', 8);

        int row = columnMap.get(schachnotation.charAt(0));
        int column = 9 - Character.getNumericValue(schachnotation.charAt(1));
        coordinates[0] = row;
        coordinates[1] = column;

        return coordinates;
    }

    /**
     * Gibt eine Schachnotation basierend auf den gegebenen Koordinaten zurueck.
     *
     * @param x die x-Koordinate
     * @param y die y-Koordinate
     * @return die Schachnotation fuer die gegebenen Koordinaten
     */
    public String KoordinatenZuSchach(int x, int y) {
        Map<Integer, Character> columnMap = new HashMap<>();
        columnMap.put(1, 'a');
        columnMap.put(2, 'b');
        columnMap.put(3, 'c');
        columnMap.put(4, 'd');
        columnMap.put(5, 'e');
        columnMap.put(6, 'f');
        columnMap.put(7, 'g');
        columnMap.put(8, 'h');

        char columnChar = columnMap.get(x);
        int row = 9 - y;

        String schachnotation = columnChar + String.valueOf(row);
        return schachnotation;
    }


}


