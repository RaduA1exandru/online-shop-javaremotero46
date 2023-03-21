package com.sda.onlineshopjavaremotero46.controller;

import com.sda.onlineshopjavaremotero46.dto.ProductDto;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class MainController {
    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();
        productDto.setName("telefon");
        model.addAttribute("productDto", productDto);

        // aici implementam fancy "business logic"
        // pe scurt prasim
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost() {
        log.info("s-a apelat add product");
        return "redirect:/addProduct";
    }
}
