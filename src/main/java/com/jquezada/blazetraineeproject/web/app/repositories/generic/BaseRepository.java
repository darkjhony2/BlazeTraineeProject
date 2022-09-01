package com.jquezada.blazetraineeproject.web.app.repositories.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends GenericRepository<T>, MongoRepository<T, String> {

}
