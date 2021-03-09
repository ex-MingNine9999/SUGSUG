package kr.co.swmaestro.seed.interfaces;

import kr.co.swmaestro.seed.application.PresentationService;
import kr.co.swmaestro.seed.domain.Presentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentationController {
    @Autowired
    PresentationService presentationService;

}
