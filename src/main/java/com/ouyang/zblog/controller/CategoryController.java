package com.ouyang.zblog.controller;

import com.ouyang.zblog.service.CategoryService;
import com.ouyang.zblog.vo.ArticleCustom;
import com.ouyang.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 展示的分类controller
 * FILE: ArchiveController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/5/8
 * TIME: 15:15
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    /**
     * 获取某个标签的分页文章
     * @param model
     * @param pager
     * @param categoryId
     * @return
     */
    @RequestMapping("/load/{categoryId}")
    public String loadArticleByCategory(Model model, Pager pager, @PathVariable Integer categoryId){
        List<ArticleCustom> articleList = categoryService.loadArticleByCategory(pager,categoryId);
        if (!articleList.isEmpty()){
            model.addAttribute("articleList",articleList);
            model.addAttribute("pager",pager);
            model.addAttribute("categoryName",articleList.get(0).getCategoryName());
        }
        return "blog/part/categorySummary";
    }



}