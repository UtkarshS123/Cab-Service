package com.cab.common.kafka;

import java.io.Serializable;

public record MailTemplate(
        String mailId,
        String subject,
        String message
) implements Serializable {
}