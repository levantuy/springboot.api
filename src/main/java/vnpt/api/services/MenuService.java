package vnpt.api.services;

import java.util.ArrayList;
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
import vnpt.api.model.Menu;
import vnpt.api.payload.BadgeInfo;
import vnpt.api.payload.MenuChild;
import vnpt.api.payload.MenuInfo;
import vnpt.api.payload.PagedResponse;
import vnpt.api.repository.MenuRepository;
import vnpt.api.security.UserPrincipal;
import vnpt.api.util.AppConstants;
import vnpt.api.util.ModelMapper;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;

	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

	private Sort sortByPositionAsc() {
        return new Sort(Sort.Direction.ASC, "position");
    }
	
	public List<MenuInfo> getAll(UserPrincipal currentUser) {
		List<Menu> menusFirst = menuRepository.findAll(sortByPositionAsc());

		List<MenuInfo> menusParent = new ArrayList<MenuInfo>();
		for (final Menu menu : menusFirst) {
			if(menu.getParentId() == 0)
			{
				MenuInfo info = new MenuInfo();				
				info.setIcon(menu.getIcon());
				info.setId(menu.getId());
				info.setName(menu.getName());
				info.setParentId(menu.getParentId());
				info.setPosition(menu.getPosition());
				info.setUrl(menu.getFeature().getUrl());
				info.setChildrenBadge(new BadgeInfo("info", "NEW"));
				menusParent.add(info);			
			}			
		}
		
		for (final Menu menu : menusFirst) {
			for(final MenuInfo parent: menusParent)
			{
				if(menu.getParentId() == parent.getId())
				{
					MenuChild info = new MenuChild();					
					info.setIcon(menu.getIcon());
					info.setId(menu.getId());
					info.setName(menu.getName());
					info.setParentId(menu.getParentId());
					info.setPosition(menu.getPosition());
					info.setUrl(menu.getFeature().getUrl());
					parent.addChild(info);					
				}		
			}				
		}
		
		return menusParent;
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
