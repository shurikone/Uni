import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        long[] zahlen = new long[100];
        for (int i = 1; i < zahlen.length; i++)
            zahlen[i] = i;

        long[] zahlen1 = new long[16000075];
        for (int i = 1; i < zahlen1.length; i++)
            zahlen1[i] = i;


        System.out.println("das Durchschnitt von " + zahlen[1] + " bis " + zahlen.length + " = "
        + new Average(zahlen).getAverage());

        System.out.println("das Durchschnitt von " + zahlen1[1] + " bis " + zahlen1.length + " = "
                + new Average(zahlen1).getAverage());


    }
}