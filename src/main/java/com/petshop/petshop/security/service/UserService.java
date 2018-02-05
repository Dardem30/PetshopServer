package com.petshop.petshop.security.service;


import com.petshop.petshop.model.security.model.User;

import java.util.List;

/**
 * Interface for User work with database.
 */
public interface UserService {

    /**
     * Method for create User.
     *
     * @param user User user.
     * @return created User user.
     */
    User create(User user);

    /**
     * Method for update User.
     *
     * @param user User user.
     * @return updated User user.
     */
    User update(User user);

    /**
     * Method for Delete User.
     *
     * @param id User id.
     */
    void delete(Integer id);

    /**
     * Method for fetch User by username.
     *
     * @param username User username.
     * @return received User user.
     */
    User getUserByUsername(String username);

    /**
     * Method for fetch User by id.
     *
     * @param id User id.
     * @return received User user.
     */
    User fetch(Integer id);

    /**
     * Method for fetch all User.
     *
     * @return List of User user.
     */
    List<User> listUsers();
}
