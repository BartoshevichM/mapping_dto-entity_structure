
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class SpecFieldsMapper extends AbstractMapper<SpecFieldsEntity, SpecFields {

    @Autowired
    private SpecFieldsRepository specFieldsRepo; // adding repository if needed


    public SpecFields(Class<SpecFieldsEntity> entityClass, Class<SpecFields> dtoClass) {
        super(entityClass, dtoClass);
    }

    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(SpecFields.class, SpecFieldsEntity.class)
                .addMappings(m->m.skip(SpecFieldsEntity::setField1)) //fields of entity to skip here
                .addMappings(m->m.skip(SpecFieldsEntity::setField2))
                .addMappings(m->m.skip(SpecFieldsEntity::setField3))
                .setPostConverter(toEntityConverter());
        modelMapper.createTypeMap(SpecFieldsEntity.class, SpecFields.class)
                .addMappings(m->m.skip(SpecFields::setField1)) //fields of dto to skip here
                .addMappings(m->m.skip(SpecFields::setField2))
                .setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificFieldsToEntity(SpecFields specFields, SpecFieldsEntity specFieldsEntity) { // make rules for filling specific fields of entity
        specFieldsEntity.setField1(specFieldsRepo
        		.findById(specFields.getId()).orElse(null));
       ...
	setField2, setField3
    }

    @Override
    void mapSpecificFieldsToDto(SpecFieldsEntity specFieldsEntity, SpecFields specFields) { // make rules for filling specific fields of dto
        specFields.setField1(specFieldsEntity.getField2.toString());
	...
	setField2
    }
}
