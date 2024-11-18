package com.heon9u.rcs.study.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heon9u.rcs.study.common.TestWithDataRollback;
import com.heon9u.rcs.study.domain.rcs.dto.request.CreateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.dto.request.UpdateRcsRequest;
import com.heon9u.rcs.study.domain.rcs.service.RcsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestWithDataRollback
class RcsApiControllerTest {

    @InjectMocks
    RcsApiController rcsApiController;

    @Mock
    RcsService rcsService;

    ObjectMapper om = new ObjectMapper();

    MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(rcsApiController).build();
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(
                get("/api/rcs")
        ).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        CreateRcsRequest crr = CreateRcsRequest.builder()
                .rcsName("testRcs")
                .maxCount(100L)
                .masterId(1L)
                .build();

        mockMvc.perform(
                post("/api/rcs/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(crr))
        ).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        long id = 1L;

        mockMvc.perform(
                get("/api/rcs/{id}", id)
        ).andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        long id = 1L;
        UpdateRcsRequest urr = UpdateRcsRequest.builder()
                .maxCount(200L)
                .rcsName("testRcs2")
                .build();

        mockMvc.perform(
                put("/api/rcs/update/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(urr))
        ).andExpect(status().isOk());
    }
}