package MicroservicioUsuarios.application.services;

import MicroservicioUsuarios.application.dto.request.RegisterUserRequest;
import MicroservicioUsuarios.application.dto.request.filters.UserFilterRequest;
import MicroservicioUsuarios.application.dto.response.PaginatedResponse;
import MicroservicioUsuarios.application.dto.response.UserResponse;
import MicroservicioUsuarios.domain.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse getUserById(Long id);

    Optional<UserModel> getUserByEmail(String email);

    UserResponse saveUser(RegisterUserRequest request);

    UserResponse updateUser(Long id, RegisterUserRequest request);

    void deleteUser(Long id);

    PaginatedResponse<UserResponse> getAllUsers(UserFilterRequest filter);
}