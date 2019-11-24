package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.EventServiceModel;
import com.project.barfinder.repository.EventRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EventServiceModel addEvent(EventServiceModel eventServiceModel) {
        return null;
    }

    @Override
    public List<EventServiceModel> findAllEvents() {
        return null;
    }
}
