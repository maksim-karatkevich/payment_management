package com.bigasssolutions.pmc.rest;

import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.CategoryRule;
import com.bigasssolutions.pmc.service.category.CategoryRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category_rules", headers = "Accept=application/json", produces = "application/json")
public class CategoryRuleController {

    @Autowired
    private CategoryRuleService categoryRuleService;

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody CategoryRule categoryRule) {
        categoryRuleService.save(categoryRule);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoryRule> findAll() {
        return categoryRuleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CategoryRule findById(@PathVariable long id) {
        return categoryRuleService.findById(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public CategoryRule findByName(@PathVariable  String name) {
        return categoryRuleService.findByName(name);
    }
}
