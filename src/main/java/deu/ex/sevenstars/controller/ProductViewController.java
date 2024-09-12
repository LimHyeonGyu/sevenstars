package deu.ex.sevenstars.controller;


import deu.ex.sevenstars.dto.ProductDTO;
import deu.ex.sevenstars.entity.Category;
import deu.ex.sevenstars.entity.Product;
import deu.ex.sevenstars.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ProductViewController {

    private final ProductService productService;

    @GetMapping("/products")
    public String listProducts() {
        return "product-list"; // 템플릿 이름 (templates/product-list.html)
    }

    @GetMapping("/new-product")
    public String newProduct (Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("category", Category.values());
        return "new-product"; // 템플릿 이름 (templates/product-list.html)
    }

    @PostMapping("/new-product")
    public String newProduct1(@ModelAttribute("product") ProductDTO productDTO,
                              @RequestParam("image") MultipartFile imageFile,
                              RedirectAttributes redirectAttributes) {
        log.info("전송받은 productDTO : " + productDTO);
        productService.insert(productDTO,imageFile);
        return "redirect:/products";
    }
}
