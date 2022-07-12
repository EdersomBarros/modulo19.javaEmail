package enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Unit test for simple App. yannqnlhkohmgnjd
 */
public class AppTest {
	private String userName = "ederemailformacaojavaweb@gmail.com";
	private String senha = "yannqnlhkohmgnjd";

	@org.junit.Test
	public void testeEmail() {
		/* olhe as configurações smtp do email */
		try {

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");/* Autorização */
			properties.put("mail.smtp.starttls", "true");/* Autenticação */
			properties.put("mail.smtp.host", "smtp.gmail.com");/* Servidor gmail */
			properties.put("mail.smtp.port", "465");/* portal do servidor */
			properties.put("mail.smtp.socketFactory.port", "465");/* Expecificar a porta a ser conectada pelo socket */
			properties.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");/* Classe socket de conexão ao smtp */

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}

			});
			
			Address[] toUser = InternetAddress.parse("ederemailformacaojavaweb@gmail,edersombarros@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));/*Quem está enviando*/
			message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
			message.setSubject("Chegou o email enviado com java");/*Assnto do e-mail*/
			message.setText("Olá programador, você acaba de receber um email do curso com Java Web do Alex");
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
