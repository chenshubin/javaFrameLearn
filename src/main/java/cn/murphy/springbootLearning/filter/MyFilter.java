package cn.murphy.springbootLearning.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(urlPatterns  = "/*", filterName = "myFilter")
public class MyFilter implements Filter {

    private Logger logger = Logger.getLogger("MyFilter");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("doFilter()");
        logger.info("before filter");
        chain.doFilter(request,  response);
        logger.info("after filter");

    }

    @Override
    public void destroy() {
        logger.info("destroy()");
    }


    @Override

    public void init(FilterConfig config) throws ServletException {
        logger.info("init()");
    }

}
