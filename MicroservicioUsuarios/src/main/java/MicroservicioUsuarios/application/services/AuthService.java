package MicroservicioUsuarios.application.services;

import com.nimbusds.jose.JOSEException;
import MicroservicioUsuarios.application.dto.request.SignUpRequest;
import MicroservicioUsuarios.application.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse signIn(String email, String password) throws JOSEException;

    void signUp(SignUpRequest request);
}
