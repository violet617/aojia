package com.zyw.demo_boot.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyw.demo_boot.pojo.Product;
import com.zyw.demo_boot.service.ProductService;
import com.zyw.demo_boot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RequestMapping("product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //获取yamal配置的属性
    @Value("${upload.file-path}")
    private String UPLOAD_PATH;
    @Value("${upload.img-server-path}")
    private String IMG_SERVER_PATH;

    @PostMapping("/add")
    public R add(Product p){
        if(productService.add(p)){
            return R.ok();
        }
        return R.error("商品名称已存在");
    }

    @RequestMapping("/find/{id}")
    public R find(@PathVariable("id") Integer id){
        return R.ok().put("product",productService.findById(id));
    }

    @PostMapping("/update")
    public R update(Product p){
        if(productService.update(p)){
            return R.ok();
        }
        return R.error("商品名称重复");
    }

    @RequestMapping("/list/{pageNo}/{size}")
    public R list(String name,Integer status,@PathVariable("pageNo") Integer pageNo,@PathVariable("size") Integer size){
        IPage<Product> page = productService.findAll(name,status,pageNo,size);
        if(page.getRecords().size()<1){
            return R.error();
        }
        return R.ok().put("products",page.getRecords()).put("pages",page.getPages());
    }
    @RequestMapping("/findByCategory/{cid}")
    public R findByCategory(@PathVariable("cid") Integer cid){
        return R.ok().put("products",productService.findByCategory(cid));
    }
    @PostMapping("/upload")
    public R upload(MultipartFile uploadImg){
        //生成新的文件名
        String filename= UUID.randomUUID().toString().replace("-", "");
        //获取上传的文件名
        String oriName=uploadImg.getOriginalFilename();
        //获得文件拓展名
        String extName=oriName.substring(oriName.lastIndexOf("."));
        File file = new File(UPLOAD_PATH+filename+extName);
        if(!file.exists()){
            file.mkdirs();
        }
        //执行上传
        try{
            uploadImg.transferTo(file);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //响应上传的图片访问路径
        return R.ok().put("uploadPath",IMG_SERVER_PATH+filename + extName);
    }

}
