package br.rosaluz.banking.system.authentication.repository;


import br.rosaluz.banking.system.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String Login);

}
