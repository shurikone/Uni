public class Wuerfel
    implements GeometricObject{
    private double a;

    public Wuerfel(double a) throws GeometricObjectException {

        if (a < 0) {
            throw new GeometricObjectException("Wuerfel: Parameter Seite A " + "< 0; Wert: " + a);
        } else {
            this.a = a;
        }
    }
    public double getA(){
        return a;
    }

    public double getRaumdiagonale(){
        double Raumdiagonale = java.lang.Math.sqrt(3) * a;
        return Raumdiagonale;
    }

    public double getVolumen(){
        double Volumen = a*a*a;
        return Volumen;
    }

    public double getOberflaeche(){
        double Oberflaeche = a*a*6;
        return Oberflaeche;
    }
}
