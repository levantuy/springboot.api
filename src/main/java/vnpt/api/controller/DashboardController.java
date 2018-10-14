package vnpt.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vnpt.api.model.Dashboard;
import vnpt.api.payload.DashboardResponse;
import vnpt.api.repository.DashboardRepository;
import vnpt.api.security.CurrentUser;
import vnpt.api.security.UserPrincipal;
import vnpt.api.services.DashboardService;

@RestController
@RequestMapping("/api/dashboards")
public class DashboardController {
	@Autowired
	DashboardService dashboardService;
	
	
	@GetMapping()
	@PreAuthorize("hasRole('USER')")
	public List<DashboardResponse> getDashboards(@CurrentUser UserPrincipal currentUser){	
		long userId = currentUser.getId();
		List<DashboardResponse> response = new ArrayList<DashboardResponse>();
		List<Dashboard> list = dashboardService.getAll(userId);
		for (final Dashboard dashboard : list) {
			DashboardResponse item = new DashboardResponse(dashboard.getDescription(), dashboard.getName());
			response.add(item);
		}	
		return response;
	}
}
