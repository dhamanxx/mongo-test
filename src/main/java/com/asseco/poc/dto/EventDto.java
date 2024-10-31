package com.asseco.poc.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Serdeable
@Data
@AllArgsConstructor
@Builder
public class EventDto {
    
    private String id;

    private String name;

    private String description;
}
