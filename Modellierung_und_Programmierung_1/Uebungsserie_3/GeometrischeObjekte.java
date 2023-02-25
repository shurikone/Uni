import java.util.ArrayList;

public class GeometrischeObjekte {

    private ArrayList <GeometricObject> GeoObjListe;

    public GeometrischeObjekte (){
        this.GeoObjListe = new ArrayList<GeometricObject>();
    }

    public void add(GeometricObject Element){
        GeoObjListe.add(Element);
    }

    public int getAnzahl(){
        return GeoObjListe.size();
    }

    public void ausgeben(){
        for (int i = 0; i < GeoObjListe.size(); i++)
        {
            if (GeoObjListe.get(i) instanceof Wuerfel)
            {
                Wuerfel w = (Wuerfel) this.GeoObjListe.get(i);
                System.out.println("Wuerfel mit a = " + w.getA() + ", Raumdiagonale = " + w.getRaumdiagonale()
                        + ", Volumen = " + w.getVolumen() + ", Oberflaeche = " + w.getOberflaeche());
            }

            else
            {
                Kugel k = (Kugel) this.GeoObjListe.get(i);
                System.out.println("Kugel mit Radius = " + k.getRadius() + ", Durchmesser = " + k.getDurchmesser()
                        + ", Volumen = " + k.getVolumen() + ", Oberflaeche = " + k.getOberflaeche());
            }
        }
    }
}


