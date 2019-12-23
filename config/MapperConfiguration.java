
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.library.mappers.Mapper;



@Configuration
public class MapperConfiguration {     

    @Bean
    public Mapper sameFieldsMapper() {
        return new SameFieldsMapper(SameFieldsEntity.class, SameFields.class);
    }

    @Bean
    public Mapper specFieldsMapper() {
        return new SpecFieldsMapper(SpecFieldsEntity.class, SpecFields.class);
    }
}
