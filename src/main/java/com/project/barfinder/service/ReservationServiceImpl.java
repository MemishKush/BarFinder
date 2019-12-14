package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Reservation;
import com.project.barfinder.domain.models.service.ReservationServiceModel;
import com.project.barfinder.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservationServiceModel addReservation(ReservationServiceModel reservationServiceModel) {
        return this.modelMapper.map(this.reservationRepository.saveAndFlush(this.modelMapper.map(reservationServiceModel, Reservation.class)),ReservationServiceModel.class);
    }

    @Override
    public List<ReservationServiceModel> findAllReservations() {
        List<ReservationServiceModel> reservationServiceModels = new ArrayList<>();
        List<Reservation> entity = this.reservationRepository.findAll();
        for (Reservation reservation : entity) {
            ReservationServiceModel mappedReservationServiceModel = this.modelMapper.map(reservation,ReservationServiceModel.class);
            reservationServiceModels.add(mappedReservationServiceModel);
        }
        return reservationServiceModels;
    }

    @Override
    public ReservationServiceModel findById(String id) {
        return this.modelMapper.map(this.reservationRepository.findById(id),ReservationServiceModel.class);
    }

    @Override
    public void deleteReservation(String id) {
        this.reservationRepository.deleteById(id);
    }
}
