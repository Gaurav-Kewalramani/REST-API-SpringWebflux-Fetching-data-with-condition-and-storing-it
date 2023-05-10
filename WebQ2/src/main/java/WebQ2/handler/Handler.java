package WebQ2.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import WebQ2.entity.Employee;
import WebQ2.model.Response;
import WebQ2.Service.IServices;
import reactor.core.publisher.Mono;

@Component
public class Handler {
	
	@Autowired
	IServices employeeService;
	
	public Mono<ServerResponse> getEmployeeDataFromThirdPartyApi(ServerRequest serverRequest){
		Mono<Response> responseMono = employeeService.getEmployeeDataFromThirdPartyApi();
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(responseMono, Response.class);
	}
	
	public Mono<ServerResponse> getAllEmployee(ServerRequest serverRequest){
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(employeeService.getAllEmployee(), Employee.class);
	}

	public Mono<ServerResponse> addEmployee(ServerRequest serverRequest){
		Mono<Employee> employee = serverRequest.bodyToMono(Employee.class);
		Mono<Employee> newEmployee = employee.flatMap(employeeService::addEmployee);
		return ServerResponse
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(newEmployee,Employee.class);
	}
	
	public Mono<ServerResponse> getEmployeeBySalary(ServerRequest req){
		Mono<Response> response = employeeService.getEmployeeDataFromThirdPartyApi();
		Mono<List<Employee>> employee = response.flatMap(emp->Mono
				          										.just(emp.getData()));
	
		return employee.flatMap(resp->ServerResponse.ok()
				  .contentType(MediaType.APPLICATION_JSON)
				  .body(employeeService.getEmployeeBySalary(resp),Employee.class));
	}
}
