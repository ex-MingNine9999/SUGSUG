package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.Startup;
import kr.co.swmaestro.seed.domain.StartupDetail;
import kr.co.swmaestro.seed.domain.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartupService {

    @Autowired
    StartupRepository startupRepository;

    public List<Startup> getStartups() {
        List<Startup> startups = startupRepository.findAll(Sort.by("hits"));
        return startups;
    }

    public Startup getStartupBySid(String s_id) throws IllegalAccessException{
        Startup one = startupRepository.findById(s_id)
                .orElseThrow(() -> new IllegalAccessException("잘못된 기업 코드 입니다. corp_code=" + s_id));

        return one;
    }
}
