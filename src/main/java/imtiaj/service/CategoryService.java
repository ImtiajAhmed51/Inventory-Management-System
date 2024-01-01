package imtiaj.service;

import imtiaj.model.Category;
import imtiaj.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Category category) {
        categoryRepository.create(category);
    }


    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.getAll();
    }

    public void updateCategory(Category category) {

        categoryRepository.edit(category);
    }

    public void deleteCategory(Category category) {

        categoryRepository.delete(category.getCategoryId());
    }


}
