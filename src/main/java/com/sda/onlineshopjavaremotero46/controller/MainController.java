package com.sda.onlineshopjavaremotero46.controller;

import com.sda.onlineshopjavaremotero46.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sda.onlineshopjavaremotero46.service.ProductService;

import java.util.List;


@Controller
@Slf4j
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping("/addProduct")
    public String addProductGet(Model model){
        ProductDto productDto = new ProductDto();

        model.addAttribute("productDto",productDto);

        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDto productDto){
        System.out.println(productDto);
        log.info("apelat add product");
        productService.create(productDto);
        return "redirect:/addProduct";
    }
    @GetMapping("/home")
    public String homeGet(Model model){

        List<ProductDto> productDtoList = productService.getAllProductDtoList();
        model.addAttribute("productDtoList", productDtoList);
        System.out.println(productDtoList);
        return "home";
    }
    @GetMapping("/product/{productId}")
    public String viewProductGet(Model model, @PathVariable(value = "productId") String productId){
        System.out.println("am dat click pe produsul cu id-ul: " + productId);
        return "viewProduct";
    }

}
