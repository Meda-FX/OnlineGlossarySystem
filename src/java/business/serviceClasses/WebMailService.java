package business.serviceClasses;

import java.util.HashMap;

/**
 * WebMailService class uses to send mail to the users. The class sends mail using a given email address and uses an html
 * type email template. 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class WebMailService {
    
    /**
     * A method that send an email to the client. The mail will have a the recipient email, the email template
     * and the HashMap message to be displayed in the email.
     * @param to to the message recipient of the email
     * @param Template Template the template of the email that will be sent to the user
     * @param contents contents the content of the email to be send to the user
     */
    public static void sendMail(String to, String Template, HashMap<String, String> contents) { }
    
    /**
     * A method that send an email to the client. 
     * @param to to the message recipient of the email
     * @param subject subject the subject of the email to be send
     * @param body body the body of the email to be send to the client
     * @param bodyIsHTML bodyIsHTML checks if the body of the email is HTML or not
     */
    public static void sendmail(String to, String subject, String body, boolean bodyIsHTML) { }
}
