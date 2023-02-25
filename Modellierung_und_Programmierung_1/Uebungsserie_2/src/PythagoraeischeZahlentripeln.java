import java.util.Scanner;
public class PythagoraeischeZahlentripeln {
    public static void main(
            String[] args
    ){
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie bitte ein min X ein: ");
        int minX = scan.nextInt();
        System.out.println();
        System.out.print("Geben Sie bitte ein max X ein: ");
        int maxX = scan.nextInt();
        int anzPT = PythagoraeischeZahlentripel.pythagoraeischeZahlentripel(minX, maxX);
        System.out.println("Die Anzahl der gefundenen Pythagoräischen Zahlentripel: " + anzPT);
    }
}

