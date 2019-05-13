package pl.tp.spring.TaskPlanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
//                .withUser("user").password("pass").roles("USER")
//                .and()
                .withUser("admin").password(passwordEncoder().encode("passat")).roles("ADMIN");
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, true from users where username = ?")
                .authoritiesByUsernameQuery("SELECT username, 'ROLE_USER' from users where username = ?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/register").anonymous()
                .antMatchers("/admin/**", "/employee/add", "/localization/add", "/job/**", "/team/**").hasRole("ADMIN")
//                .antMatchers("/anonymous").anonymous()
//                .antMatchers("/login*").permitAll()
                .anyRequest().permitAll()
                .and()

             .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/routing", true)
//                .defaultSuccessUrl("/hello.jsp")
//                .failureUrl("/login.jsp?error=true")
                .and()

             .logout()
                .logoutSuccessUrl("/login")
                .and()
             .csrf()
                .disable();

    }
}
