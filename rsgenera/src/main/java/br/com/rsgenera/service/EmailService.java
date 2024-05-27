package br.com.rsgenera.service;

import br.com.rsgenera.dto.EmailDto;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailDto emailDto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("noreply@gmail.com");
            helper.setSubject("Criação de Conta");
            helper.setTo(emailDto.email());

            String template  = loadTemplateEmail();

            template = template.replace("#{nome}", emailDto.name());
            helper.setText(template, true);
            javaMailSender.send(message);
        } catch (Exception exception) {
            System.out.println("Falha ao enviar o email");
        }
    }

    public String loadTemplateEmail() throws IOException {
        ClassPathResource resource = new ClassPathResource("template-email.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
