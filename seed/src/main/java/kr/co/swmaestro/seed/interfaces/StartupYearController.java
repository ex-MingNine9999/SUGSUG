package kr.co.swmaestro.seed.interfaces;

import kr.co.swmaestro.seed.application.StartupYearService;
import kr.co.swmaestro.seed.domain.StartupYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StartupYearController {
    @Autowired
    StartupYearService startupYearService;

    @GetMapping("/api/startup-year")
    public List<StartupYear> getOneYear(String corpId) throws IllegalAccessException{
        return startupYearService.getStartupYearById(corpId);
    }
}
