package enviando_email;


/**
 * Unit test for simple App. yannqnlhkohmgnjd
 */
public class AppTest {
	
	@org.junit.Test
	public void testeEmail()  throws Exception{
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Você está recebendo o acesso ao curso de Java<br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo.<br/><br/>");
		
		stringBuilderTextoEmail.append("<b>Login:</b> Eder@hotmail.com<br/>");
		stringBuilderTextoEmail.append("<b>Senha:</b> admin<br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://projetojavaweb.com/certificado-aluno/login\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border : 3px solid green;background-color:#99DA39;\">Acessar Portal do Aluno</a><br/><br/>");

		stringBuilderTextoEmail.append("<span style=\"font-size:8px\">Ass.: Eder do JDev Treinamentos</span>");
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("edersombarros@gmail.com", 
															"Eder do JDev Treinner", 
															"Testando Email com Java", 
															stringBuilderTextoEmail.toString());
		
		
		enviaEmail.enviarEmailAnexo(true);
			
			
			
			
		
			/**
			 * Caso o email não esteja sendo enviado, então
			 * coloque um tempo de espera mais isso só pode
			 * ser usado para testes */
			Thread.sleep(5000);
		} 
	}


