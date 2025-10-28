package MicroservicioUsuarios.infrastructure.endpoints.rest;


import com.nimbusds.jose.JOSEException;
import MicroservicioUsuarios.application.dto.request.SignInRequest;
import MicroservicioUsuarios.application.dto.request.SignUpRequest;
import MicroservicioUsuarios.application.dto.response.LoginResponse;
import MicroservicioUsuarios.application.dto.response.UserResponse;
import MicroservicioUsuarios.application.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticación", description = "Operaciones de autenticación y registro de usuarios")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-in")
    @Operation(summary = "Iniciar sesión de usuario",
            description = "Autentica a un usuario con su correo electrónico y contraseña. Devuelve un token de acceso JWT junto con detalles del token y el perfil del usuario.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Autenticación exitosa",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LoginResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida (ej. campos faltantes o formato incorrecto)"),
                    @ApiResponse(responseCode = "401", description = "No autorizado (credenciales incorrectas o usuario inactivo)")
            })
    public ResponseEntity<LoginResponse> signIn(@Valid @RequestBody SignInRequest loginRequest) throws JOSEException {
        LoginResponse response = authService.signIn(loginRequest.email(), loginRequest.password());
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/sign-up")
}