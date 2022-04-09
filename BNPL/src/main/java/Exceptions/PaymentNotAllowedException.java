package Exceptions;

import javax.swing.plaf.SeparatorUI;

public class PaymentNotAllowedException extends RuntimeException{
    public PaymentNotAllowedException(String message){
        super(message);
    }
}
