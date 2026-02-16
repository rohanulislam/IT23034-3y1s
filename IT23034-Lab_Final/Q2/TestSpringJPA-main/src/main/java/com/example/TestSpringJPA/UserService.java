package com.example.TestSpringJPA;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllUsers() {
        return repository.findAll();
    }

    public void saveUser(Student student) {
        repository.save(student);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public Student getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    }
}
