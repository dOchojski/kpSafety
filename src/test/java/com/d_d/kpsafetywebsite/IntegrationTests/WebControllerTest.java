package com.d_d.kpsafetywebsite;

import com.d_d.kpsafetywebsite.controller.WebController;
import com.d_d.kpsafetywebsite.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(WebController.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @Test
    void indexShouldReturnIndexView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void handleContactFormShouldRedirect() throws Exception {
        mockMvc.perform(post("/contact")
                        .param("name", "Patryl Kowalski")
                        .param("email", "Kowalski@gmail.com")
                        .param("phone", "123456789")
                        .param("message", "Test"))
                .andExpect(status().is3xxRedirection());
    }

}