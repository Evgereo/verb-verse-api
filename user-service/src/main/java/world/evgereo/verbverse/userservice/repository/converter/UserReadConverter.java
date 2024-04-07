package world.evgereo.verbverse.userservice.repository.converter;

import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import world.evgereo.verbverse.userservice.entity.User;
import world.evgereo.verbverse.userservice.entity.type.RoleTypeImpl;

import java.time.LocalDateTime;
import java.util.UUID;

@ReadingConverter
public class UserReadConverter implements Converter<Row, User> {

    @Override
    public User convert(Row source) {
        return new User(
                source.get("uuid", UUID.class),
                source.get("username", String.class),
                source.get("email", String.class),
                source.get("password", String.class),
                source.get("birth_date", LocalDateTime.class),
                source.get("created_at", LocalDateTime.class),
                source.get("is_active", Boolean.class),
                RoleTypeImpl.valueOf(source.get("role", String.class)));
    }
}
