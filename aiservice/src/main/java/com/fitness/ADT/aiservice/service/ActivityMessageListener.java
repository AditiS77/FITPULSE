package com.fitness.ADT.aiservice.service;
// this file will listen if data is sent to the kafka or not, kindof consumer

import com.fitness.ADT.aiservice.model.Activity;
import com.fitness.ADT.aiservice.model.Recommendation;
import com.fitness.ADT.aiservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    private final ActivityAIService activityAIService;
    private final RecommendationRepository recommendationRepository;

    //@Value("${kafka.topic.name}")
    //private String topicName;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "activity-processor-group" )
    public void processActivity(Activity activity) {
        log.info("Received Activity for processing: {}", activity.getUserId());
        Recommendation recommendation = activityAIService.generateRecommendation(activity);
        recommendationRepository.save(recommendation);

    }
}
