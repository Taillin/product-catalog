package com.aitu.product_catalog.controller;

import com.aitu.product_catalog.model.Product;
import com.aitu.product_catalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String listProducts(@RequestParam(required = false) String search,
                               @RequestParam(required = false) String category,
                               Model model) {
        List<Product> products = productService.searchProduct(search, category);
        model.addAttribute("products", products);
        model.addAttribute("search", search);
        model.addAttribute("category", category);
        return "product-list";
    }
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable long id, Model model) {
        Product product = productService.getProductId(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product-detail";
    }
    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable long id, Model model) {
        try {
            Product product = productService.getProductId(id);
            model.addAttribute("product", product);
            return "product-form";
        } catch (IllegalArgumentException e) {
            return "redirect:/products";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}