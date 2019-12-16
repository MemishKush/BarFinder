package com.project.barfinder.service;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.Reservation;
import com.project.barfinder.domain.entities.User;
import com.project.barfinder.domain.models.service.ReservationServiceModel;
import com.project.barfinder.repository.ReservationRepository;
import com.project.barfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;
    private final BarService barService;
    private final UserService userService;



    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, BarService barService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.barService = barService;
        this.userService = userService;


    }


    @Override
    public ReservationServiceModel addReservation(ReservationServiceModel reservationServiceModel,String barId,String username) {
        Bar barFromDb = ((BarServiceImpl) this.barService).getBarByIdInternal(barId);
        Reservation entity = this.modelMapper.map(reservationServiceModel, Reservation.class);
        User userFromDb = ((UserServiceImpl) this.userService).getUserByUsernameInternal(username);
        entity.setBar(barFromDb);
        entity.setUser(userFromDb);
        return this.modelMapper.map(this.reservationRepository.saveAndFlush(entity),ReservationServiceModel.class);
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
