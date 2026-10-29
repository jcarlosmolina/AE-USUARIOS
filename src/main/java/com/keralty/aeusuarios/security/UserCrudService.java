package com.keralty.aeusuarios.security;

import java.util.Optional;

public interface UserCrudService {

    User save(User agent);

    Optional<User> find(String id);

    Optional<User> findByUsername(String userName);
    
    Optional<User> findByFacetAndUsername(String facetName, String userName);
}

