package tn.usine.articlemanager.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.usine.articlemanager.client.CategoryFeignClient;
import tn.usine.articlemanager.domain.Article;
import tn.usine.articlemanager.repository.ArticleRepository;
import tn.usine.articlemanager.service.dto.ArticleDTO;
import tn.usine.articlemanager.service.mapper.ArticleMapper;

/**
 * Service Implementation for managing {@link Article}.
 */
@Service
public class ArticleService {

    private final Logger log = LoggerFactory.getLogger(ArticleService.class);

    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    private final CategoryFeignClient categoryFeignClient;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper, CategoryFeignClient categoryFeignClient) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
        this.categoryFeignClient = categoryFeignClient;
    }

    /**
     * Save a article.
     *
     * @param articleDTO the entity to save.
     * @return the persisted entity.
     */
    public ArticleDTO save(ArticleDTO articleDTO) {
        log.debug("Request to save Article : {}", articleDTO);
        Article article = articleMapper.toEntity(articleDTO);
        article = articleRepository.save(article);
        return articleMapper.toDto(article);
    }

    /**
     * Update a article.
     *
     * @param articleDTO the entity to save.
     * @return the persisted entity.
     */
    public ArticleDTO update(ArticleDTO articleDTO) {
        log.debug("Request to update Article : {}", articleDTO);
        Article article = articleMapper.toEntity(articleDTO);
        article = articleRepository.save(article);
        return articleMapper.toDto(article);
    }

    /**
     * Partially update a article.
     *
     * @param articleDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ArticleDTO> partialUpdate(ArticleDTO articleDTO) {
        log.debug("Request to partially update Article : {}", articleDTO);

        return articleRepository
            .findById(articleDTO.getId())
            .map(existingArticle -> {
                articleMapper.partialUpdate(existingArticle, articleDTO);

                return existingArticle;
            })
            .map(articleRepository::save)
            .map(articleMapper::toDto);
    }

    /**
     * Get all the articles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<ArticleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Articles");
        return articleRepository.findAll(pageable).map(articleMapper::toDto);
    }

    /**
     * Get one article by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<ArticleDTO> findOne(String id) {
        log.debug("Request to get Article : {}", id);
        Optional<ArticleDTO> oadto = articleRepository.findById(id).map(articleMapper::toDto);
        oadto.get().setCategoryDTO(categoryFeignClient.getCategory(oadto.get().getIdcategory()).getBody());
        return oadto;
    }

    /**
     * Delete the article by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Article : {}", id);
        articleRepository.deleteById(id);
    }
}
