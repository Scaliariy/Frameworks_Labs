/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.CustomExceptions;

import java.util.regex.Pattern;

/**
 *
 * @author Erlkonig
 */
public class EmailException extends Exception{

    public EmailException() {
        super("invalid email type");
    }
    
}
