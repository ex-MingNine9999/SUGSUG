package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.StartupDetail;
import kr.co.swmaestro.seed.domain.StartupYear;
import kr.co.swmaestro.seed.domain.StartupYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StartupYearService {
    @Autowired
    StartupYearRepository startupYearRepository;

    public List<StartupYear> getStartupYears() {
        List<StartupYear> startupYears = startupYearRepository.findAll();

        return startupYears;
    }

    public List<StartupYear> getStartupYearById(String s_id) throws IllegalAccessException {
        return startupYearRepository.yearBySid(s_id);
    }

}
