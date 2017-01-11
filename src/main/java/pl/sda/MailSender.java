package pl.sda;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 * Created by RENT on 2017-01-10.
 */
public class MailSender {
    public static void sendMail(String address, String title, String content) throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Misiu Koala");
        attachment.setName("Koala");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        String username = new String("javandwro1@gmail.com");
        email.setAuthenticator(new DefaultAuthenticator(username, "javand1wro"));
        email.setSSLOnConnect(true);
        email.setFrom(username);
        email.setSubject(title);
        email.setMsg(content);
        email.addTo(address);
        email.attach(attachment);
        email.send();

    }
}
