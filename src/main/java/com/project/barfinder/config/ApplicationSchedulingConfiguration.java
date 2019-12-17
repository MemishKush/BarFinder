package com.project.barfinder.config;

import com.project.barfinder.domain.models.service.EventServiceModel;
import com.project.barfinder.service.EventService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ApplicationSchedulingConfiguration {
    private final EventService eventService;

    public ApplicationSchedulingConfiguration(EventService eventService) {
        this.eventService = eventService;
    }
    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpiredEvent(){
    List<EventServiceModel> events = this.eventService.findAllEvents();
    LocalDateTime localDateTime = LocalDateTime.now();
        for (EventServiceModel event : events) {
            if (event.getEndTime().isAfter(localDateTime)){
                eventService.deleteEvent(event.getId());
            }
        }
    }
}
