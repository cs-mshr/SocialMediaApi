package com.facebook.api.service;

import com.facebook.api.model.User;
import com.facebook.api.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepo userRepo;

    @Value(value = "${spring.mail.username}")  // EL5
    private String emailUsername;


    public void sendEmailFriend(
            User newUser
    ){

        String friendEmail = getFriendEmail(newUser);

        String subject = "New Friend Added to your connections";
        String body = newUser.getName() + " is your latest connection.\n"
                + "Mobile number - " + newUser.getPhone_number() + "Friends email : " + newUser.getEmail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailUsername);
        message.setTo(friendEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

    }

    private String getFriendEmail(User newUser) {
        User friend = userRepo.findById(newUser.getFriend_of()).orElse(null);
        return friend != null ? friend.getEmail() : "cshekharmshr@gmail.com";
    }

}
