package org.akusher.personalai_interviewprep.Entity.Dto.Topic.TopicRequest;

import jakarta.validation.constraints.NotBlank;

public record TopicCreateRequest(
        @NotBlank String name,
        String description
) {}
