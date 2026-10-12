package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IContratRepository;

@Service
@RequiredArgsConstructor
public class ContratService {

    private final IContratRepository contratRepository;
}
