/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author vinic
 */
public class MyExpetion extends Exception {

    public MyExpetion(String messege) {
        super(messege);
    }

    public MyExpetion(String message, Throwable cause) {
        super(message);
        System.err.println(message +" <<>> "+ cause.getMessage());
    }
}
