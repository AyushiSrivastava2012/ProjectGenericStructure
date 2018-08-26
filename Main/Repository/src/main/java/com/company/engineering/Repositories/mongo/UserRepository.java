/**
 * 
 */
package com.company.engineering.Repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.engineering.Vo.mongo.User;

/**
 * @author Ayushi
 *
 */ 

@Repository
public interface UserRepository extends MongoRepository<User, String> {	
	
}
