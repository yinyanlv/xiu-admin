package com.bugong.xiuadmin.repository;

import com.bugong.xiuadmin.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
}
