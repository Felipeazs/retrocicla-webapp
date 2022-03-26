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

import com.retrocicla.felipeazs.model.dto.ClienteDto;


public class AmazonSES {
	
	//Email verificado por AmazonSES
	final String FROM = "felipeazs@gmail.com";
	
	//El asunto del email de registro
	final String SUBJECT = "Verifica tu cuenta de registro en la tienda de Retrocicla";
	
	//Body del email con html
	final String HTMLBODY = 
			"<h1>Por favor verifica tu email</h1>" +
			"<p>Gracias por registrarte en la tienda de Retrocicla. Para completar el proceso de registro" +
			" has click en el siguiente link:</p>" + 
			"<a href='http://localhost:8080/email-verification?token=$tokenValue'>Último paso para tu registro</a><br/><br/>" +
			"Gracias!! Te estamos esperando.";
	
	//Body para emails sin html
	final String TEXTBODY = "Por favor verifica tu email" +
			"Gracias por registrarte en Retrocicla. Para completar el proceso de registro " +
			"abre la siguiente direccion URL en tu buscador: "
			+ "href='http://localhost:8080/email-verification?token=$tokenValue"
			+ " Gracias!! Te estamos esperando.";
	
	public void verifyEmail(ClienteDto clienteDto) {
		
		try {
			
			//Extrae las credenciales desde AwsCredentials.properties
			AWSCredentialsProvider provider = new ClasspathPropertiesFileCredentialsProvider();
			
			AmazonSimpleEmailService cliente = AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(provider).withRegion(Regions.SA_EAST_1).build();
						
			String htmlBodyWithToken = HTMLBODY.replace("$tokenValue", clienteDto.getEmailVerificationToken());
			String textBodyWithToken = TEXTBODY.replace("$tokenValue", clienteDto.getEmailVerificationToken());
			
			
			
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination().withToAddresses(clienteDto.getEmail()))
					.withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
					.withText(new Content().withCharset("UTF-8").withData(textBodyWithToken))).withSubject(new Content().withCharset("UTF-8")
					.withData(SUBJECT)))
					.withSource(FROM);
			
			cliente.sendEmail(request);
			
			System.out.println("Email enviado!!, pulento");
			
		} catch (Exception ex) {
			System.out.println("the email was not sent. Error message: " + ex.getMessage());
		}
		
		
	}
}
