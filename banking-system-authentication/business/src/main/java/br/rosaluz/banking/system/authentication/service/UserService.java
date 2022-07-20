package br.rosaluz.banking.system.authentication.service;


import br.rosaluz.banking.system.authentication.model.User;

import java.util.Optional;

public interface UserService {

    void create(User user) throws Exception;
    User saveUser(User user);
    void process(String menssage);
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
    boolean validateLoginAlredyExist(String login);
    void updateWithAccount(Long id, String accountNumber);

}
