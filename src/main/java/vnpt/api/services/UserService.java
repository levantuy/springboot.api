package vnpt.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vnpt.api.exception.BadRequestException;
import vnpt.api.model.User;
import vnpt.api.payload.PagedResponse;
import vnpt.api.payload.UserResponse;
import vnpt.api.repository.UserRepository;
import vnpt.api.security.UserPrincipal;
import vnpt.api.util.AppConstants;
import vnpt.api.util.ModelMapper;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	public PagedResponse<UserResponse> getAll(UserPrincipal currentUser, int page, int size) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "name");
		Page<User> users = userRepository.findAll(pageable);
		
		List<UserResponse> usersMap = users.map(user -> {
			return ModelMapper.mapUserToUserResponse(user);
		}).getContent();

		return new PagedResponse<>(usersMap, users.getNumber(),
				users.getSize(), users.getTotalElements(), users.getTotalPages(), users.isLast());
	}

	private void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
