package kma.javaee.practice7.springdata;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    public UserEntity getUserById(int id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);

        return optionalUser
            .orElse(null);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserEntity> getAllUsersWhereNameLike(String contains) {
        return userRepository.findAllByFullNameLike('%' + contains + '%');
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<UserEntity> findAllWhereEmailLikeOrFullNameLike(String email, String fullName) {
        return userRepository.findAllWhereEmailLikeOrFullNameLike('%' + email + '%', '%' + fullName + '%');
    }

}
