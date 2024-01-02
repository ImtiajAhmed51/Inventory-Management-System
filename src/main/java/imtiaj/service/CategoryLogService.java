package imtiaj.service;

import imtiaj.model.CategoryLogEntity;
import imtiaj.repository.CategoryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryLogService {
    @Autowired
    private CategoryLogRepository categoryLogRepository;

    public void create(CategoryLogEntity categoryLog) {
        categoryLogRepository.create(categoryLog);
    }

    public void edit(CategoryLogEntity categoryLog) {
        categoryLogRepository.edit(categoryLog);
    }


    public CategoryLogEntity findById(int id) {
        return categoryLogRepository.findById(id);
    }

    public List<CategoryLogEntity> findAll() {
        return categoryLogRepository.getAll();
    }

    public void updateCategoryLog(CategoryLogEntity categoryLog) {
        categoryLogRepository.edit(categoryLog);
    }

    public void deleteCategoryLog(CategoryLogEntity categoryLog) {
        categoryLogRepository.delete(categoryLog.getCategoryId());
    }


}
