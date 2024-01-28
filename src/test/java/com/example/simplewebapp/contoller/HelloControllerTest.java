package com.example.simplewebapp.contoller;

import com.example.simplewebapp.controller.HelloController;
import com.example.simplewebapp.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    void hello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();

        String viewName = controller.hello(model);

        assertEquals("index", viewName);
        Message message = (Message) model.getAttribute("message");
        assert message != null;
        assertEquals("Hello, Spring Boot!", message.getContent());
    }
}
