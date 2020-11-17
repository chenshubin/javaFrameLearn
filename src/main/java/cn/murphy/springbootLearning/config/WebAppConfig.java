package cn.murphy.springbootLearning.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig  implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(WebAppConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/local/**")
                .addResourceLocations("file:D:\\faban\\");
    }
}
