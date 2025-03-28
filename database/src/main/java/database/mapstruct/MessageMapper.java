package database.mapstruct;

import database.entity.CryptMessageEntity;
import org.mapstruct.Mapper;
import producer.dto.CryptMessage;

@Mapper(componentModel = "spring") //как бин будеи считаться
public interface MessageMapper {
    CryptMessageEntity dtoToEntity(CryptMessage message);
}
