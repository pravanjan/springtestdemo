package action;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(value=SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/test-servlet.xml")

public class TodoControllerTest {
    @Autowired
    private WebApplicationContext wac;



    private MockMvc mockMvc;




    @Before
    public void setup (){

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void createtaskTestforNotfound () throws Exception {
        this.mockMvc.perform(get("/todo/createTask/daily/").accept(MediaType.parseMediaType("application/json"))).andExpect(status().isNotFound());
    }

    @Test
    public void createtaskTestforvalid_with_valide_url() throws Exception {
        Map<String,Object> resultMap  = new HashMap<>();
       // when(todoHelper.createTask("type")).thenReturn(resultMap);
        this.mockMvc.perform(get("/todo/createtask/test/")).andExpect(status().is(200));
    }

    @Test
    public void createtaskTestfor_validating_status() throws Exception {
        this.mockMvc.perform(get("/todo/createtask/test/")).andExpect(status().is(200))
                .andExpect(jsonPath("$.status").value(true));
    }


}
