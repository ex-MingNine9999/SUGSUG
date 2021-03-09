package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.User;
import kr.co.swmaestro.seed.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser() {
        List<User> users = userRepository.findAll();

        return users;
    }
}
