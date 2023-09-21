package test.api.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.api.testapi.entites.Sentiment;
import test.api.testapi.enums.TypeSentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
