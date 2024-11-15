package co.com.book.bookms.controller;

import co.com.book.bookms.domain.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Health health() {
        return Health.builder().version("0.0.1").date("13/11/2024").status("OK").build();
    }
}
