package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sbnz.integracija.example.model.Pet;
import sbnz.integracija.example.model.User;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>  {

}
