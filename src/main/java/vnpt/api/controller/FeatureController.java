package vnpt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vnpt.api.payload.FeatureResponse;
import vnpt.api.security.CurrentUser;
import vnpt.api.security.UserPrincipal;
import vnpt.api.services.FeatureService;
import vnpt.api.util.AppConstants;

@RestController
@RequestMapping("/api/features")
public class FeatureController {
	@Autowired
    private FeatureService featureService;
	
	@GetMapping()
	@PreAuthorize("hasRole('USER')")
	public FeatureResponse getAll(@CurrentUser UserPrincipal currentUser, 
			@RequestParam(value = "id", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) long id){		
		return featureService.getAll(currentUser, id);
	}
}
