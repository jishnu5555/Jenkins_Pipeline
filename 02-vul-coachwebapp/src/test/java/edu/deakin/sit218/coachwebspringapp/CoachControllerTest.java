package edu.deakin.sit218.coachwebspringapp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public class CoachControllerTest {

    private CoachController coachController;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        coachController = new CoachController();
    }

    @Test
    public void testWorkout() {
        // Arrange
        String studentName = "John Doe";
        when(model.addAttribute("name", studentName)).thenReturn(model);

        // Act
        String viewName = coachController.workout(studentName, model);

        // Assert
        verify(model).addAttribute("name", studentName);
        // Verify that a message is added to the model
        assertTrue("Model should contain a message", 
            model.containsAttribute("message"));
        // Check that the returned view name is correct
        assertEquals("workout", viewName);
    }
}
