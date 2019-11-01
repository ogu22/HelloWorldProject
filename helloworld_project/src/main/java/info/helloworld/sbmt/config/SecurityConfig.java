package info.helloworld.sbmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static String ROLE_USER = "USER";
	private static String ROLE_ADMIN = "ADMIN";
	
	@Autowired
	public  ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

	@Override
    public void configure(WebSecurity web) {
        // 静的リソースに対するアクセスはセキュリティ設定を無視する
        web.ignoring()
                .antMatchers("/*.html", "/*.css")
                .antMatchers("/bootstrap/**");
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user").hasAnyRole(ROLE_USER, ROLE_ADMIN).antMatchers("/admin")
				.hasRole(ROLE_ADMIN).and()

				.formLogin().loginPage("/login").defaultSuccessUrl("/user").usernameParameter("username")
				.passwordParameter("password").permitAll().and()

				.logout().permitAll().and()

				.csrf();
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.addDialect(new SpringSecurityDialect());
	    engine.setTemplateResolver(templateResolver);
	    return engine;
	}
}
