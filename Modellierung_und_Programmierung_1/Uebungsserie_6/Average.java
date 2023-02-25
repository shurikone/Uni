public class Average {

    long zahlen[];

    public Average(long zahlen[]){
        this.zahlen = zahlen;
    }

    public double getAverage() {
        int nThreads = (int) Math.floor(Math.sqrt(zahlen.length));
        PartialSum[] threadsArray = new PartialSum[nThreads];
        for (int i = 0; i < nThreads - 1; i++)                      // das Starten von Threads
        {
            int j = i * (zahlen.length / nThreads);
            int k = j - 1 + zahlen.length / nThreads;
            threadsArray[i] = new PartialSum(zahlen, j, k);
            threadsArray[i].start();
        }
        int j = (nThreads - 2) * (zahlen.length / nThreads) + zahlen.length / nThreads;
        threadsArray[nThreads - 1] = new PartialSum(zahlen, j, zahlen.length - 1);
        threadsArray[nThreads - 1].start();

        try {
            for (int i = 0; i < nThreads; i++)                 // das Warten auf Ergebnisse aus beiden Threads
                threadsArray[i].join();
        } catch (InterruptedException iEx) {
        }

        double sum = 0;
        double n = 0;
        for (int i = 0; i < nThreads; i++) {
            sum = sum + threadsArray[i].getAvg();
            n = +threadsArray[i].getAnzahlBerechneter();


        }


        // behandle gerade und ungerade Anzahl von Threads
        if (zahlen.length % 2 == 0) {
            return (sum + zahlen.length) / n;

        } else {
            return (sum / n) + 1;

        }
    }
}

