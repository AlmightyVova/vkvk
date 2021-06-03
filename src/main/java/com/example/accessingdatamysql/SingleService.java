package com.example.accessingdatamysql;

import com.example.accessingdatamysql.JUser;
import com.example.accessingdatamysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingleService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<JUser> getJUsers() {
        return userRepository.findAll();
    }

    public JUser getJUser(int jUserId) {
        return userRepository.findById(jUserId).get();
    }

    public JUser addUser(String name, String email) {
        JUser jUser = new JUser();
        jUser.setName(name);
        jUser.setEmail(email);

        userRepository.save(jUser);

        return jUser;
    }

    public JUser updateJUser(int jUserId, String name, String email) {
        JUser dbUser = userRepository.findById(jUserId).get();
        dbUser.setName(name);
        dbUser.setEmail(email);

        return userRepository.save(dbUser);
    }

    public void deleteJUser(int jUserId) {
        JUser jUser = userRepository.findById(jUserId).get();
        userRepository.delete(jUser);
    }
}
