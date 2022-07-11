package enviando_email;

import java.util.Properties;

/**
 * Unit test for simple App.
 * yannqnlhkohmgnjd
 */
public class AppTest{
	
	@org.junit.Test
	public void testeEmail() {
		/*olhe as configurações smtp do email*/
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");/*Autorização*/
		properties.put("mail.smtp.starttls", "true");/*Autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail*/
		properties.put("mail.smtp.port", "465");/*portal do servidor*/
		properties.put("mail.smtp.socketFactory.port", "465");/*Expecificar a porta a ser conectada pelo socket*/
		properties.put("mail.smatp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao smtp*/
		
	}
	
    
}
