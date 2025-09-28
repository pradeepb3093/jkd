package com.java_kafka_docker.pb.dto.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "workItems")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WorkItemCollection {

    @Id
    private UUID _id;
    private String status;
}
