package com.bugong.xiuadmin.service;

import com.bugong.xiuadmin.common.context.UserContext;
import com.bugong.xiuadmin.common.query.ReqArgs;
import com.bugong.xiuadmin.common.response.PageData;
import com.bugong.xiuadmin.common.util.Generate;
import com.bugong.xiuadmin.dao.CategoryDao;
import com.bugong.xiuadmin.dto.CategoryDto;
import com.bugong.xiuadmin.entity.CategoryEntity;
import com.bugong.xiuadmin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryDao<CategoryDto> categoryDao;

    public PageData queryPage(ReqArgs reqArgs) {
        int total = categoryDao.count(reqArgs);

        List<CategoryDto> list = categoryDao.queryPage(reqArgs);

        return new PageData(list, total);
    }

    public void create(CategoryDto categoryDto) {

        Date now = Generate.getNow();
        String username = UserContext.getUsername();

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(Generate.getUUID());
        categoryEntity.setName(categoryDto.getName());
        categoryEntity.setKeywords(categoryDto.getKeywords());
        categoryEntity.setDescription(categoryDto.getDescription());
        categoryEntity.setContent(categoryDto.getContent());
        categoryEntity.setBannerName(categoryDto.getBannerName());
        categoryEntity.setBannerOriginalName(categoryDto.getBannerOriginalName());
        categoryEntity.setThumbnailName(categoryDto.getThumbnailName());
        categoryEntity.setThumbnailOriginalName(categoryDto.getThumbnailOriginalName());
        categoryEntity.setStatus(categoryDto.getStatus());
        categoryEntity.setSort(categoryDto.getSort());
        categoryEntity.setCreateBy(username);
        categoryEntity.setCreateTime(now);
        categoryEntity.setUpdateBy(username);
        categoryEntity.setUpdateTime(now);

        categoryRepository.save(categoryEntity);
    }

    @Transactional
    public void update(CategoryEntity categoryEntity) {

        categoryRepository.getOne(categoryEntity.getId()).update(categoryEntity);
    }

    @Transactional
    public void delete(List<String> idList) {

        idList.forEach(id -> {
            categoryRepository.deleteById(id);
        });
    }
}
