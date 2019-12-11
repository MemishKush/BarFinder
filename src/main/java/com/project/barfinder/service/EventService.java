package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Event;
import com.project.barfinder.domain.models.service.EventServiceModel;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    EventServiceModel addEvent(EventServiceModel eventServiceModel);
    EventServiceModel findById(String id);
    List<EventServiceModel> findAllEvents();
    List<EventServiceModel> findByStartTime(LocalDateTime startTime);
    EventServiceModel findByName(String title);
    EventServiceModel editEvent(EventServiceModel eventServiceModel);
    void deleteEvent(String id);

}
