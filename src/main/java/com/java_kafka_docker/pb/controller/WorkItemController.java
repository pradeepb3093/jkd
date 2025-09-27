package com.java_kafka_docker.pb.controller;

import com.java_kafka_docker.pb.dto.response.WorkItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/workItem")
public class WorkItemController {

    @GetMapping
    public ResponseEntity<WorkItemResponse> getWorkItems() {
        WorkItemResponse response = new WorkItemResponse("Success");
        return ResponseEntity.ok(response);
    }
}
