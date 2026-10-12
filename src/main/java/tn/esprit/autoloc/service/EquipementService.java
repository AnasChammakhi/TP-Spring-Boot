package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IEquipementRepository;

@Service
@RequiredArgsConstructor
public class EquipementService {

    private final IEquipementRepository equipementRepository;
}
