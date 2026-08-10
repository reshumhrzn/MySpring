package io.herald.myspringweb.Repository;

import io.herald.myspringweb.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Integer> {


    //Custom Syntaxes Signature
    //existsBy function can be found already in out repo, but username and password cannot be
    //detected directly by existsBy function
    //Hence, if our usertable has columns named "username" and "password" we can
    //suggest our repository to look for it, if the value exists or not.
    boolean existsByUsernameAndPassword(String un, String pwd);

    UserTable findByUsername(String username);
}
