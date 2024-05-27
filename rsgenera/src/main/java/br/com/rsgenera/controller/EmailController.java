package br.com.rsgenera.controller;

import br.com.rsgenera.dto.EmailDto;
import br.com.rsgenera.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendEmail(@RequestBody EmailDto email){
        service.sendEmail(email);
    }
}
