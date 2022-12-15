/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author nicol
 */
public class ServicioCorreo {

    public void enviarCorreo(Set<String> destinatarios, String asunto, String cuerpo) {

    }

    public static boolean enviarNotificacion(Set<String> to, String subject, String body) {

        /*
        cuenta outlook:
intercambialo2022@outlook.com
clave: 2022Intercambialo
        
        https://www.wpoven.com/tools/free-smtp-server-for-testing
         */
        Session session;
        final String from = "api";
        final String pass = "822d7b9d562c40692fd630c46af973bb";
        final String host = "smtp.freesmtpservers.com";
        Properties properties = System.getProperties();
        // Setup mail server
        //properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        //properties.put("mail.smtp.user", from);
        //properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "25");
        //properties.put("mail.smtp.auth", "true");
       // properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        session = Session.getDefaultInstance(properties);
        Transport transport = null;
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html; charset=utf-8");

            // Set To: header field of the header.
            for (String to1 : to) {
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to1));
            }

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setContent(multipart, "text/html; charset=utf-8");
            //message.setText(body);

            // Send message
            transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());

            return true;
        } catch (MessagingException mex) {
            Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, mex.getMessage());
        } catch (Exception e) {
            Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, e.getMessage());
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException ex) {
                    Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

}
