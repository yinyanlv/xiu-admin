package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.util.Generate;
import com.bugong.xiuadmin.dao.ArticleDao;
import com.bugong.xiuadmin.dto.ArticleDto;
import com.bugong.xiuadmin.entity.ArticleEntity;
import com.bugong.xiuadmin.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleDao<ArticleDto> articleDao;

    public PageData queryPage(ReqArgs reqArgs) {

        int total = articleDao.count(reqArgs);
        List<ArticleDto> list = articleDao.queryPage(reqArgs);

        return new PageData(list, total);
    }

    public void create(ArticleDto articleDto) {

        Date now = Generate.getNow();
        String username = UserContext.getUsername();

        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setId(Generate.getUUID());
        articleEntity.setTitle(articleDto.getTitle());
        articleEntity.setKeywords(articleDto.getKeywords());
        articleEntity.setDescription(articleDto.getDescription());
        articleEntity.setContent(articleDto.getContent());
        articleEntity.setBannerName(articleDto.getBannerName());
        articleEntity.setBannerOriginalName(articleDto.getBannerOriginalName());
        articleEntity.setThumbnailName(articleDto.getThumbnailName());
        articleEntity.setThumbnailOriginalName(articleDto.getThumbnailOriginalName());
        articleEntity.setStatus(articleDto.getStatus());
        articleEntity.setCategoryId(articleDto.getStatus());
        articleEntity.setSort(articleDto.getSort());
        articleEntity.setCreateBy(username);
        articleEntity.setCreateTime(now);
        articleEntity.setUpdateBy(username);
        articleEntity.setUpdateTime(now);
        articleRepository.save(articleEntity);
    }

    @Transactional
    public void update(ArticleEntity articleEntity) {

        articleRepository.getOne(articleEntity.getId()).update(articleEntity);
    }

    @Transactional
    public void delete(List<String> idList) {

        idList.forEach(id -> {
            articleRepository.deleteById(id);
        });
    }
}
