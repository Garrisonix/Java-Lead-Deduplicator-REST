package com.YellowDuck;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeduplicatorTest {
    @Test
    void testDeduplication() throws Exception {
        // Load the JSON file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("leads.json");
        assertNotNull(inputStream, "leads.json should exist in resources");

        String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        // Pass Json String into function
        List<Record> deduplicatedRecords = Deduplicator.deduplicateFromJsonString(json);

        // Print results
        deduplicatedRecords.forEach(record -> System.out.println(record.toString()));

        // Basic Assertion
        assertNotNull(deduplicatedRecords, "The deduplication result should not be null");

        // More stuff here...
    }

}