package com.project.barfinder.config;

import com.project.barfinder.domain.models.service.BarServiceModel;
import com.project.barfinder.domain.models.service.SearchBarServiceModel;
import com.project.barfinder.service.BarService;
import com.project.barfinder.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationSchedulingConfiguration {
    private final EventService eventService;

    @Autowired
    public ApplicationSchedulingConfiguration(EventService eventService) {
        this.eventService = eventService;
    }

//    @Scheduled(cron = "*/10 * * * * *") // FOR PROJECT DEFENSE
    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpiredEvent() {
        this.eventService.deleteExpiredEvents();
    }
}
