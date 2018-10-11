package vnpt.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vnpt.api.payload.UserSummary;
import vnpt.api.security.CurrentUser;
import vnpt.api.security.UserPrincipal;
import vnpt.api.services.UserService;
import vnpt.api.util.AppConstants;
import vnpt.api.exception.ResourceNotFoundException;
import vnpt.api.model.User;
import vnpt.api.payload.UserProfile;
import vnpt.api.payload.UserResponse;
import vnpt.api.payload.ApiResponse;
import vnpt.api.payload.MenuInfo;
import vnpt.api.payload.PagedResponse;
import vnpt.api.payload.UserIdentityAvailability;
import vnpt.api.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('TEST')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
		return userSummary;
	}

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
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('TEST')")
	public PagedResponse<UserResponse> getAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){		
		return userService.getAll(currentUser, page, size);
	}
	
	@GetMapping("/users/byid/{id}")
	public UserProfile getUserProfileById(@PathVariable(value = "id") long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		long pollCount = 1;
		long voteCount = 1;

		UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(),
				pollCount, voteCount);

		return userProfile;
	}
	
	@PreAuthorize("hasRole('DELETE')")
	@DeleteMapping("/users/{id}")
	public ApiResponse deleteUser(@PathVariable(value = "id") long id) {
		userRepository.deleteById(id);
		return new ApiResponse(true, "delete success");
	}
	
	@PreAuthorize("hasRole('DELETE')")
	@DeleteMapping("/users/deleteCustom/{id}")
	public ApiResponse deleteCustom(@PathVariable(value = "id") long id) {
		userService.deleteCustomId(id);
		return new ApiResponse(true, "delete success");
	}
}
