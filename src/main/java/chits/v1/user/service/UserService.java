package chits.v1.user.service;

import chits.v1.user.dto.LoginRequest;
import chits.v1.user.dto.LoginResponse;

public interface UserService {

	LoginResponse login(LoginRequest request);
}
