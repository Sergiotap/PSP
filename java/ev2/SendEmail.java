/*
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
public class SendEmail {

  /*
  public static void main(String[] args) {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, null);

    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("from@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
      message.setSubject("Testing JavaMail");
      message.setText("Hello, this is a test email sent from Java code.");

      Transport.send(message);

      System.out.println("Email sent successfully");

    } catch (AddressException e) {
      e.printStackTrace();
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
  */
}