package com.YellowDuck;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Deduplicator {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Processes a JSON string containing records, de-duplicates them, and returns a list of de-duplicated records.
     *
     * @param jsonString JSON string representing the list of records.
     * @return List of de-duplicated Record objects.
     * @throws Exception if there's an issue with JSON processing.
     */
    public static List<Record> deduplicateFromJsonString(String jsonString) throws Exception {
        // Parse the JSON string into a List of Record objects
        Map<String, List<Record>> data = mapper.readValue(jsonString, new TypeReference<>() {
        });
        List<Record> records = data.get("leads");

        // Deduplicate records
        return deduplicate(records);
    }

    private static List<Record> deduplicate(List<Record> records) {
        // De-duplicate by id, preferring latest Entry Date.
        Map<String, Record> latestById = records.stream()
                .collect(Collectors.toMap(
                        Record::get_id,
                        Function.identity(),
                        (existing, candidate) -> candidate.getEntryDate()
                                .compareTo(existing.getEntryDate()) >= 0 ? candidate : existing));

        // De-duplicate by email, preferring latest Entry Date.
        Map<String, Record> latestByEmail = records.stream()
                .collect(Collectors.toMap(
                        Record::getEmail,
                        Function.identity(),
                        (existing, candidate) -> candidate.getEntryDate()
                                .compareTo(existing.getEntryDate()) >= 0 ? candidate : existing));

        // Merge maps
        return latestById.values().stream()
                .filter(record -> latestByEmail.containsKey(record.getEmail()))
                .sorted(Comparator.comparing(Record::getEntryDate))
                .collect(Collectors.toList());
    }
}
