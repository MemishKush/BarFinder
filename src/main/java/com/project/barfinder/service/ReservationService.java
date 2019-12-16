package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ReservationServiceModel;

import java.util.List;

public interface ReservationService {
    ReservationServiceModel addReservation(ReservationServiceModel reservationServiceModel,String barId,String username);
    List<ReservationServiceModel> findAllReservations();
    ReservationServiceModel findById(String id);
    void deleteReservation(String id);

}
