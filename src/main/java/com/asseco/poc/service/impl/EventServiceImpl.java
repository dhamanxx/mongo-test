package com.asseco.poc.service.impl;

import java.util.List;
import java.util.Optional;

import com.asseco.poc.document.EventEntity;
import com.asseco.poc.repository.EventRepository;
import com.asseco.poc.service.EventService;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

@Singleton
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }
    public List<EventEntity> list() {
        return repository.findAll();
    }

    public EventEntity save(EventEntity event) {
        if (event.getId() == null) {
            return repository.save(event);
        } else {
            return repository.update(event);
        }
    }

    public Optional<EventEntity> find(@NonNull String id) {
        return repository.findById(id);
    }

    public List<EventEntity> findByNameInList(List<String> name) {
        return repository.findByNameInList(name);
    }
}
