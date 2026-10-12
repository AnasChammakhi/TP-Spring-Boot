package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IReservationRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final IReservationRepository reservationRepository;
}
