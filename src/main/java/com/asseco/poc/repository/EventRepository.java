package com.asseco.poc.repository;

import java.util.List;

import com.asseco.poc.document.EventEntity;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface EventRepository extends CrudRepository<EventEntity, String> {

    @NonNull
    List<EventEntity> findByNameInList(@NonNull List<String> names);
}
