package com.fitness.activityservice.service;

import org.springframework.stereotype.Service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRespository activityRespository;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setUserId(activityRequest.getUserId());
        activity.setType(activityRequest.getActivityType());
        activity.setDuration(activityRequest.getDuration());
        activity.setCaloriesBurned(activityRequest.getCaloriesBurned());
        activity.setStartTime(activityRequest.getStartTime());
        activity.setAdditionalMetric(activityRequest.getAdditionalMetric());

        Activity savedActivity = activityRespository.save(activity);

        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setAdditionalMetric(savedActivity.getAdditionalMetric());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());

        return activityResponse;
    }
}
