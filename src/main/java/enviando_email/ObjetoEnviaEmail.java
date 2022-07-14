package enviando_email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ObjetoEnviaEmail {

	private String userName = "ederemailformacaojavaweb@gmail.com";
	private String senha = "yannqnlhkohmgnjd";
	private String listaDestinatarios = "ederemailformacaojavaweb@gmail,edersombarros@gmail.com";
	private String nomeRemetente = "Eder JDev - Treinamento";
	private String assuntoEmail = "";
	private String textoEmail = "";

	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {

		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;

	}

	public void enviarEmail(boolean envioHTML) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");/* Vai fazer o projeto autenticar com a segurança SSL */
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

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));/* Quem está enviando */
		message.setRecipients(Message.RecipientType.TO, toUser);/* Email de destino */
		message.setSubject(assuntoEmail);/* Assnto do e-mail */
		if (envioHTML) {

			message.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			message.setText(textoEmail);/* Texto do email */
		}
		Transport.send(message);
	}
	
	public void enviarEmailAnexo(boolean envioHTML) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");/* Vai fazer o projeto autenticar com a segurança SSL */
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

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));/* Quem está enviando */
		message.setRecipients(Message.RecipientType.TO, toUser);/* Email de destino */
		message.setSubject(assuntoEmail);/* Assnto do e-mail */
		
		/*parte 1 do email*/
		MimeBodyPart corpoEmail = new MimeBodyPart();
		
		if (envioHTML) {

			corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			corpoEmail.setText(textoEmail);/* Texto do email */
		}
		
		MimeBodyPart anexoEmail = new MimeBodyPart();
		
		/*Onde é passado o simuladordePDF você passa o seu arquivo gravado no banco e dados*/
		anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladorPDF(), "application/pdf")));
		anexoEmail.setFileName("anexoemail.pdf");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		multipart.addBodyPart(anexoEmail);
		
		message.setContent(multipart);
		
		Transport.send(message);
	}
	/**
	 *Esse método simula o PDF ou qualquer arquivo que possa  ser enviado por anexo no email
	 *voce pode pegar o arquivo no seu banco de dados base64,byte[]
	 *retorna um pdf em branco com o texto paragrafo
	 */
	private FileInputStream simuladorPDF() throws Exception{
		
		Document document = new Document();
		File file = new File ("ileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("Conteudo do PDF anexo com java Mail"));
		document.close();
		return new FileInputStream(file);
		
	}
	
	
	
}
