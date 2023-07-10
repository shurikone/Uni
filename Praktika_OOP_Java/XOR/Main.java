public class Main {
    public static void main(String[] args) {
        XOR xor = new XOR(0,3877,29573, 139968,5,3,"C:\\Users\\shird\\OOP_Praktikum_2.Semester\\XOR\\dateiii\\Gedicht.txt","C:\\Users\\shird\\OOP_Praktikum_2.Semester\\XOR\\dateiii\\geheimtext.txt\\");
        if(xor.deOderChiffre == 0){     // 0 = verschluesseln
            xor.lesenAusDatei(xor.klarTextName);
            xor.schreibenInDatei(xor.geheimTextName, xor.verschluesseln(), xor.klarTextName);
        }else if(xor.deOderChiffre == 1){ // 1 = entschluesseln
            xor.lesenAusDatei(xor.geheimTextName);
            xor.schreibenInDatei(xor.geheimTextName,xor.entschluesseln(),xor.klarTextName);
        }else{
            System.out.print("Ungueltige Eingabe!");
        }
    }
}


