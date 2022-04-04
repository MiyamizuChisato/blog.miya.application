package io.miya.blog.core.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.miya.blog.common.result.R;
import io.miya.blog.core.pojo.entity.BlogArticle;
import io.miya.blog.core.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author miya
 * @since 2022-04-04
 */
@RestController
@RequestMapping("/blog/article")
public class BlogArticleController {
    @Resource
    private BlogArticleService blogArticleService;
    @Value("${mybatis-plus.page.size}")
    private int size;

    @GetMapping("/get/{id}")
    public R getById(@PathVariable Integer id) {
        BlogArticle article = blogArticleService.getArticleById(id);
        return R.ok().data("article", article);
    }

    @GetMapping("/get/page/{current}")
    public R getListByTimeSort(@PathVariable Long current) {
        Page<BlogArticle> page = new Page<>(current, size);
        blogArticleService.getListByTimeSort(page);
        return R.ok().data("record",page.getRecords());
    }

}
