package tn.usine.categorymanager.service.mapper;

import org.mapstruct.*;
import tn.usine.categorymanager.domain.Category;
import tn.usine.categorymanager.service.dto.CategoryDTO;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {}
