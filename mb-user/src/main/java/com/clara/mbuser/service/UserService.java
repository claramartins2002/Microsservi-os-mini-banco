package com.clara.mbuser.service;

import com.clara.mbuser.dto.CadUser;
import com.clara.mbuser.entity.User;
import com.clara.mbuser.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User cadastrar(User user){
        return repository.save(user);
    }
    public User buscar(Long id) {

        Optional<User> optional = repository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado !! :( "));
    }
    public User buscarPorCpf(String cpf) {

       User optional = repository.findByCpf(cpf);
        return optional;
    }

    public User atualizar(CadUser user, Long id) {
        User original = this.buscar(id);
        User atualizado = new User(user.getNome(), user.getCpf(), user.getEndereco(), user.getTelefone(), user.getEmail());
        atualizado.setId(original.getId());
        return repository.save(atualizado);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }

}
