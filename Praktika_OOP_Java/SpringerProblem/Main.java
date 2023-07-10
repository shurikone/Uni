/**
 * Fuehrt das Spiel aus. Initialisiert dazu ein Schachbrett.
 */
public class Main{
    public static void main(String args[]) {
        Schachbrett schachbrett = new Schachbrett(5,"a8", 1, 2);
        if(schachbrett.variante == 0){
            schachbrett.doKV();
        }else{
            schachbrett.doEV();
        }
    }
}