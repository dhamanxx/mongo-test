package com.asseco.poc.document;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Serdeable
@MappedEntity
@Data
public class EventEntity {
    
    @Id 
    @GeneratedValue
    private String id;

    @NonNull
    @NotBlank 
    private String name;

    @Nullable
    private String description;
}
