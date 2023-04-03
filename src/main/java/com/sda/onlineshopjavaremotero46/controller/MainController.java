package com.sda.onlineshopjavaremotero46.controller;

import com.sda.onlineshopjavaremotero46.dto.ProductDto;
import com.sda.onlineshopjavaremotero46.dto.ProductQuantityDto;
import com.sda.onlineshopjavaremotero46.dto.UserAccountDto;
import com.sda.onlineshopjavaremotero46.entities.Cart;
import com.sda.onlineshopjavaremotero46.service.CartService;
import com.sda.onlineshopjavaremotero46.service.UserAccountService;
import com.sda.onlineshopjavaremotero46.validator.UserAccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.sda.onlineshopjavaremotero46.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserAccountValidator userAccountValidator;
    @Autowired
    private CartService cartService;

    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();

        model.addAttribute("productDto", productDto);

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDto productDto, @RequestParam("productImage") MultipartFile multipartFile) {
        System.out.println(productDto);
        log.info("apelat add product");
        productService.create(productDto, multipartFile);
        return "redirect:/addProduct";
    }

    @GetMapping("/home")
    public String homeGet(Model model) {

        List<ProductDto> productDtoList = productService.getAllProductDtoList();
        model.addAttribute("productDtoList", productDtoList);
        System.out.println(productDtoList);
        return "home";
    }
    @GetMapping("/product/{productId}")
    public String viewProductGet(Model model, @PathVariable(value = "productId") String productId) {
        System.out.println("am dat click pe produsul cu id-ul: " + productId);
        Optional<ProductDto> optionalProductDto = productService.getProductDtoById(productId);
        if (optionalProductDto.isEmpty()) {
            return "error";
        }
        model.addAttribute("productDto", optionalProductDto.get());
        ProductQuantityDto productQuantityDto = new ProductQuantityDto();
        model.addAttribute("productQuantityDto", productQuantityDto);
        return "viewProduct";
    }
    @PostMapping("/product/{productId}")
    public String addToCartPost(@ModelAttribute ProductQuantityDto productQuantityDto,
                                @PathVariable(value = "productId") String productId, Authentication authentication){
        System.out.println(productQuantityDto);
        System.out.println("adaug in cos produsul cu id-ul: " + productId);
        System.out.println(authentication.getName());
        cartService.addToCart(productId, productQuantityDto, authentication.getName());
        return "redirect:/product/" + productId;
    }
    @GetMapping("/register")
    public String registerGet(Model model) {
        UserAccountDto userAccountDto = new UserAccountDto();
        model.addAttribute("userAccountDto", userAccountDto);
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute UserAccountDto userAccountDto, BindingResult bindingResult){
        System.out.println(userAccountDto);
        userAccountValidator.validate(userAccountDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "register";
        }
        userAccountService.registerUser(userAccountDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }
    @GetMapping("/checkout")
    public String checkoutGet(){
        return "checkout";
    }
}
