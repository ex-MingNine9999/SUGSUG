package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.StartupDetail;
import kr.co.swmaestro.seed.domain.StartupDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartupDetailService {
    @Autowired
    StartupDetailRepository startupDetailRepository;

    public List<StartupDetail> getStartupDetails() {
        List<StartupDetail> startupDetails = startupDetailRepository.findAll();

        return startupDetails;
    }

    public StartupDetail getStartupDetail(String s_id) throws IllegalAccessException {
        StartupDetail one = startupDetailRepository.findById(s_id)
                            .orElseThrow(() -> new IllegalAccessException("잘못된 기업 코드 입니다. corp_code=" + s_id));

        return one;
    }
}
