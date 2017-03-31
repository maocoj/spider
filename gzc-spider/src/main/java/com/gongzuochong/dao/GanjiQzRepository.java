package com.gongzuochong.dao;

import com.gongzuochong.entity.mongo.GanjiQzJob;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by marco on 2017/3/25.
 */
public interface GanjiQzRepository extends MongoRepository<GanjiQzJob, String>{
    List<GanjiQzJob> findTop10ByIdGreaterThanOrderById(String id);
}
