package io.miya.blog.core.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.miya.blog.core.pojo.entity.BlogArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author miya
 * @since 2022-04-04
 */
public interface BlogArticleService extends IService<BlogArticle> {
    Page<BlogArticle> getListByTimeSort(Page<BlogArticle> page);

    BlogArticle getArticleById(Integer id);
}
