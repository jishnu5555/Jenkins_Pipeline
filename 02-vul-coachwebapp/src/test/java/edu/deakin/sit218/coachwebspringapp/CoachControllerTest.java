package edu.deakin.sit218.coachwebspringapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
        Mockito.verify(model).addAttribute(Mockito.anyString(), Mockito.anyString());
        assertTrue(viewName.equals("workout"), "The view name should be 'workout'");
    }
}
