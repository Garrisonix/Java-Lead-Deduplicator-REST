package com.YellowDuck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeduplicatorController {

    @PostMapping("/deduplicate")
    public ResponseEntity<List<Record>> deduplicateLeads(@RequestBody String jsonInput) {
        try {
            List<Record> deduplicatedRecords = Deduplicator.deduplicateFromJsonString(jsonInput);
            return ResponseEntity.ok(deduplicatedRecords);
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.badRequest().build();
        }
    }
}