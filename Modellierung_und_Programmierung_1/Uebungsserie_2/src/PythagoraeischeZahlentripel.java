public class PythagoraeischeZahlentripel {

    public static int[] createIntArray(int minX, int maxX){
        int diff = maxX - minX;
        int[] arr = new int[diff + 1];

        for (int i = 0; i < diff+1; i++){
            arr[0] = minX;
            arr[i] = minX + i;
        }

        return arr;
    }

    public static void arrayInhaltAusgeben(int[] arr){
        for (int i = 0; i<arr.length-1; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.print(arr[arr.length-1]);
    }

    public static int[] quadriere(int[] arr){
        int[] arrQuadrat = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrQuadrat[i] = arr[i] * arr[i];
        return arrQuadrat;
    }

    public static boolean testAufQuadratzahl(int zahl){
        if (zahl / Math.sqrt(zahl) == Math.floor(Math.sqrt(zahl)))
            return true;
        else
            return false;
    }

    public static int pythagoraeischeZahlentripel(int ganzMin, int ganzMax){
        int[] arr = createIntArray(ganzMin, ganzMax);
        int[] arrQuad = quadriere(arr);
        arrayInhaltAusgeben(arrQuad);
        System.out.println();
        int anzPT = 0;
        for(int i = 0; i < arrQuad.length; i++){
            for(int j = 0; j < arrQuad.length; j++){
                int diff = arrQuad[j] - arrQuad[i];
                if (j>i) {
                    if (testAufQuadratzahl(diff) && diff>arrQuad[i]) {
                        System.out.println(Math.sqrt(arrQuad[i]) + "^2 + " + Math.sqrt(diff) + "^2 = " + Math.sqrt(arrQuad[j]) + "^2");
                        anzPT++;
                    }
                }
            }
        }
        return anzPT;
    }
}