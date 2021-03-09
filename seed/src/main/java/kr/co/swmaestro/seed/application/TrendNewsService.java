package kr.co.swmaestro.seed.application;

import kr.co.swmaestro.seed.domain.TrendNews;
import kr.co.swmaestro.seed.domain.TrendNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendNewsService {
    @Autowired
    TrendNewsRepository trendNewsRepository;

    public List<TrendNews> getTrendNews() {
        List<TrendNews> trendNews = trendNewsRepository.findAll();

        return trendNews;
    }

}
