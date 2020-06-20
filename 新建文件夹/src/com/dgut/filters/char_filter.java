package com.dgut.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class char_filter
 */
@WebFilter("/char_filter")
public class char_filter implements Filter {

    /**
     * Default constructor. 
     */
    public char_filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	String encoding="utf-8";
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset="+encoding);
        chain.doFilter(request, response);
        }

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
