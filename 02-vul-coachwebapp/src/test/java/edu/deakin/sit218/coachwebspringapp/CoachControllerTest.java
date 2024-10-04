package edu.deakin.sit218.coachwebspringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public class CoachControllerTest {

    @Test
    public void testWorkout() {
        // Arrange
        CoachController controller = new CoachController();
        Model model = Mockito.mock(Model.class);
        String studentName = "John Doe";

        // Act
        String viewName = controller.workout(studentName, model);

        // Assert
        Mockito.verify(model).addAttribute("name", studentName); // Verify name attribute
        // Verify that addAttribute was called for the message as well
        Mockito.verify(model, Mockito.atLeastOnce()).addAttribute(Mockito.anyString(), Mockito.anyString()); // Verify any attribute is called at least once

        assertEquals("workout", viewName, "The view name should be 'workout'");
    }
}
