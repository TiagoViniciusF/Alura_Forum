package br.rosaluz.banking.system.authentication.configuration;

import br.rosaluz.banking.system.authentication.dto.converter.UserDTOToUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserDTOToUser());
    }
}
