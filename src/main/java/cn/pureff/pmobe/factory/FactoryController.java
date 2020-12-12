package cn.pureff.pmobe.factory;

import cn.pureff.pmobe.dto.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class FactoryController {

    @Autowired private FactoryService factoryService;
    @Autowired private ObjectMapper mapper;

    @PostMapping("/factory")
    public Result<Factory> createOne(@Validated @RequestBody FactoryCreateRequest request) {
        var factory = mapper.convertValue(request, Factory.class);

        factoryService.createOne(factory);

        factory = factoryService.findOneById(factory.getId());
        log.info("");
        return Result.ok(factory);
    }

    @GetMapping("/factory/{id:[0-9a-zA-Z]{24}}")
    public Result<Factory> getOne(@PathVariable ObjectId id) {

        var factory = factoryService.findOneById(id);
        log.info("");
        return Result.ok(factory);
    }
}
