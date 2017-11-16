package com.bigasssolutions.pmc.service.category;

import com.bigasssolutions.pmc.dao.category.CategoryDao;
import com.bigasssolutions.pmc.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void save(Category category) {
        categoryDao.save(category);
    }

    public Category findById(long id) {
        return categoryDao.findById(id);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    public Category update(Category category) {
        return categoryDao.update(category);
    }

    public void remove(Category category) {
        categoryDao.remove(category);
    }
}
