package MicroservicioUsuarios.infrastructure.mappers;

import MicroservicioUsuarios.domain.model.UserModel;
import MicroservicioUsuarios.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    // MapStruct ahora SÍ ve los getters/setters → mapea automáticamente
    UserEntity modelToEntity(UserModel userModel);

    UserModel entityToModel(UserEntity userEntity);

    List<UserModel> entityListToModelList(List<UserEntity> users);
    List<UserEntity> modelListToEntityList(List<UserModel> users);
}
