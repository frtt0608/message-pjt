package com.heon9u.rcs.study.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heon9u.rcs.study.common.TestWithDataRollback;
import com.heon9u.rcs.study.domain.master.dto.request.CreateMasterRequest;
import com.heon9u.rcs.study.domain.master.service.MasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;


@TestWithDataRollback
class MasterApiControllerTest {

    @InjectMocks
    MasterApiController masterApiController;

    @Mock
    MasterService masterService;

    ObjectMapper om = new ObjectMapper();

    MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(masterApiController).build();
    }

    @Test
    void create() throws Exception {
        CreateMasterRequest cmr = new CreateMasterRequest("testMaster");

        mockMvc.perform(
                    post("/api/master/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsString(cmr)))
                .andExpect(status().isOk());
    }

    @Test
    void list() throws Exception {

        mockMvc.perform(
                get("/api/master")
        ).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        long id = 1L;

        mockMvc.perform(
                get("/api/master/{id}", id)
        ).andExpect(status().isOk());
    }
}