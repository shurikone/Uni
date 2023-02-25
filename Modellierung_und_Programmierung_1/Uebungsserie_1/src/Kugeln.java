public class Kugeln {
    public static void main(
            String[] args
    ) {
        mup1.Kugel kugel1 = new mup1.Kugel(1.0);
        kugel1.setRadius(5.0);
        double radius1 = kugel1.getRadius();
        System.out.print("Kugel mit Radius = " + radius1 + ", ");
        double durchmesser1 = kugel1.getDurchmesser();
        System.out.print("Durchmesser = " + durchmesser1 + ", ");
        double volumen1 = kugel1.getVolumen();
        System.out.print("Volumen = " + volumen1 + ", ");
        double oberflaeche1 = kugel1.getOberflaeche();
        System.out.println("Oberfläche = " + oberflaeche1 + ", ");

        mup1.Kugel kugel2 = new mup1.Kugel(1.0);
        kugel2.setRadius(7.0);
        double radius2 = kugel2.getRadius();
        System.out.print("Kugel mit Radius = " + radius2 + ", ");
        double durchmesser2 = kugel2.getDurchmesser();
        System.out.print("Durchmesser = " + durchmesser2 + ", ");
        double volumen2 = kugel2.getVolumen();
        System.out.print("Volumen = " + volumen2 + ", ");
        double oberflaeche2 = kugel2.getOberflaeche();
        System.out.println("Oberfläche = " + oberflaeche2 + ", ");

        mup1.Kugel kugel3 = new mup1.Kugel(1.0);
        kugel3.setRadius(-21.0);
        double radius3 = kugel3.getRadius();
        System.out.print("Kugel mit Radius = " + radius3 + ", ");
        double durchmesser3 = kugel3.getDurchmesser();
        System.out.print("Durchmesser = " + durchmesser3 + ", ");
        double volumen3 = kugel3.getVolumen();
        System.out.print("Volumen = " + volumen3 + ", ");
        double oberflaeche3 = kugel3.getOberflaeche();
        System.out.print("Oberfläche = " + oberflaeche3 + ", ");
    }
}
