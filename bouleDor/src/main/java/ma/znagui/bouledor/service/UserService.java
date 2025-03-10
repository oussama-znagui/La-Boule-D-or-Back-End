package ma.znagui.bouledor.service;

import ma.znagui.bouledor.entity.AppUser;

public interface UserService {

    AppUser findByEmail(String email);
    Boolean checkEmailExesting(String email);
}
