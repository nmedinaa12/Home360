package MicroservicioUsuarios.infrastructure.adapters.persistence;

import MicroservicioUsuarios.domain.model.UserFilterModel;
import MicroservicioUsuarios.domain.model.UserModel;
import MicroservicioUsuarios.domain.ports.out.UserPersistencePort;
import MicroservicioUsuarios.domain.utils.pagination.PagedResult;
import MicroservicioUsuarios.domain.utils.pagination.PaginationUtils;
import MicroservicioUsuarios.infrastructure.entities.UserEntity;
import MicroservicioUsuarios.infrastructure.mappers.UserEntityMapper;
import MicroservicioUsuarios.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserModel saveUser(UserModel userModel) {
        UserEntity userEntity = userEntityMapper.modelToEntity(userModel);
        UserEntity savedUser = userRepository.save(userEntity);
        return userEntityMapper.entityToModel(savedUser);
    }


    @Override
    public PagedResult<UserModel> getAllUsers(UserFilterModel filter) {

        var pageable = PaginationUtils.createPageable(
                filter.page(),
                filter.size(),
                filter.sortField(),
                filter.direction()
        );

        var page = userRepository.findAll(pageable);
        return PaginationUtils.toPagedResult(page.map(userEntityMapper::entityToModel));
    }

    @Override
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id).map(userEntityMapper::entityToModel);
    }

    @Override
    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(userEntityMapper::entityToModel);
    }

    @Override
    public Optional<UserModel> getUserByDocumentId(String documentId) {
        return userRepository.findByDocumentId(documentId).map(userEntityMapper::entityToModel);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByDocumentId(String documentId) {
        return userRepository.existsByDocumentId(documentId);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}