package com.bigasssolutions.pmc.service.category;

import com.bigasssolutions.pmc.dao.category.CategoryRuleDao;
import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.CategoryRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryRuleService {
    @Autowired
    private CategoryRuleDao categoryRuleDao;

    public void save(CategoryRule categoryRule) {
        categoryRuleDao.save(categoryRule);
    }

    public CategoryRule findById(long id) {
        return categoryRuleDao.findById(id);
    }

    public CategoryRule findByName(String name) {
        return categoryRuleDao.findByName(name);
    }

    public List<CategoryRule> findAll() {
        return categoryRuleDao.findAll();
    }
}
