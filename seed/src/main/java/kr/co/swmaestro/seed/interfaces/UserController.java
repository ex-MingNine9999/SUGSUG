package kr.co.swmaestro.seed.interfaces;

import kr.co.swmaestro.seed.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
}
