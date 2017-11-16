package com.bigasssolutions.pmc.dao.category;

import com.bigasssolutions.pmc.model.Category;

import java.util.List;

public interface CategoryDao {

    void save(Category category);

    List<Category> findAll();

    Category findById(long id);

    Category update(Category category);

    void remove(Category category);
}
