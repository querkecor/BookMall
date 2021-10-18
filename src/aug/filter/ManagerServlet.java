package aug.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: 86134
 * @time: 2021/10/14 19:44
 */
public class ManagerServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
            
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    
    @Override
    public void destroy() {
    
    }
}
