package tn.usine.articlemanager.service.mapper;

import org.mapstruct.*;
import tn.usine.articlemanager.domain.Article;
import tn.usine.articlemanager.service.dto.ArticleDTO;

/**
 * Mapper for the entity {@link Article} and its DTO {@link ArticleDTO}.
 */
@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {}
