package com.sudcom.gestion.backend.config;

import com.sudcom.gestion.backend.entities.User;
import com.sudcom.gestion.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.findByUsuario("admin").ifPresentOrElse(
            user -> {
                // Si el usuario existe pero la contraseña no está hasheada (empieza por $2a$ usualmente para BCrypt)
                if (!user.getPassword().startsWith("$2a$")) {
                    user.setPassword(passwordEncoder.encode("admin123"));
                    userRepository.save(user);
                }
            },
            () -> {
                User admin = User.builder()
                        .nombre("Administrador")
                        .usuario("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .rol("ADMIN")
                        .fechaRegistro(java.time.LocalDateTime.now())
                        .build();
                userRepository.save(admin);
            }
        );
    }
}
