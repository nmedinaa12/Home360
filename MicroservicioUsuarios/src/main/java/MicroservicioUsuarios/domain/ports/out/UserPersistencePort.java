package MicroservicioUsuarios.domain.ports.out;

import MicroservicioUsuarios.domain.model.UserFilterModel;
import MicroservicioUsuarios.domain.model.UserModel;
import MicroservicioUsuarios.domain.utils.pagination.PagedResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    UserModel saveUser(UserModel userModel);

    Optional<UserModel> getUserById(Long id);

    Optional<UserModel> getUserByEmail(String email);

    Optional<UserModel> getUserByDocumentId(String documentId);

    boolean existsByEmail(String email);

    boolean existsByDocumentId(String documentId);

    PagedResult<UserModel> getAllUsers(UserFilterModel filter);

    void deleteUser(Long id);

}