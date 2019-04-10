/*
 * package com.taskmanager.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.annotation.WebFilter;
 * import javax.servlet.http.HttpServletRequest;
 * 
 * @WebFilter("/putInfo*") public class TaskLoggerFilter implements Filter {
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * System.out.println(request.getParameter("id")); System.out.println("yes");
 * String url = ((HttpServletRequest) request).getRequestURL().toString();
 * String queryString = ((HttpServletRequest) request).getQueryString();
 * System.out.println(url + "?" + queryString); chain.doFilter(request,
 * response); }
 * 
 * }
 */