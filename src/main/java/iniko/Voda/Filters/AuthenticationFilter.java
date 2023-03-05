package iniko.Voda.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter( filterName = "Auth", urlPatterns = {"/admin/*","/user/*","/flightBook"})
public class AuthenticationFilter extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //super.doFilter(req, res, chain);
        System.out.println("do filter before AUTH");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = ((HttpServletRequest) req).getSession();
        String admin= (String) session.getAttribute("admin");
        String user= (String) session.getAttribute("user");
        System.out.println("Rq URI:  "+((HttpServletRequest) req).getRequestURI().toString() );
        if((admin==null)&&(((HttpServletRequest) req).getRequestURI().contains("admin")))
        {
            ((HttpServletResponse) res).sendRedirect("../login.jsp");
            return;
        }

        if((user==null)&&(((HttpServletRequest) req).getRequestURI().startsWith("/FyAway_war_exploded/user/")))
        {
            ((HttpServletResponse) res).sendRedirect("../login.jsp");
            return;
        }
        if((user==null)&&(((HttpServletRequest) req).getRequestURI().startsWith("/FyAway_war_exploded/flightBook")))
        {
            ((HttpServletResponse) res).sendRedirect("../login.jsp");
            return;
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
        System.out.println("do filter after AUTH");
       /* Cookie cookie = new Cookie("data", "somedata");
        res.addCookie(cookie);*/
    }

    @Override
    public ServletContext getServletContext() {
        return super.getServletContext();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
