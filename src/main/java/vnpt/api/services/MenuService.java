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
import vnpt.api.model.Menu;
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

	public PagedResponse<MenuInfo> getAll(UserPrincipal currentUser, int page, int size) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "name");
		Page<Menu> menusFirst = menuRepository.findAll(pageable);
		
		List<MenuInfo> menus = menusFirst.map(menu -> {
			return ModelMapper.mapMenuToMenuInfo(menu);
		}).getContent();

		return new PagedResponse<>(menus, menusFirst.getNumber(),
				menusFirst.getSize(), menusFirst.getTotalElements(), menusFirst.getTotalPages(), menusFirst.isLast());
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
