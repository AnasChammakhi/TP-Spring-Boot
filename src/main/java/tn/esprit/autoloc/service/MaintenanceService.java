package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
}
