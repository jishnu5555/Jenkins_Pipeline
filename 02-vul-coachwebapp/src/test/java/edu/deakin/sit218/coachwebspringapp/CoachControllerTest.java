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
        Mockito.verify(model).addAttribute("name", studentName);
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.anyString(), Mockito.anyString()); // Verify that it is called once.
        assertEquals("workout", viewName, "The view name should be 'workout'");
    }
}
