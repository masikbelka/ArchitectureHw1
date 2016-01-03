package com.epam.cdp.architecture.model.dao;

import com.epam.cdp.architecture.model.entity.Timeline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TimelineDao extends CrudRepository<Timeline, Long> {

    List<Timeline> findPleaseByTimelineOwner(String noteOwner);
}
