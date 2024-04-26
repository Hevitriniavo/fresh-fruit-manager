package com.tantely.freshfruitmanager.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        Long id,
        String name,
        Double price,
        Integer stockQuantity,
        String category,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDateTime addedDate,
        String origin,
        String url
) {
}
