package kr.co.swmaestro.seed.interfaces;

import kr.co.swmaestro.seed.application.StartupDetailService;
import kr.co.swmaestro.seed.domain.Startup;
import kr.co.swmaestro.seed.domain.StartupDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StartupDetailController {
    @Autowired
    StartupDetailService startupDetailService;

    @GetMapping("/api/startup-detail")
    public StartupDetail data(String corpId) throws IllegalAccessException {
        StartupDetail ret = startupDetailService.getStartupDetail(corpId);

        return ret;
    }
}
