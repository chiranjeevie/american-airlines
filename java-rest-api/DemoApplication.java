import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/")
    public ApiResponse hello() {
        return new ApiResponse("Hello, Azure App Service with Java!", 200);
    }

    @GetMapping("/health")
    public ApiResponse healthCheck() {
        return new ApiResponse("Application is healthy", 200);
    }

    @PostMapping("/echo")
    public ApiResponse echo(@RequestParam String message) {
        return new ApiResponse("Echo: " + message, 200);
    }
}

class ApiResponse {
    private final String message;
    private final int status;

    public ApiResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
