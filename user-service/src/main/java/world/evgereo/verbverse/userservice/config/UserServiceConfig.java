package world.evgereo.verbverse.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import world.evgereo.verbverse.userservice.repository.converter.UserReadConverter;

import java.util.List;

@Configuration
public class UserServiceConfig {
    @Bean
    public R2dbcCustomConversions customConversions() {
        return R2dbcCustomConversions.of(MySqlDialect.INSTANCE, List.of(new UserReadConverter()));
    }
}
