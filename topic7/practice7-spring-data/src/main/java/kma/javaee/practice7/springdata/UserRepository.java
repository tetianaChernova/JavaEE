package kma.javaee.practice7.springdata;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAllByFullNameLike(String contains);

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    List<UserEntity> findAllByEmailEqualsOrFullNameContains(String equalsEmail, String nonWantedNamePart);

    @Query("SELECT u FROM UserEntity u "
        + "WHERE u.email LIKE :param1 "
        + "OR u.fullName LIKE :param2")
    List<UserEntity> findAllWhereEmailLikeOrFullNameLike(@Param("param1") String param1, @Param("param2") String param2);

}
