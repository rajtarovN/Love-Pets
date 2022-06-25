package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sbnz.integracija.example.model.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@Param("username") String username);

    List<User> findAllByUsernameNotLike(@Param("username") String username);
}