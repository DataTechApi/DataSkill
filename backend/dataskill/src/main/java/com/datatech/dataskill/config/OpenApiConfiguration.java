package com.datatech.dataskill.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "DataSkill API",
                version = "1.0.0",
                description = "API para gerenciamento de Skills na empresa",
                contact = @Contact(
                        name = "DataTech",
                        url = "https://github.com/DataTechApi/DataSkill"

                )

        )

)
public class OpenApiConfiguration {



}
