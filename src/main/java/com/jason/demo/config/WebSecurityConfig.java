package com.jason.demo.config;

import com.jason.demo.member.CustomLoginSuccessHandler;
import com.jason.demo.member.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        
        web.ignoring().antMatchers(
                "/ping/**",
                "/test/**");
    
//        super.configure(web);
    }
    
    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//        http
//                .authorizeRequests()
//                .antMatchers("/**").permitAll();
        
        http
                .authorizeRequests()
                .antMatchers("/all", "/login", "/logout").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**", "/api/**").hasRole("USER")
//                .anyRequest().authenticated()
                .and()
                
                .formLogin()//.usernameParameter("name").passwordParameter("password")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/ping")
                .successHandler(successHandler())
                .failureUrl("/all")
                .loginPage("/login")
                .and()
                
                .logout().logoutUrl("/logout");
//                .authorizeRequests()
//                .antMatchers("/", "/login", "/all").permitAll()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//
//                .formLogin().usernameParameter("name").passwordParameter("password")
//                .loginPage("/login")
//                .loginProcessingUrl("/login_k")
//                .defaultSuccessUrl("/ping")
//                .successHandler(successHandler())
//                .failureUrl("/login")
//                .and()
//
//                .logout()
//                .permitAll();

    }
    
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("1")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        // authenticationProvider.setPasswordEncoder(passwordEncoder()); //패스워드를 암호활 경우 사용한다
        return authenticationProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler("/ping");//default로 이동할 url
    }
}
