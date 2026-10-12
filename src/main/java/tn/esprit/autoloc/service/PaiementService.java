package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IPaiementRepository;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final IPaiementRepository paiementRepository;
}
