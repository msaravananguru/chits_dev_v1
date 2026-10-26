package chits.v1.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Lets the React dev server (port 5173) call the API.
 * The 192.168.* pattern allows testing from a phone on the same Wi-Fi.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOriginPatterns("http://localhost:*", "http://192.168.*.*:*")
				.allowedMethods("POST", "OPTIONS")
				.allowedHeaders("*");
	}
}
