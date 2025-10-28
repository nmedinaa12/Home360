package MicroservicioUsuarios.configurations.beans;


import MicroservicioUsuarios.application.mappers.UserDtoMapper;
import MicroservicioUsuarios.application.services.UserService;
import MicroservicioUsuarios.application.services.impl.UserServiceImpl;
import MicroservicioUsuarios.domain.ports.in.UserServicePort;
import MicroservicioUsuarios.domain.ports.out.PasswordEncoderPort;
import MicroservicioUsuarios.domain.ports.out.UserPersistencePort;
import MicroservicioUsuarios.domain.usecases.UserUseCase;
import MicroservicioUsuarios.infrastructure.adapters.persistence.UserPersistenceAdapter;
import MicroservicioUsuarios.infrastructure.adapters.security.BCryptPasswordEncoderAdapter;
import MicroservicioUsuarios.infrastructure.mappers.UserEntityMapper;
import MicroservicioUsuarios.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final UserDtoMapper userDtoMapper;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoderPort passwordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return new BCryptPasswordEncoderAdapter(bCryptPasswordEncoder);
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort, PasswordEncoderPort passwordEncoder) {
        return new UserUseCase(userPersistencePort, passwordEncoder);
    }

    @Bean
    public UserService userService(UserServicePort userServicePort) {
        return new UserServiceImpl(userServicePort, userDtoMapper);
    }
}
