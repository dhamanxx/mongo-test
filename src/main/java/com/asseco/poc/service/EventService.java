package com.asseco.poc.service;

import java.util.List;
import java.util.Optional;

import com.asseco.poc.document.EventEntity;

import io.micronaut.core.annotation.NonNull;

public interface EventService {

    List<EventEntity> list();

    EventEntity save(EventEntity event);

    Optional<EventEntity> find(@NonNull String id);

    List<EventEntity> findByNameInList(List<String> name);
}
