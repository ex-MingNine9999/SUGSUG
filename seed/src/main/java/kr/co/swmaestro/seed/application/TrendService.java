package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.Trend;
import kr.co.swmaestro.seed.domain.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendService {
    @Autowired
    TrendRepository trendRepository;

    public List<Trend> getTrend() {
        List<Trend> trends = trendRepository.findAll();

        return trends;
    }
}
