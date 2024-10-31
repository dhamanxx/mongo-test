package com.asseco.poc.controller;

import java.util.List;
import java.util.Optional;

import com.asseco.poc.dto.EventDto;
import com.asseco.poc.mapper.EventMapper;
import com.asseco.poc.service.EventService;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Controller("/events")
@Produces(MediaType.APPLICATION_JSON)
@ExecuteOn(TaskExecutors.BLOCKING)
public class EventController {

    private final EventService eventService;
    
    private final EventMapper mapper;

    EventController(EventService eventService, EventMapper mapper) {  
        this.eventService = eventService;
        this.mapper = mapper;
    }

    @Get
    Iterable<EventDto> list() {
        return mapper.mapToDtoList(eventService.list());
    }

    @Post
    @Status(HttpStatus.CREATED)
    EventDto save(@NonNull @NotNull @Valid EventDto event) {
        return mapper.mapToDto(eventService.save(mapper.mapToEntity(event)));
    }

    @Put
    EventDto update(@NonNull @NotNull @Valid EventDto event) {
        return mapper.mapToDto(eventService.save(mapper.mapToEntity(event)));
    }

    @Get("/{id}")
    Optional<EventDto> find(@PathVariable String id) {
        return eventService.find(id).map(mapper::mapToDto);
    }

    @Get("/q")
    List<EventDto> query(@QueryValue @NotNull List<String> names) {
        return mapper.mapToDtoList(eventService.findByNameInList(names));
    }

}
