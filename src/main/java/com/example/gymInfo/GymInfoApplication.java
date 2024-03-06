package com.example.gymInfo;

import com.example.gymInfo.auth.AuthenticationRequest;
import com.example.gymInfo.auth.AuthenticationService;
import com.example.gymInfo.auth.RegisterRequest;
import com.example.gymInfo.exercise.ExerciseController;
import com.example.gymInfo.exercise.ExerciseRequest;
import com.example.gymInfo.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

import static com.example.gymInfo.user.Role.ADMIN;
import static com.example.gymInfo.user.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GymInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymInfoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service,
            ExerciseController controller
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("Willian")
                    .lastName("Pereira")
                    .email("admin@gmail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());


            var manager = RegisterRequest.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("manager@gmail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

            var exercise = ExerciseRequest.builder()
                    .name("Incline Bench Press")
                    .category("Chest")
                    .primaryMuscle(new String[]{"Upper Chest"})
                    .secondaryMuscles(new String[]{"Anterior Deltoid", "Triceps"})
                    .description("The best one for a big chest!")
                    .equipment("Smith Machine or Dumbbells")
                    .picture("https://newlife.com.cy/wp-content/uploads/2019/11/00471301-Barbell-Incline-Bench-Press_Chest_360.gif")
                    .build();
            System.out.println(controller.save(exercise));

            var exercise1 = ExerciseRequest.builder()
                    .name("Flat Bench Press")
                    .category("Chest")
                    .primaryMuscle(new String[]{"Pectoralis Major"})
                    .secondaryMuscles(new String[]{"Anterior Deltoid", "Triceps"})
                    .description("Great chest exercise")
                    .equipment("Barbell or Dumbbells")
                    .picture("https://www.inspireusafoundation.org/wp-content/uploads/2022/03/barbell-wide-grip-bench-press.gif")
                    .build();
            System.out.println(controller.save(exercise1));


            var exercise2 = ExerciseRequest.builder()
                    .name("Pull Up")
                    .category("Back")
                    .primaryMuscle(new String[]{"Latissimus Dorsi"})
                    .secondaryMuscles(new String[]{"Biceps", "Forearms"})
                    .description("The best one for a big back!")
                    .equipment("Pull-up bar")
                    .picture("https://www.inspireusafoundation.org/wp-content/uploads/2022/11/pull-up.gif")
                    .build();
            System.out.println(controller.save(exercise2));

            var exercise3 = ExerciseRequest.builder()
                    .name("Leg Extension")
                    .category("Legs")
                    .primaryMuscle(new String[]{"Quadriceps"})
                    .secondaryMuscles(new String[]{"Vastus Lateralis", "Vastus Medialis", "Vastus Intermedius"})
                    .description("Best exercise for a big quadriceps!")
                    .equipment("Machine")
                    .picture("https://media1.tenor.com/m/bqKtsSuqilQAAAAC/gym.gif")
                    .build();
            System.out.println(controller.save(exercise3));
        };
    }

}
