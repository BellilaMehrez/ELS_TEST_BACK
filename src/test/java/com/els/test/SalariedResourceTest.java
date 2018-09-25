package com.els.test;

import com.els.test.domain.Salaried;
import com.els.test.repository.SalariedRepository;
import com.els.test.service.SalariedService;
import com.els.test.web.rest.SalariedResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SalariedResourceTest {

    @Mock
    private SalariedRepository salariedRepository;

    @Mock
    private SalariedService salariedService;

    @InjectMocks
    private SalariedResource salariedResource;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(salariedResource)
                .build();
    }

    @Test
    public void getDistinctByKeyTest() throws Exception {
        //given
        String key = "fullName";
        Salaried salaried = new Salaried("1", "Mehrez Bellila", "france", "Salaried", "Description");
        List<Salaried> salarieds = new ArrayList<>();
        salarieds.add(salaried);

        // when
        when(salariedService.getDistinctByKey(any())).thenReturn(salarieds);

        // then
        mockMvc.perform(get("/api/salaried/getDistinctByKey/" + key))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(salariedService, times(1)).getDistinctByKey(any());
        verifyNoMoreInteractions(salariedService);
    }

    @Test
    public void getAllSalarieds() throws Exception {
        //given
        Salaried salaried = new Salaried("1", "Mehrez Bellila", "france", "Salaried", "Description");
        List<Salaried> salarieds = new ArrayList<>();
        salarieds.add(salaried);

        // when
        when(salariedService.getAllSalarieds()).thenReturn(salarieds);

        // then
        mockMvc.perform(get("/api/salaried/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(salariedService, times(1)).getAllSalarieds();
        verifyNoMoreInteractions(salariedService);
    }
}
