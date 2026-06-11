package com.fitness.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.activityservice.model.ActivityType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ActivityRequest {

    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetric;
}
