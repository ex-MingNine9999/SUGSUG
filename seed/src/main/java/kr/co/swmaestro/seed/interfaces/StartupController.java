package kr.co.swmaestro.seed.interfaces;

import jdk.nashorn.internal.objects.annotations.Getter;
import kr.co.swmaestro.seed.application.StartupService;
import kr.co.swmaestro.seed.domain.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@CrossOrigin
@RestController
public class StartupController {
    @Autowired
    private StartupService startupService;

    @GetMapping("/api/startups")
    public List<Startup> list(){
        List<Startup> startups = startupService.getStartups();

        return startups;
    }

    @GetMapping("/api/startup")
    public Startup StartupBySid(String corpId) throws IllegalAccessException {
        Startup ret = startupService.getStartupBySid(corpId);

        return ret;
    }
}
