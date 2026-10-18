package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IagenceService {
    Agence getById(long id);
    List<Agence> getAll();
    Boolean update(Agence a);
    Boolean remove(Agence a);
    Agence addag(Agence a);
}
