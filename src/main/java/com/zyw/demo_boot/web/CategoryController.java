package com.zyw.demo_boot.web;

import com.zyw.demo_boot.pojo.Category;
import com.zyw.demo_boot.service.CategoryService;
import com.zyw.demo_boot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add")
    public R add(String name){
        if(categoryService.add(name)){
            return R.ok();
        }
        return R.error("类别已存在");
    }
    @RequestMapping("/list")
    public R list(boolean isAll) {
        List<Category> categories = categoryService.findAll(isAll);
        return R.ok().put("categories",categories);

    }
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") Integer id) {
        if(categoryService.delete(id)){
            return R.ok();
        }
        return R.error("无法删除，类别中存在商品");

    }
    @RequestMapping("/update")
    public R update(Category c){
        if (categoryService.update(c)) {
            return R.ok();
        }
        return R.error("无法修改类别");
    }
}
