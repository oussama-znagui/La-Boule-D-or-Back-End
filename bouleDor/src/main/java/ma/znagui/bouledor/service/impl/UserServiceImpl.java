package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.entity.AppUser;
import ma.znagui.bouledor.repository.UserRepository;
import ma.znagui.bouledor.service.UserService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public AppUser findByEmail(String email) {
        return null;
    }

    @Override
    public Boolean checkEmailExesting(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }


}
