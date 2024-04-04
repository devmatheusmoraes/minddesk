package br.com.infnet.minddesk;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API de Gerenciamento de Tickets",
				version = "1.0.0",
				description = "Esta é uma API para gerenciar e-mails para o time de suporte",
				contact = @Contact(name = "Equipe de Desenvolvimento", email = "luiz.asouza@al.infnet.edu.br"),
				license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")
		)
)
@SpringBootApplication
public class MinddeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinddeskApplication.class, args);
	}

}
