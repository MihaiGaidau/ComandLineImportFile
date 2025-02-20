package com.gaidau.console.intern.domain.dto;

import java.time.Instant;
import java.util.List;

public record ProductDTO(
        String id,
        String title,
        String status,
        List<String> tags,
        boolean isGiftCard,
        String vendor,
        Instant updatedAt,
        Instant publishedAt,
        VariantsDto variants
) {}
