package vnpt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vnpt.api.payload.MenuInfo;
import vnpt.api.payload.PagedResponse;
import vnpt.api.security.CurrentUser;
import vnpt.api.security.UserPrincipal;
import vnpt.api.services.MenuService;
import vnpt.api.util.AppConstants;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
	@Autowired
    private MenuService menuService;
	
	@GetMapping()
	@PreAuthorize("hasRole('TEST')")
	public List<MenuInfo> getAll(@CurrentUser UserPrincipal currentUser){		
		return menuService.getAll(currentUser);
	}
}
