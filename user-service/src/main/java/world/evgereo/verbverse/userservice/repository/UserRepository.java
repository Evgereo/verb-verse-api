package world.evgereo.verbverse.userservice.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;
import world.evgereo.verbverse.userservice.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
    @Query("select a.*, r.* from account a inner join role r on a.role_id = r.id where a.uuid=:userUuid")
    Mono<User> findUserAndRoleByUuid(UUID userUuid);

    @Modifying
    @Query("insert into account(uuid, username, email, password, age, birth_date, created_at, role_id, active) " +
            "values (:#{#user.getUuid()}, :#{#user.getUsername()}, :#{#user.getEmail()}, :#{#user.getPassword()}, " +
            ":#{#user.getAge()}, :#{#user.getBirthDate()}, :#{#user.getCreatedAt()}, :#{#user.getRoleId()}, :#{#user.getActive()})")
    Mono<Void> create(@NonNull User user);

    @Modifying
    @Query("update account a " +
            "set username = :#{#user.getUsername()}, email = :#{#user.getEmail()}, password = :#{#user.getPassword()}, " +
            "age = :#{#user.getAge()}, birth_date = :#{#user.getBirthDate()}, role_id = :#{#user.getCreatedAt()}, " +
            "role_id = :#{#user.getRoleId()}, active = :#{#user.getActive()} " +
            "where uuid = :#{#user.getUuid()}")
    Mono<Void> update(@NonNull User user);
}
