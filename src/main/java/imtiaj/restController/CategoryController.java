package imtiaj.restController;

import imtiaj.model.Category;
import imtiaj.model.TheLogConverter;
import imtiaj.service.CategoryLogService;
import imtiaj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    public CategoryService categoryService;
    @Autowired
    private CategoryLogService categoryLogService;

    @GetMapping("/categories")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category searchCategory(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.create(category);
        categoryLogService.create(TheLogConverter.categoryLogConverter(category));
    }

    @PutMapping("/categories/{id}")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        categoryLogService.updateCategoryLog(TheLogConverter.categoryLogConverter(category));
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@RequestBody Category category) {
        categoryService.deleteCategory(category);
        categoryLogService.create(TheLogConverter.categoryLogConverter(category));
    }


}
