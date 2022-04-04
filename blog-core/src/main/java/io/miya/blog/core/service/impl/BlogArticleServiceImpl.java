package io.miya.blog.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.miya.blog.core.mapper.ArticleTagMapper;
import io.miya.blog.core.pojo.entity.ArticleTag;
import io.miya.blog.core.pojo.entity.BlogArticle;
import io.miya.blog.core.mapper.BlogArticleMapper;
import io.miya.blog.core.service.BlogArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author miya
 * @since 2022-04-04
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

    @Resource
    private ArticleTagMapper articleTagMapper;

    @Override
    public Page<BlogArticle> getListByTimeSort(Page<BlogArticle> page) {
        QueryWrapper<BlogArticle> queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        baseMapper.selectPage(page, queryWrapper);
        if (page.getRecords().size()>0){
            page.getRecords().forEach(record->setTags(record));
        }
        return page;
    }

    @Override
    public BlogArticle getArticleById(Integer id) {
        BlogArticle article = super.getById(id);
        if (article != null) {
            setTags(article);
        }
        return article;
    }

    public void setTags(BlogArticle article) {
        String labels = article.getArticleLabels();
        String[] tags = labels.split(",");
        List<Integer> ids = new ArrayList<>();
        for (String tag : tags) {
            Integer id = Integer.parseInt(tag);
            ids.add(id);
        }
        List<ArticleTag> articleTags = articleTagMapper.selectBatchIds(ids);
        article.setTags(new HashSet<>());
        articleTags.forEach(articleTag -> article.getTags().add(articleTag.getTag()));
    }
}
