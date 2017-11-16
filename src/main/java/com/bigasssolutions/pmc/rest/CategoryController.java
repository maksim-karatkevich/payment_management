package com.bigasssolutions.pmc.rest;

import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories", headers = "Accept=application/json", produces = "application/json")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Category category) {
        categoryService.save(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@RequestBody Category category) {
        categoryService.remove(category);
    }

}
