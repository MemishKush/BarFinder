package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.EventServiceModel;

import java.util.List;

public interface EventService {
    EventServiceModel addEvent(EventServiceModel eventServiceModel);
    List<EventServiceModel> findAllEvents();
}
