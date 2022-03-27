package com.retrocicla.felipeazs.shared;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.retrocicla.felipeazs.model.dto.ClienteDto;


public class AmazonSES {
	
	//Email verificado por AmazonSES
	final String FROM = "felipeazs@gmail.com";
	
	//El asunto del email de registro
	final String SUBJECT = "Verifica tu cuenta de registro en la tienda de Retrocicla";
	
	//Reset Password
	final String PASSWORD_RESET_SUBJECT = "Solicitud de cambio de contraseña";
	
	//Body del email con html
	final String HTMLBODY = 
			"<h1>Por favor verifica tu email</h1><br/>" +
			"<p>Gracias por registrarte en la tienda de Retrocicla. Para completar el proceso de registro" +
			" has click en el siguiente link:</p>" + 
			"<a href='http://localhost:8080/email-verification?token=$tokenValue'>http://localhost:8080/email-verification?token=$tokenValue</a><br/><br/>" +
			"Gracias!! Te estamos esperando.";
	
	//Body para emails sin html
	final String TEXTBODY = 
			"Por favor verifica tu email" +
			"Gracias por registrarte en Retrocicla. Para completar el proceso de registro " +
			"abre la siguiente direccion URL en tu buscador: "
			+ "href='http://localhost:8080/email-verification?token=$tokenValue"
			+ " Gracias!! Te estamos esperando.";
	
	final String PASSWORD_RESET_HTMLBODY = 
			"<h4>Hola, $nombre!</h4>" +
			"<p>Alguien ha solicitado un cambio de contraseña de usuario. <br/>"
			+ "Si no fuiste tu, por favor ignora este mensaje."
			+ " Si fuiste tú, has click en el siguiente link para resetear tu contraseña: </p>"
			+ "<a href='http://localhost:8080/password-reset-request?token=$tokenValue'>http://localhost:8080/password-reset-request?token=$tokenValue</a>"
			+ "<br/><br/>"
			+ "Gracias!!";
	
	final String PASSWORD_RESET_TEXTBODY = 
			"Por favor verifica tu email "
			+ "Alguien ha solicitado un cambio de contraseña de usuario. Si no fuiste tu, por favor ignora este mensaje."
			+ " Si fuiste tú, abre esta url en tu navegador: "
			+ "http://localhost:8080/password-reset-request?token=$tokenValue"
			+ "Gracias!!";
	
	public void verifyEmail(ClienteDto clienteDto) {
		
		try {
			
			//Extrae las credenciales desde AwsCredentials.properties
			AWSCredentialsProvider provider = new ClasspathPropertiesFileCredentialsProvider();
			
			AmazonSimpleEmailService cliente = AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(provider).withRegion(Regions.SA_EAST_1).build();
						
			//Reemplaza el dummy token con el token del cliente
			String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", clienteDto.getEmailVerificationToken());
			String textBodyWithToken = TEXTBODY.replace("$tokenValue", clienteDto.getEmailVerificationToken());
			
			//Construye el email y lo envía
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination().withToAddresses(clienteDto.getEmail()))
					.withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
					.withText(new Content().withCharset("UTF-8").withData(textBodyWithToken))).withSubject(new Content().withCharset("UTF-8")
					.withData(SUBJECT)))
					.withSource(FROM);
			
			cliente.sendEmail(request);
			
		} catch (Exception ex) {
			System.out.println("El mail no se pudo enviar. Error message: " + ex.getMessage());
		}		
	}

	public boolean sendPasswordResetRequest(String nombre, String email, String token) {
		
		boolean returnValue = false;
		
		AWSCredentialsProvider provider = new ClasspathPropertiesFileCredentialsProvider();
		
		AmazonSimpleEmailService cliente = AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(provider).withRegion(Regions.SA_EAST_1).build();
				
		String htmlBodyWithToken = PASSWORD_RESET_HTMLBODY.replace("$tokenValue", token);
			htmlBodyWithToken = htmlBodyWithToken.replace("$nombre", nombre);
		String textBodyWithToken = PASSWORD_RESET_TEXTBODY.replace("$tokenValue", token);
			textBodyWithToken = textBodyWithToken.replace("$nombre", nombre);
			
		SendEmailRequest request = new SendEmailRequest()
				.withDestination(new Destination().withToAddresses(email))
				.withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
				.withText(new Content().withCharset("UTF-8").withData(textBodyWithToken))).withSubject(new Content().withCharset("UTF-8")
				.withData(PASSWORD_RESET_SUBJECT)))
				.withSource(FROM);
		
		SendEmailResult result = cliente.sendEmail(request);
		if (result != null && (result.getMessageId() != null && !result.getMessageId().isEmpty())) {
			returnValue = true;
		}
				
		return returnValue;
	}
}
