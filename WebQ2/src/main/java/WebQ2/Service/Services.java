package WebQ2.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import WebQ2.entity.Employee;
import WebQ2.model.Response;
import WebQ2.repository.Repositories;
import com.google.gson.Gson;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Services implements IServices{
	
	@Autowired
	private Repositories employeeRepository;
		
	private static final String URL = "http://dummy.restapiexample.com/api/v1/employees";

	@Override
	public Mono<Response> getEmployeeDataFromThirdPartyApi() {


		
		WebClient webClient = WebClient.create();
		return webClient.get()
				.uri(URL)
				.retrieve()
				.bodyToMono(String.class)
				.flatMap(r->{
					Gson gson= new Gson();
					return Mono.just(gson.fromJson(r, Response.class));
				}
				);
	}

	@Override
	public Flux<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Mono<Employee> addEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Flux<Employee> getEmployeeBySalary(List<Employee> resp) {
		List<Employee> employeeList = assignLoan(resp);
		return employeeRepository.saveAll(employeeList);
	}

	private List<Employee> assignLoan(List<Employee> employeeList) {
		for(Employee employee:employeeList) {
		if(employee.getEmployeeSalary()>100000)
			employee.setEligibleForLoan(true);
		else
            employee.setEligibleForLoan(false);}
		return employeeList;
	}

}

				
