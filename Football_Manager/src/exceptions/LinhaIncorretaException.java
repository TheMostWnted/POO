package exceptions;

public class LinhaIncorretaException extends Exception {
    public LinhaIncorretaException(){
        super();
    }

    public LinhaIncorretaException(String str){
        super(str);
    }
}
