package ru.javabegin.backend.todobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javabegin.backend.todobackend.entity.Stat;
import ru.javabegin.backend.todobackend.repo.StatRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }
}
