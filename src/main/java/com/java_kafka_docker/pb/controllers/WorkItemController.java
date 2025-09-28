package com.java_kafka_docker.pb.controllers;

import com.java_kafka_docker.pb.dto.modal.WorkItemCollection;
import com.java_kafka_docker.pb.dto.request.WorkItemRequest;
import com.java_kafka_docker.pb.services.WorkItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/workItem")
@Slf4j
public class WorkItemController {

    private final WorkItemService workItemService;

    @Autowired
    public WorkItemController(WorkItemService workItemService) {
        this.workItemService = workItemService;
    }

    @GetMapping
    public ResponseEntity<List<WorkItemCollection>> getWorkItems() {
        log.info("getWorkItems");
        try {
            List<WorkItemCollection> response = workItemService.getAllWorkItems();
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<WorkItemCollection> postWorkItems(@RequestBody WorkItemRequest requestBody) {
        log.info("postWorkItems");
        try {
            WorkItemCollection response = workItemService.createWorkItem(requestBody);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
