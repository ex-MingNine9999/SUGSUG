package kr.co.swmaestro.seed;

import kr.co.swmaestro.seed.application.StartupService;
import kr.co.swmaestro.seed.domain.Startup;
import kr.co.swmaestro.seed.domain.StartupRepository;
import kr.co.swmaestro.seed.interfaces.StartupController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@SpringBootApplication
public class SeedApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeedApplication.class, args);
	}

}
