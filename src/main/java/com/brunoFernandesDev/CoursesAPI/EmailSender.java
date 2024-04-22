package com.brunoFernandesDev.CoursesAPI;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    public static void send(String recipientEmail, String subject, String body) {

        System.out.println("Simulating sending email to [%s]:\n".formatted(recipientEmail));
        System.out.println("Subject: %s\nBody: %s\n".formatted(subject, body));
    }
}
