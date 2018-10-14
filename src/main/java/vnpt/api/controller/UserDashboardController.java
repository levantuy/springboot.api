package vnpt.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import vnpt.api.model.UserDashboard;
import vnpt.api.payload.ApiResponse;
import vnpt.api.payload.UserDashboardResponse;
import vnpt.api.repository.UserDashboardReposity;
import vnpt.api.security.CurrentUser;
import vnpt.api.security.UserPrincipal;
import vnpt.api.util.ModelMapper;

@RestController
@RequestMapping("/api/userdashboard")
public class UserDashboardController {
	@Autowired
	UserDashboardReposity userDashboardReposity;
	
	@GetMapping()
	@PreAuthorize("hasRole('USER')")
	public List<UserDashboardResponse> getAll(@CurrentUser UserPrincipal currentUser, 
			@RequestParam(value = "userid") long userid){
		List<UserDashboardResponse> response = new ArrayList<UserDashboardResponse>();
		List<UserDashboard> list = userDashboardReposity.findByUserId(userid);
		for (final UserDashboard userDashboard : list) {
			response.add(ModelMapper.mapUserDashboardToUserDashboardResponse(userDashboard));
		}	
		return response;
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('USER')")
	public ApiResponse postDashboard(@CurrentUser UserPrincipal currentUser, @RequestBody List<UserDashboardResponse> request){		
		for (final UserDashboardResponse info : request) {			
			UserDashboard dashboard = new UserDashboard(info.getId(), info.getUserId(), info.getX(), info.getY(), info.getH(), info.getW(), info.getI());
			userDashboardReposity.save(dashboard);
		}	
		
		return new ApiResponse(true, "User registered successfully");
	}
}
