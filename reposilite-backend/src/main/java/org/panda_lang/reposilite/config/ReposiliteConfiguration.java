package org.panda_lang.reposilite.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;

@EnableWebMvc
@Configuration
public class ReposiliteConfiguration {

    @Bean
    public File repositoryDirectory() {
        return new File("repositories");
    }

    @Bean
    public PromptProvider shellPrompt() {
        return () -> new AttributedString("reposilite:> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
