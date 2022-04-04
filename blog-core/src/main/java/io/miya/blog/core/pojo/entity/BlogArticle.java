package io.miya.blog.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author miya
 * @since 2022-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BlogArticle对象", description = "")
public class BlogArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer articleType;

    private String articleTitle;

    private String articleDetails;

    private String articleImage;
    @JsonIgnore
    private String articleLabels;

    private Integer articleWatch;

    private Integer articleComment;

    private Integer articleLike;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableLogic
    @TableField("is_deleted")
    private Integer deleted;

    @TableField(exist = false)
    private Set<String> tags;
}
