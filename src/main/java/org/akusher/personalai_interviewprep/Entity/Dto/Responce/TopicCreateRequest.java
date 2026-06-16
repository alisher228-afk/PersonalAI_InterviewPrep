package org.akusher.personalai_interviewprep.Entity.Dto.Responce;

import jakarta.validation.constraints.NotBlank;

public record TopicCreateRequest(
        @NotBlank String name,
        String description
) {}
