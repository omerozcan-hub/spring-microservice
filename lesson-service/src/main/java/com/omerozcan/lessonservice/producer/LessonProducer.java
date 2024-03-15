package com.omerozcan.lessonservice.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omerozcan.lessonservice.model.Lesson;
import org.springframework.kafka.support.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class LessonProducer {


    @Autowired
    KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void sendLessonTopic(Lesson lesson) throws JsonProcessingException{

        Long id = lesson.getId();
        String value = objectMapper.writeValueAsString(lesson);

        CompletableFuture<SendResult<Long, String>> completableFuture = kafkaTemplate.sendDefault(id, value);

        completableFuture.thenApply(result ->{
            handleSuccess(id, value, result);
            return result;
        });

        completableFuture.exceptionally(throwable -> {
            handleFailure(throwable);
            return null;
        });
    }

    private void handleFailure(Throwable throwable) {
        System.out.println("Message gönderilirken hata alındı. Error :"+ throwable.getMessage());
    }

    private void handleSuccess(Long id, String value, SendResult<Long, String> result) {
        System.out.println("message gönserildi. Key :"+id+" Value :"+value+" Partition :"+result.getRecordMetadata().partition());
    }
}
