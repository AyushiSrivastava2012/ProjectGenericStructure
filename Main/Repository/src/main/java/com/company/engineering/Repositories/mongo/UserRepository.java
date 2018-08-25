/**
 * 
 */
package com.company.engineering.Repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.engineering.Vo.mongoVos.UserCollection;

/**
 * @author Ayushi
 *
 */
public interface UserRepository extends MongoRepository<UserCollection, String> {	
	
}
