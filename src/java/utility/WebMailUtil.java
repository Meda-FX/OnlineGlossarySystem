package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;

/**
 * WebMailUtil class uses to send mail to the users. The class sends mail
 * using a given email address and uses an html type email template.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class WebMailUtil {

    /**
     * A method that send an email to the client. The mail will have a the
     * recipient email, the email template and the HashMap message to be
     * displayed in the email.
     *
     * @param to to the message recipient of the email
     * @param subject subject line of the email
     * @param template Template the template of the email that will be sent to
     * the user
     * @param contents contents the content of the email to be send to the user
     * @throws FileNotFoundException
     * @throws IOException
     * @throws MessagingException
     * @throws NamingException
     */
    public static void sendMail(String to, String subject, String template, HashMap<String, String> contents) throws FileNotFoundException, IOException, MessagingException, NamingException {
        BufferedReader br = new BufferedReader(new FileReader(new File(template)));

        StringBuilder body = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            body.append(line);
            line = br.readLine();
        }

        String bodyString = body.toString();

        for (String key : contents.keySet()) {
            bodyString = bodyString.replace("{{" + key + "}}", contents.get(key));
        }
        sendMail(to, subject, bodyString, true);
    }

    /**
     * A method that send an email to the client.
     *
     * @param to to the message recipient of the email
     * @param subject subject the subject of the email to be send
     * @param body body the body of the email to be send to the client
     * @param bodyIsHTML bodyIsHTML checks if the body of the email is HTML or not
     * @throws javax.mail.MessagingException
     * @throws javax.naming.NamingException
     */
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException, NamingException {
        Context env = (Context) new InitialContext().lookup("java:comp/env");
        String username = (String)env.lookup("webmail-username");
        String password = (String)env.lookup("webmail-password");
        
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }
        
        Address fromAddress = new InternetAddress("ogs.capstone@gmail.com"); //Need to change to actual email in production
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        Transport transport = session.getTransport();
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
