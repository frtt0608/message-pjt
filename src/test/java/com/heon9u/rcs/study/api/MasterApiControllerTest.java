package com.heon9u.rcs.study.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MasterApiControllerTest {

    @InjectMocks
    MasterApiController masterApiController;

    MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(masterApiController).build();
    }

    @Test
    void list() throws Exception {

        mockMvc.perform(get("/api/master"))
                .andExpect(status().isOk());
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }
}