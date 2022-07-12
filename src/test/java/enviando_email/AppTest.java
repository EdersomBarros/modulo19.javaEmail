package enviando_email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * Unit test for simple App. yannqnlhkohmgnjd
 */
public class AppTest {
	private String userName = "formacaojavaweb@gmail.com";
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
			properties.put("mail.smatp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");/* Classe socket de conexão ao smtp */

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}

			});
			System.out.println(senha);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
