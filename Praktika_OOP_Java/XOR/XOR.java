import static java.lang.Integer.toBinaryString;

public class XOR {

    private int a;
    private int b;
    private int m;
    private int laenge;
    private int schluessel;
    public int deOderChiffre;
    public String klarTextName;
    public String geheimTextName;
    private String text;
    public  String verschluesselungssequenz;


    public XOR (int deOderChiffre,int a, int b, int m, int laenge, int schluessel, String klarTextName, String geheimTextName){
        this.a = a;
        this.b = b;
        this.m = m;
        this.laenge = laenge;
        this.schluessel = schluessel;
        this.deOderChiffre = deOderChiffre;
        this.klarTextName = klarTextName;
        this.geheimTextName = geheimTextName;
        this.verschluesselungssequenz = verschluesselungssequenzErstellen();
    }
    /**
     * Die Methode entschluesselt einen Text mithilfe von einer Instanz der Klasse Dechiffre.
     * @return klarer Text.
     */
    public String entschluesseln(){
        Dechiffre d = new Dechiffre(verschluesselungssequenz, text);
        return d.dechiffrieren();
    }

    public String verschluesseln(){
        Chiffre cypher = new Chiffre(this.verschluesselungssequenz,text);
        return cypher.chiffrieren();
    }



    public String verschluesselungssequenzErstellen(){
        if(a>0 && b>0 && m>0){
            StringBuilder sb = new StringBuilder();
            int xn = schluessel;
            int schluesselByte;
            for (int i = 0; i < laenge; i++){
                xn = (a * xn + b) % m;
                schluesselByte = toBinaryString(xn).toCharArray()[toBinaryString(xn).toCharArray().length - 1];
                sb.append(schluesselByte);
            }
            return sb.toString();
        }
        else
            return "-1";
    }

    public String lesenAusDatei(String dateipfad){
        Lesen lesen = new Lesen();
        lesen.lese(dateipfad);
        return this.text = lesen.getText().replace("ü", "ue").replace("ß", "ss");
    }

    /**
     * Die Methode schreibt entweder den Klar- oder Geheimtext in eine Datei.
     * @param geheimTextName
     * @param text
     * @param klarTextName
     */
    public void schreibenInDatei(String geheimTextName, String text, String klarTextName){
        Schreiben s = null;
        if (deOderChiffre == 1){
            s = new Schreiben(klarTextName);
        }
        else if(deOderChiffre == 0){
            s = new Schreiben(geheimTextName);
        }
        s.schreibe(text);
    }
}
