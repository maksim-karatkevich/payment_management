package com.bigasssolutions.pmc.service.category;

import com.bigasssolutions.pmc.dao.category.CategoryDao;
import com.bigasssolutions.pmc.dao.category.CategoryRuleDao;
import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.CategoryRule;
import com.bigasssolutions.pmc.utils.DefaultCategoryRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryRuleService {
    @Autowired
    private CategoryRuleDao categoryRuleDao;
    @Autowired
    private CategoryDao categoryDao;

    public void save(CategoryRule categoryRule) {
        categoryRuleDao.save(categoryRule);
    }

    public void saveAll() {
        Map<String, String> map = DefaultCategoryRules.getRules();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            categoryDao.save(new Category(entry.getValue()));
            save(new CategoryRule(entry.getKey(), entry.getValue()));
        }
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
