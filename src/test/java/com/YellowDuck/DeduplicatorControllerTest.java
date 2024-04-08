package com.YellowDuck;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeduplicatorController.class)
class DeduplicatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostLeadsJson() throws Exception {
        // Load the JSON file from the classpath
        File file = ResourceUtils.getFile("classpath:leads.json");
        String jsonContent = new String(Files.readAllBytes(file.toPath()));

        // Perform the POST request with the JSON file.
        mockMvc.perform(post("/deduplicate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andDo(print());
    }
}