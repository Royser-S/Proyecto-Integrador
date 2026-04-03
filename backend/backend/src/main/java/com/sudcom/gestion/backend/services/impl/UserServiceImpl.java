package com.sudcom.gestion.backend.services.impl;

import com.sudcom.gestion.backend.dtos.requests.UserRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.UserResponseDTO;
import com.sudcom.gestion.backend.entities.User;
import com.sudcom.gestion.backend.repositories.UserRepository;
import com.sudcom.gestion.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return userRepository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    @Override
    public UserResponseDTO save(UserRequestDTO dto) {
        User entity = User.builder()
                .nombre(dto.getNombre())
                .usuario(dto.getUsuario())
                .rol(dto.getRol())
                .password(passwordEncoder.encode(dto.getPassword() != null ? dto.getPassword() : "default123"))
                .fechaRegistro(java.time.LocalDateTime.now())
                .build();
        
        User saved = userRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO findByUsuario(String usuario) {
        return userRepository.findByUsuario(usuario).map(this::toResponseDTO).orElse(null);
    }

    private UserResponseDTO toResponseDTO(User entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getUsuario(),
                entity.getRol(),
                entity.getFechaRegistro()
        );
    }
}
