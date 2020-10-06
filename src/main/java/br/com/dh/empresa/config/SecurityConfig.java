package br.com.dh.empresa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email, senha, habilitado from funcionario where email = ?")
		.authoritiesByUsernameQuery("select email, autoridade from autorizacao where email = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/cliente").hasAnyRole("GERENTE", "FUNCIONARIO")
		.antMatchers("/cliente/cadastrar").hasAnyRole("GERENTE", "FUNCIONARIO")
		.antMatchers("/pedido").hasAnyRole("GERENTE", "FUNCIONARIO")
		.antMatchers("/pedido/cadastrar").hasAnyRole("GERENTE", "FUNCIONARIO")
		.antMatchers("/funcionario").hasAnyRole("GERENTE", "FUNCIONARIO")
		.antMatchers("/funcionario/cadastrar").hasAnyRole("GERENTE")
		.antMatchers("/funcionario/reajustarsalario/{id}").hasRole("GERENTE")
		.antMatchers("/funcionario/demitir/{id}").hasRole("GERENTE")
		.and().httpBasic();
	}
}
