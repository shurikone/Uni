public class GeometricObjectsMain {
    public static void main(String[] args) {

        GeometrischeObjekte GeoObj = new GeometrischeObjekte();

        try {
            Kugel kugel1 = new Kugel(3.14);
            GeoObj.add(kugel1);
            Kugel kugel2 = new Kugel(275.836);
            GeoObj.add(kugel2);
            Wuerfel wuerfel1 = new Wuerfel(3.14);
            GeoObj.add(wuerfel1);
            Wuerfel wuerfel2 = new Wuerfel(275.836);
            GeoObj.add(wuerfel2);
            Wuerfel wuerfel3 = new Wuerfel(-207.15);
            GeoObj.add(wuerfel3);
        }
        catch(GeometricObjectException Exce)
        {
            System.out.println(Exce.getMessage() + "\n");
        }


        GeoObj.ausgeben();
    }
}