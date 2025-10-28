package MicroservicioUsuarios.application.mappers;

import MicroservicioUsuarios.application.dto.request.RegisterUserRequest;
import MicroservicioUsuarios.application.dto.response.UserResponse;
import MicroservicioUsuarios.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserDtoMapper {

    UserModel requestToModel(RegisterUserRequest request);



    UserResponse modelToResponse(UserModel userModel);

    List<UserResponse> modelListToResponseList(List<UserModel> users);
}
