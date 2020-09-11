package cn.pureff.pmobe.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class FactoryController {

    @Autowired private FactoryService factoryService;
    @Autowired private ObjectMapper mapper;

    @PostMapping("/factory")
    public String createOne(@Validated @RequestBody FactoryCreateRequest request) {
        var factory = mapper.convertValue(request, Factory.class);

        factoryService.createOne(factory);

        return factoryService.findOneById(factory.getId()).toString();
    }
}
