public class Kugel
    implements GeometricObject{
    private double radius;

    public Kugel(
            double radius
    ) {this.radius = radius;}


    public double getRadius() {
        return radius;
    }

    public double getDurchmesser() {
        double Durchmesser = radius * 2;
        return Durchmesser;
    }

    public double getVolumen() {
        double Volumen = 4.0/3.0 * 3.14 * Math.pow(radius, 3);
        return Volumen;
    }

    public double getOberflaeche() {
        double Oberflaeche = 4 * 3.14 * Math.pow(radius, 2);
        return Oberflaeche;
    }

}


