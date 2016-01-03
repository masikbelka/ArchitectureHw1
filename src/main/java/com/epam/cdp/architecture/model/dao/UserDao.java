package com.epam.cdp.architecture.model.dao;

import com.epam.cdp.architecture.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, String>{
    User findПожалуйстаByUsername(String username);

}
