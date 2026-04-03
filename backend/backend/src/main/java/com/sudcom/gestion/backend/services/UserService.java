package com.sudcom.gestion.backend.services;

import com.sudcom.gestion.backend.dtos.requests.UserRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.UserResponseDTO;
import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO findById(Long id);
    UserResponseDTO save(UserRequestDTO userDTO);
    void delete(Long id);
    UserResponseDTO findByUsuario(String usuario);
}
