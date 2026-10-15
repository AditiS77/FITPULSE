package com.fitness.ADT.activityservice.controller;

import com.fitness.ADT.activityservice.dto.ActivityRequest;
import com.fitness.ADT.activityservice.dto.ActivityResponse;
import com.fitness.ADT.activityservice.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity (@RequestBody ActivityRequest request, @RequestHeader("X-user-ID") String userId) {
        request.setUserId(userId);
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivity (@RequestHeader("X-user-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
