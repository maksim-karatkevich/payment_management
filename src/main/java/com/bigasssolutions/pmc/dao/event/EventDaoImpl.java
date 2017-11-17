package com.bigasssolutions.pmc.dao.event;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bigasssolutions.pmc.dao.AbstractDao;
import com.bigasssolutions.pmc.model.Event;

@Repository
public class EventDaoImpl extends AbstractDao implements EventDao {

	private static final String FIND_ALL_QUERY = "from Event";
	private static final String SELECT_CATEGORY_BY_ID_QUERY = "select event from Event event where event.id = (:id)";

	@Override
	public void save(Event event) {
		super.save(event);
	}

	public void save(List<Event> events) {
		for (Event event : events) {
			save(event);
		}
	}

	@Override
	public List<Event> findAll() {
		return getEntityManager().createQuery(FIND_ALL_QUERY).getResultList();
	}

	@Override
	public Event findById(long id) {
		Query query = getEntityManager().createQuery(SELECT_CATEGORY_BY_ID_QUERY);
		query.setParameter("id", Long.valueOf(1));
		return (Event) query.getSingleResult();
	}

	@Override
	public List<Event> findByPeriod(String start, String end) {
		return null;
	}

	@Override
	public Event update(Event event) {
		return (Event) super.update(event);
	}

	@Override
	public void remove(Event event) {
		super.remove(event);
	}
}
