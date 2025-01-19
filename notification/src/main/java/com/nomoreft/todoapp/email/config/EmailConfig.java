package com.nomoreft.todoapp.email.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {

    private String host;
    private int port;
    private String username;
    private String password;
    private MailProperties properties = new MailProperties();

    @Getter
    @Setter
    public static class MailProperties {
        private boolean auth;
        private boolean starttls;
        private int connectiontimeout;
        private int timeout;
        private int writetimeout;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", properties.isAuth());
        props.put("mail.smtp.starttls.enable", properties.isStarttls());
        props.put("mail.smtp.connectiontimeout", properties.getConnectiontimeout());
        props.put("mail.smtp.timeout", properties.getTimeout());
        props.put("mail.smtp.writetimeout", properties.getWritetimeout());

        return mailSender;
    }
}