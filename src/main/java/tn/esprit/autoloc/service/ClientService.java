package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.repository.IClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final IClientRepository clientRepository;
}
