package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Event;
import com.project.barfinder.domain.models.service.EventServiceModel;
import com.project.barfinder.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EventServiceModel addEvent(EventServiceModel eventServiceModel) {
        return this.modelMapper.map(this.eventRepository.save(this.modelMapper.map(eventServiceModel, Event.class)), EventServiceModel.class);
    }

    @Override
    public EventServiceModel findById(String id) {
        return this.modelMapper.map(eventRepository.findById(id),EventServiceModel.class);
    }

    @Override
    public List<EventServiceModel> findAllEvents() {
        List<EventServiceModel> serviceModels = new ArrayList<>();
        List<Event> eventsFromDb = this.eventRepository.findAll();
        for (Event event : eventsFromDb) {
            EventServiceModel mappedServiceModel = this.modelMapper.map(event, EventServiceModel.class);
            serviceModels.add(mappedServiceModel);
        }
        return serviceModels;
    }

    @Override
    public List<EventServiceModel> findByStartTime(LocalDateTime startTime) {
        List<EventServiceModel> eventServiceModels = new ArrayList<>();
        List<Event> eventsFromDb = this.eventRepository.findByStartTime(startTime);
        for (Event event : eventsFromDb) {
            EventServiceModel mappedServiceModel = this.modelMapper.map(event, EventServiceModel.class);
            eventServiceModels.add(mappedServiceModel);
        }
        return eventServiceModels;
    }

    @Override
    public EventServiceModel findByName(String title) {
        return this.modelMapper.map(eventRepository.findByTitle(title), EventServiceModel.class);
    }

    @Override
    public EventServiceModel editEvent(EventServiceModel eventServiceModel) {
        return this.modelMapper.map(eventRepository.saveAndFlush(this.modelMapper.map(eventServiceModel, Event.class)), EventServiceModel.class);
    }

    @Override
    public void deleteEvent(String id) {
        this.eventRepository.deleteById(id);
    }


}
