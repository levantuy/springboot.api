package vnpt.api.util;

import java.util.List;
import java.util.stream.Collectors;

import vnpt.api.model.Menu;
import vnpt.api.model.User;
import vnpt.api.payload.*;

public class ModelMapper {
	public static MenuInfo mapMenuToMenuInfo(Menu menu) {
		MenuInfo result = new MenuInfo();
		result.setFeatureId(menu.getFeatureId());
		result.setIcon(menu.getIcon());
		result.setId(menu.getId());
		result.setName(menu.getName());;
		result.setParentId(menu.getParentId());
		result.setPosition(menu.getPosition());
		return result;
	}
	
	public static UserResponse mapUserToUserResponse(User user) {
		UserResponse result = new UserResponse();
		result.setEmail(user.getEmail());
		result.setId(user.getId());;
		result.setName(user.getName());
		result.setPassword(user.getPassword());
		
		List<RoleResponse> roleResponses = user.getRoles().stream().map(role -> {
			RoleResponse roleResponse = new RoleResponse();
			roleResponse.setId(role.getId());
			roleResponse.setFeatureId(role.getFeatureId());
			roleResponse.setName(role.getName());
            return roleResponse;
        }).collect(Collectors.toList());
		
		result.setRoles(roleResponses);
		result.setUsername(user.getUsername());
		return result;
	}
}
