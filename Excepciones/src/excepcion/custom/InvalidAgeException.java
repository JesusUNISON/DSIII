package excepcion.custom;

public class InvalidAgeException extends Exception  {

    public InvalidAgeException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }


}
