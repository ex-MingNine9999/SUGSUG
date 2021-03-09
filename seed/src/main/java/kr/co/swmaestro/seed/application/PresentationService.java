package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.Presentation;
import kr.co.swmaestro.seed.domain.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationService {
    @Autowired
    PresentationRepository presentationRepository;

    public List<Presentation> getPresentation() {
        List<Presentation> presentations = presentationRepository.findAll();

        return presentations;
    }
}
