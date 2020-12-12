package cn.pureff.pmobe.factory;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FactoryService {

    @Autowired private MongoTemplate mongoTemplate;
    @Autowired private FactoryRepository factoryRepository;

    public void createOne(Factory factory) {
        try {
            factoryRepository.save(factory);
        } catch (DuplicateKeyException e) {
        }
    }

    public Factory findOneById(ObjectId id) {
        return factoryRepository.findById(id).orElseThrow();
    }
}
