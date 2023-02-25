import java.security.InvalidParameterException;



public class GeometricObjectException
    extends InvalidParameterException {

    public GeometricObjectException(){
        super();
    }
    public GeometricObjectException(String message){
        super("GeometricObject: " + message);
    }
}
