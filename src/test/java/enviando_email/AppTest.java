package enviando_email;


/**
 * Unit test for simple App. yannqnlhkohmgnjd
 */
public class AppTest {
	
	@org.junit.Test
	public void testeEmail()  throws Exception{
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("edersombarros@gmail.com", 
															"Eder do JDev Treinner", 
															"Testando Email com Java", 
															"Esse texto é a descrição do meu email");
		
		
enviaEmail.enviarEmail();
			
			
			
			
		
			/**
			 * Caso o email não esteja sendo enviado, então
			 * coloque um tempo de espera mais isso só pode
			 * ser usado para testes */
			Thread.sleep(5000);
		} 
	}


