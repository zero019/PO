package com.zeronly.po.security;


import com.zeronly.po.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 认证和授权处理类
 */
@SuppressWarnings("deprecation")
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	// 依赖注入通用的用户服务类
	@Autowired
	private MyUserSecurityService myUserSecurityService;
//	//依赖注入加密接口
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	// 依赖注入用户认证接口
	@Autowired
	private AuthenticationProvider authenticationProvider;

	// 依赖注入认证处理成功类，验证用户成功后处理不同用户跳转到不同的页面
//	@Autowired
//	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	/**
	 * BCryptPasswordEncoder是PasswordEncoder的接口实现 实现加密功能
	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Autowired
	private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	@Bean
	RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = "ROLE_ADMIN > ROLE_APPLY \n ROLE_ADMIN > ROLE_CONTRACT " +
				"\n ROLE_ADMIN > ROLE_INQUERY \n ROLE_ADMIN > ROLE_ORDER \n ROLE_ADMIN > ROLE_WAREHOUSE";
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}


	/**
	 * DaoAuthenticationProvider是AuthenticationProvider的实现
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provide = new DaoAuthenticationProvider();
		// 不隐藏用户未找到异常
		provide.setHideUserNotFoundExceptions(false);
		// 设置自定义认证方式，用户登录认证
		provide.setUserDetailsService(myUserSecurityService);
		// 设置密码加密程序认证
		provide.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provide;
	}

	/**
	 * 用户认证
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 设置认证方式

		auth.authenticationProvider(authenticationProvider);
//		auth.inMemoryAuthentication().passwordEncoder(());
	}

	/**
	 * 请求授权 用户授权操作
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				// 不通过Session获取SecurityContext
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				.authorizeRequests()
				// 首页、登录、注册页面、登录注册功能、以及静态资源过滤掉，即可任意访问
				.antMatchers("/swagger-ui/**", "/v3/**", "/tologin", "/toRegister", "/register",
						"/css/**", "/fonts/**" ,"/js/**", "/common/**")
				.permitAll()
				// 这里默认追加ROLE_，/user/**是控制器的请求匹配路径
				//这边前缀PO不能单独被permit不然就全部权限放行了
				.antMatchers("/po/user/login").permitAll()
				.antMatchers("/po/po-apply/**").hasRole("APPLY")
				.antMatchers("/po/po-contract/**").hasRole("CONTRACT")
				.antMatchers("/po/po-inquery/**").hasRole("INQUERY")
				.antMatchers("/po/po-order/**").hasRole("ORDER")
				.antMatchers("/po/po-warehouse/**").hasRole("WAREHOUSE")

				// 其他所有请求登录后才能访问
				.anyRequest().authenticated().and()
				// 将输入的用户名与密码和授权的进行比较
				// 注销行为可任意访问
				.logout().permitAll()
				/** 批注 */
				.and()
				// 指定异常处理页面
				.exceptionHandling().accessDeniedPage("/common/deniedaccess");
		http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
//		web.ignoring().antMatchers("/swagger-ui.html").antMatchers("/v2/**").antMatchers("/swagger-resources/**");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
