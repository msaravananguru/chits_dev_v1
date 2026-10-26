package chits.v1.user.service;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chits.v1.common.exception.BusinessException;
import chits.v1.user.dto.LoginRequest;
import chits.v1.user.dto.LoginResponse;
import chits.v1.user.entity.User;
import chits.v1.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String INVALID_LOGIN = "Invalid username or password";

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Dummy login: plain-text password match, no token. Security comes later.
	 */
	@Override
	@Transactional
	public LoginResponse login(LoginRequest request) {
		User user = userRepository.findByUsername(request.getUsername().trim())
				.orElseThrow(() -> new BusinessException(INVALID_LOGIN, HttpStatus.UNAUTHORIZED));

		if (!user.getPassword().equals(request.getPassword())) {
			throw new BusinessException(INVALID_LOGIN, HttpStatus.UNAUTHORIZED);
		}
		if (!"ACTIVE".equals(user.getStatus())) {
			throw new BusinessException("Your account is inactive. Contact the owner.", HttpStatus.FORBIDDEN);
		}

		user.setLastLoginAt(LocalDateTime.now());
		userRepository.save(user);

		return new LoginResponse(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
	}
}
