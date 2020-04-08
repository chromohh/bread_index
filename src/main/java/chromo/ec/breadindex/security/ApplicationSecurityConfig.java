package chromo.ec.breadindex.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                  .antMatchers("/admin/**").hasAuthority("ADMIN")
                  .antMatchers("/users/**").hasAuthority("USER")
                  .antMatchers("/public/**").permitAll()
                .and()
                  .formLogin()
                  .loginPage("/public/login")
                  .loginProcessingUrl("/public/login")
                  .usernameParameter("email")
                  .passwordParameter("password")
                  .permitAll()
                .and()
                  .logout()
                  .logoutUrl("/logout")
                  .invalidateHttpSession(true)
                  .deleteCookies("JSESSIONID")
                  .logoutSuccessUrl("/login?logout")
                .and()
                  .exceptionHandling()
                  .accessDeniedPage("/accessDenied");

    }
}
