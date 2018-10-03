package vnpt.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vnpt.api.model.Feature;
import vnpt.api.model.Menu;
import vnpt.api.payload.FeatureResponse;
import vnpt.api.repository.FeatureRepository;
import vnpt.api.security.UserPrincipal;

@Service
public class FeatureService {
	@Autowired
	private FeatureRepository featureRepository;

	private static final Logger logger = LoggerFactory.getLogger(FeatureService.class);
	
	public FeatureResponse getAll(UserPrincipal currentUser, long id){
		Optional<Feature> feature = featureRepository.findById(id);		
		FeatureResponse response = new FeatureResponse();
		Feature featureInfo = feature.get();
		response.setFeatureId(featureInfo.getId());
		response.setName(featureInfo.getName());
		response.setUrl(featureInfo.getUrl());
		response.setFeatureGroupId(featureInfo.getFeatureGroupId());
		Menu test = featureInfo.getMenu();
	
		return response;
	}
}
