package com.jobposting.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "Job Posting API", description = "This is assignment from Crezam", version = "1.0", contact = @Contact(name = "Soumya", email = "soumyaranjanswain4610@gmail.com", url = "https://www.linkedin.com/in/soumyaswain86"), license = @License(name = "SOCIAL License", url = "https://www.linkedin.com/in/soumyaswain86")), externalDocs = @ExternalDocumentation(description = "This is backend", url = "https://www.linkedin.com/in/soumyaswain86"))
@Configuration
public class SwaggerConfig {

}
