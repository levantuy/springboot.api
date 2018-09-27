package vnpt.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vnpt.api.exception.ResourceNotFoundException;
import vnpt.api.model.User;
import vnpt.api.payload.UserProfile;
import vnpt.api.payload.UserIdentityAvailability;
import vnpt.api.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/users/{username}")
	public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

		long pollCount = 1;
		long voteCount = 1;

		UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(),
				pollCount, voteCount);

		return userProfile;
	}
}
