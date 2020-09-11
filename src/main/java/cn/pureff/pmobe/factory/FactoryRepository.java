package cn.pureff.pmobe.factory;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactoryRepository extends MongoRepository<Factory, ObjectId> {}
