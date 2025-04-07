/*
 * package com.BisagN.config;
 * 
 * import javax.servlet.*; import javax.servlet.http.HttpServletRequest; import
 * java.io.IOException;
 * 
 * public class HostHeaderValidationFilter implements Filter {
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest httpRequest = (HttpServletRequest) request; String host =
 * httpRequest.getHeader("Host");
 * 
 * // Perform your validation checks on the host header value // If the
 * validation fails, you can respond with an error or reject the request
 * System.out.println("Host " + host); if
 * (!host.equalsIgnoreCase("192.168.15.44:8012")) { return; }
 * 
 * chain.doFilter(request, response); }
 * 
 * // Other filter methods }
 */