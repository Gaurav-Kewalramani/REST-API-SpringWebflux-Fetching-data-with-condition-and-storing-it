package WebQ2.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import WebQ2.entity.Employee;

@Repository
public interface Repositories extends ReactiveMongoRepository<Employee, Integer>{

}
