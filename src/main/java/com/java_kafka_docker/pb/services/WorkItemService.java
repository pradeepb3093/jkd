package com.java_kafka_docker.pb.services;

import com.java_kafka_docker.pb.dto.modal.WorkItemCollection;
import com.java_kafka_docker.pb.dto.request.WorkItemRequest;
import com.java_kafka_docker.pb.exceptions.CustomMongoDbError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class WorkItemService {

    @Value("${app.db.workItem.collection.name}")
    private String collectionName;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public WorkItemService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<WorkItemCollection> getAllWorkItems() {
        return mongoTemplate.findAll(WorkItemCollection.class);
    }

    public WorkItemCollection createWorkItem(WorkItemRequest workItemRequest) {
        WorkItemCollection workItemCollection = WorkItemCollection.builder()
                ._id(UUID.randomUUID())
                .status(workItemRequest.getStatus())
                .build();
        try {
            mongoTemplate.save(workItemCollection, collectionName);
            return workItemCollection;
        }catch (Exception e){
            log.error("Db save failed with error: {}", e.getMessage());
            throw new CustomMongoDbError("work item creation failed due to a downtime, please try again later");
        }
    }
}
