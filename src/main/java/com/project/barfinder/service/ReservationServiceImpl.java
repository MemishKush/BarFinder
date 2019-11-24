package com.project.barfinder.service;

import com.project.barfinder.domain.models.service.ReservationServiceModel;
import com.project.barfinder.repository.ReservationRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservationServiceModel addReservation(ReservationServiceModel reservationServiceModel) {
        return null;
    }

    @Override
    public List<ReservationServiceModel> findAllReservations() {
        return null;
    }
}
