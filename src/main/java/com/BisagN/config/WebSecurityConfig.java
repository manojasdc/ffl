package com.BisagN.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.BisagN.controller.redirectLogin;
import com.BisagN.service.CustomAuthenticationProvider;
import com.BisagN.service.ExtraParamSource;
import com.BisagN.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	ExtraParamSource extraParamSource;
//	@Autowired
//	CustomLoginFailureHandler customloginfailurehandler;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
		auth.authenticationProvider(customAuthenticationProvider);

	}

//	@Autowired
//	public CustomAuthenticationProvider authProvider() {
//        CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
//        return authenticationProvider;
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().cacheControl();
//		http.headers().frameOptions().deny();
//		http.headers().referrerPolicy(ReferrerPolicy.SAME_ORIGIN);

		http.addFilterBefore(new CSPNonceFilter(), HeaderWriterFilter.class);

//		http.headers().xssProtection().and().contentSecurityPolicy("default-src 'self' 'unsafe-inline' 'nonce-{nonce}';"
//				+ "script-src  'self' ;style-src 'self'  'nonce-{nonce}'  ;"
//				+"object-src 'none'; base-uri 'self';font-src 'self'; frame-src 'self'; img-src  'self';"
//				+ "");
		
//		http.headers().xssProtection().and().contentSecurityPolicy("default-src  'self';" + "script-src 'self' blob: https://cbpssubscriber.mygov.in  'nonce-{nonce}' ;"
//				 + "script-src-elem 'self' 'unsafe-inline' https://translate.google.com/translate_ahttps://translate.googleapis.com https://www.google.com https://translate.google.com https://translate-pa.googleapis.com  ;"
//				+ "style-src 'self' 'unsafe-inline' https://cbpssubscriber.mygov.in https://www.gstatic.com https://www.google.com ;"
//				+ "style-src-elem 'self' 'unsafe-inline'  https://www.gstatic.com  https://www.google.com ;"
//				+ "object-src 'self'  blob: 'nonce-{nonce}'; base-uri 'self';" + "connect-src 'self' http://localhost:5757   https://translate.googleapis.com https://translate.google.com data: blob:;"
//				+ "font-src 'self' data: ;" + "frame-src 'self' data: blob: https://www.google.com; " + "img-src  'self'   translate.google.com https://www.google.com https://translate.googleapis.com https://www.gstatic.com https://fonts.gstatic.com https://www.google.com  blob: data: ;" 
//				+ "manifest-src 'self';" + "media-src 'self' data: blob:;" + "frame-ancestors 'self'");


		http.headers().xssProtection().and().contentSecurityPolicy("default-src 'self'; " +
			    "script-src 'self' blob:  'nonce-{nonce}'; " +
			    "script-src-elem 'self' 'nonce-{nonce}' ; " +
			    "style-src 'self' 'nonce-{nonce}'  ; " +
			    "style-src-elem 'self' 'nonce-{nonce}' ; " +
			    "object-src 'self' blob: 'nonce-{nonce}'; base-uri 'self'; " +
			    "connect-src 'self'   data: blob:; " +
			    "font-src 'self' data:; " +
			    "frame-src 'self' data: blob: ; " +
			    "img-src 'self' blob: data:; " +
			    "manifest-src 'self'; " +
			    "media-src 'self' data: blob:; " +
			    "frame-ancestors 'self'");
		
		
//		http.headers().xssProtection().and().contentSecurityPolicy("default-src 'self'; " +
//			    "script-src 'self' blob: https://cbpssubscriber.mygov.in 'nonce-{nonce}' https://translate.googleapis.com https://www.google.com https://translate.google.com; " +
//			    "script-src-elem 'self' 'nonce-{nonce}' https://translate.googleapis.com https://www.google.com https://translate.google.com https://translate-pa.googleapis.com; " +
//			    "style-src 'self' 'nonce-{nonce}'  https://cbpssubscriber.mygov.in https://www.gstatic.com https://www.google.com https://fonts.googleapis.com; " +
//			    "style-src-elem 'self' 'nonce-{nonce}' https://www.gstatic.com https://www.google.com https://fonts.googleapis.com; " +
//			    "object-src 'self' blob: 'nonce-{nonce}'; base-uri 'self'; " +
//			    "connect-src 'self' https://localhost:5757 https://translate.googleapis.com https://translate.google.com https://translate-pa.googleapis.com data: blob:; " +
//			    "font-src 'self' data:; " +
//			    "frame-src 'self' data: blob: https://www.google.com https://translate.google.com; " +
//			    "img-src 'self' translate.google.com https://www.google.com https://translate.googleapis.com https://www.gstatic.com https://fonts.gstatic.com blob: data:; " +
//			    "manifest-src 'self'; " +
//			    "media-src 'self' data: blob:; " +
//			    "frame-ancestors 'self'");
		
