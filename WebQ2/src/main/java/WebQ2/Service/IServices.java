package WebQ2.Service;

import java.util.List;

import WebQ2.entity.Employee;
import WebQ2.model.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServices {
	public Mono<Response> getEmployeeDataFromThirdPartyApi();
	public Flux<Employee> getAllEmployee();
	public Mono<Employee> addEmployee(Employee employee);
	public Flux<Employee> getEmployeeBySalary(List<Employee> resp);
}	
