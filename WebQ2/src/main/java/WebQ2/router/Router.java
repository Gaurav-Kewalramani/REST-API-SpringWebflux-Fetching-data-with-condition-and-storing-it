package WebQ2.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import WebQ2.handler.Handler;

@Configuration
public class Router {
	
	@Bean
	RouterFunction<ServerResponse> employeeFunction(Handler employeeHandler) {
		return route(GET("/employees") 
				.and(accept(MediaType.APPLICATION_JSON)), employeeHandler :: getEmployeeDataFromThirdPartyApi)
				
				
				.andRoute(GET("/employees/all")
				.and(accept(MediaType.APPLICATION_JSON)), employeeHandler :: getAllEmployee)
				
				
				.andRoute(POST("/employees")
				.and(accept(MediaType.APPLICATION_JSON)), employeeHandler:: addEmployee)
				
				
				.andRoute(GET("/consume")
				.and(accept(MediaType.APPLICATION_JSON)), employeeHandler :: getEmployeeBySalary);
		
	}
}