//		http.headers()
//				.contentSecurityPolicy("default-src  'self';" + "script-src  'self' 'nonce-{nonce}' data: blob: ;"
//						+ "style-src 'self' 'nonce-{nonce}' ;"
//						+ "object-src 'self' data: blob: 'nonce-{nonce}'; base-uri 'self';" + "connect-src 'self' data:;"
//						+ "font-src 'self' data: ;" + "frame-src 'self' data: blob:; " + "img-src  'self' data: blob:;" // TO
//																													// DO
//						+ "manifest-src 'self';" + "media-src 'self' data: blob:;" + "frame-ancestors 'self';");

//		and().contentSecurityPolicy("default-src  'self';\r\n"
//				+ "		 		script-src  'self' 'unsafe-inline' 'nonce-{nonce}'  ; \r\n"
//				+ "				style-src 'self'  'nonce-{nonce}'  ; \r\n" + "				frame-ancestors 'none';\r\n"
//				+ "				object-src 'none'; base-uri 'self';\r\n" + "		 		connect-src 'self';\r\n"
//				+ "		  		font-src 'self'; frame-src 'self'; \r\n"
//				+ "		  		img-src  'self' https://mes.gov.in data: ; \r\n"
//				+ "		  		manifest-src 'self'; media-src 'self';");

//    	 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//    	 .maximumSessions(1).expiredUrl("/login?logout")
//    	 .maxSessionsPreventsLogin(true)
//    	 .and()
//    	 .invalidSessionUrl("/login?logout").sessionFixation().migrateSession();
		http.authorizeRequests().antMatchers("/logout","/imagelink/**").permitAll();
		http.authorizeRequests().antMatchers("/schedule//taskdef1").permitAll();

//    	 http.authorizeRequests().antMatchers( "/login/**","/admin/**","AFMS/admin/**").permitAll();
		http.authorizeRequests().antMatchers("/login/**", "/admin/**").permitAll();

		http.authorizeRequests().antMatchers("/auth/login_check?targetUrl", "/checkCapchaCode", "**/favicon.ico",
				"/**/favicon.ico", "/favicon.ico","/CATA", "../admin/getInstitute","../admin/SaveRegistrationDetails","../admin/getCountry").permitAll();
		http.authorizeRequests().antMatchers("/genCapchaCode").permitAll();
		http.authorizeRequests().antMatchers("/checkCapchaCode").permitAll();
		http.authorizeRequests().antMatchers("/favicon.ico").permitAll();

//        http.authorizeRequests().antMatchers( "/AFMS/admin/LoadStudentForApproval").permitAll();

//        http.authorizeRequests().antMatchers( "/registrationUrl","/CheckEmailExistandSendEmail","/VerifyEmailandRegister","/admin/LoadStudentForApproval").permitAll();
		http.authorizeRequests()
				.antMatchers("/registrationUrl", "/CheckEmailExistandSendEmail", "/VerifyEmailandRegister","/test").permitAll();

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//        http.authorizeRequests().anyRequest().authenticated();
//        http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().and().formLogin().usernameParameter("username").passwordParameter("password")
				.authenticationDetailsSource(extraParamSource).loginProcessingUrl("/auth/login_check")
				.loginPage("/login").successHandler(redirectLogin())
		.failureUrl("/signin?error=true");
//        http
//        .logout(logout -> logout                                                
//            .logoutUrl("/logout")                                            
//            .logoutSuccessUrl("/login?logout")                                      
////            .logoutSuccessHandler(logoutSuccessHandler)                         
//            .invalidateHttpSession(true)                                        
////            .addLogoutHandler(logoutHandler)                                    
//            .deleteCookies("JSESSIONID")                                  
//        );
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/signin?logout");
		http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
		http.sessionManagement().sessionFixation().migrateSession().sessionAuthenticationStrategy(registerSessionAuthStr());
		
//		http.sessionManagement().sessionFixation().migrateSession().maximumSessions(1).maxSessionsPreventsLogin(true);

	}

	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

	@Bean
	public RegisterSessionAuthenticationStrategy registerSessionAuthStr() {
		return new RegisterSessionAuthenticationStrategy(sessionRegistry());
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}

	@Bean
	public AuthenticationSuccessHandler redirectLogin() {
		return new redirectLogin();
	}
	
	/*
	 * @Bean public FilterRegistrationBean<HostHeaderValidationFilter>
	 * hostHeaderValidationFilter() {
	 * FilterRegistrationBean<HostHeaderValidationFilter> registrationBean = new
	 * FilterRegistrationBean<>(); registrationBean.setFilter(new
	 * HostHeaderValidationFilter()); registrationBean.addUrlPatterns("/*"); //
	 * Apply the filter to all requests return registrationBean; }
	 */

	@Bean
	public FilterRegistrationBean xssPreventFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new XSSFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean userInsertingMdcFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		requestThrottleFilter userFilter = new requestThrottleFilter();
		registrationBean.setFilter(userFilter);
		registrationBean.setOrder(Integer.MAX_VALUE);
		return registrationBean;
	}
	
}
