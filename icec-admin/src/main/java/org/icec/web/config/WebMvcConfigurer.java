package org.icec.web.config;

import java.util.List;

import org.icec.web.shiro.resolvers.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(currentUserMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}

	@Bean
	public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
		return new CurrentUserMethodArgumentResolver();
	}
}
