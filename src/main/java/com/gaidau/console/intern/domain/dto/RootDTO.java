package com.gaidau.console.intern.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"extensions"})
public record RootDTO(
        DataDTO data
) {
}

