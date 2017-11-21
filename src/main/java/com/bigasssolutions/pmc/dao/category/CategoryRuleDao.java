package com.bigasssolutions.pmc.dao.category;

import com.bigasssolutions.pmc.dao.AbstractDao;
import com.bigasssolutions.pmc.model.Category;
import com.bigasssolutions.pmc.model.CategoryRule;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRuleDao extends AbstractDao {
    private static final String FIND_ALL_QUERY = "from CategoryRule";
    private static final String SELECT_CATEGORY_RULE_BY_ID_QUERY = "from CategoryRule categoryRule where categoryRule.id = (:id)";
    private static final String SELECT_CATEGORY_RULE_BY_NAME_QUERY = "from CategoryRule categoryRule where categoryRule.shop_name = (:name)";

    public CategoryRule findById(long id) {
        Query query = getEntityManager().createQuery(SELECT_CATEGORY_RULE_BY_ID_QUERY);
        query.setParameter("id", id);
        return (CategoryRule) query.getSingleResult();
    }

    public CategoryRule findByName(String name) {
        Query query = getEntityManager().createQuery(SELECT_CATEGORY_RULE_BY_NAME_QUERY);
        query.setParameter("name", name);
        return (CategoryRule) query.getSingleResult();
    }

    public List<CategoryRule> findAll() {
        return getEntityManager().createQuery(FIND_ALL_QUERY, CategoryRule.class).getResultList();

    }
}
