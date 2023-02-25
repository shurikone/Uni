public class PartialSum extends Thread{

    // Eingabe
    private long[] arrayZahlenEingabe;
    private int iStart, iEnd;
    // Ausgabe
    private double durchschnittAusgabe;
    private int anzahlBerechneter;

    public PartialSum(long[] arrayZahlenEingabe, int iStart, int iEnd){
        super();
        this.arrayZahlenEingabe = arrayZahlenEingabe;
        this.iEnd = iEnd;
        this.iStart = iStart;
    }

    public double getAvg(){
        return durchschnittAusgabe;
    }

    @Override
    public void run(){
        if (arrayZahlenEingabe == null) {
            System.out.println("arrayZahlenEingabe == null");
            return;
        }
        durchschnittAusgabe = 0;
        for (int i = iStart; i < iEnd+1;i++){
            durchschnittAusgabe = durchschnittAusgabe + arrayZahlenEingabe[i];
            anzahlBerechneter = i;


        }
    }

    public int getAnzahlBerechneter(){
        anzahlBerechneter = iEnd+1;
        return anzahlBerechneter;
    }

}
