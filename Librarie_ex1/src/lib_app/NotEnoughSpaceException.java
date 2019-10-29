package lib_app;

public class NotEnoughSpaceException extends Exception {
    public NotEnoughSpaceException(String message){
        super(message);
    }
}
