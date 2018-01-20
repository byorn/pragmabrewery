package com.pragmabrewery.restservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * This Test Suite, focuses on the Checkout.java  total() method
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestSensorService {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testWhenThreeATVsAndOneVGAScanned() throws Exception {

        this.mockMvc.perform(get("/getBeerTemperature")).andDo(print()).andExpect(status().isOk());
              // .andExpect(jsonPath("$.data").value("Pilsner"));

    }



}
