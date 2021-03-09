package kr.co.swmaestro.seed.interfaces;


import kr.co.swmaestro.seed.application.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrendController {
    @Autowired
    private TrendService trendService;

}
