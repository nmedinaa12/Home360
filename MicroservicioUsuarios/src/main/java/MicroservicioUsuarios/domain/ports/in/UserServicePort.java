package MicroservicioUsuarios.domain.ports.in;

import MicroservicioUsuarios.application.dto.request.filters.UserFilterRequest;
import MicroservicioUsuarios.domain.model.UserFilterModel;
import MicroservicioUsuarios.domain.model.UserModel;
import MicroservicioUsuarios.domain.utils.pagination.PagedResult;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserServicePort {
    UserModel registerUser(UserModel userModel);


    PagedResult<UserModel> getAllUsers(UserFilterModel filter);

    Optional<UserModel> getUserById(Long id);

    Optional<UserModel> getUserByEmail(String email);

    Optional<UserModel> getUserByDocumentId(String documentId);

    boolean existsByEmail(String email);

    boolean existsByDocumentId(String documentId);

    boolean deleteUser(Long id);
}