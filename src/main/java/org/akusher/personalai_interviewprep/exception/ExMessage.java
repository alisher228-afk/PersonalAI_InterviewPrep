package org.akusher.personalai_interviewprep.exception;

import java.time.LocalDateTime;

public record ExMessage(
        String message,
        String detailedMessage,
        LocalDateTime errorTime
) {
}