package com.zipcode.DTVApp.repositories;

import com.zipcode.DTVApp.models.Ambassador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AmbassadorRepo extends CrudRepository<Ambassador, UUID> {

}
