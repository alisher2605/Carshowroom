package kz.iitu.carshowroom.Configurations;

import kz.iitu.carshowroom.Service.Impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    ClientServiceImpl memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("api/auth/**").permitAll()
                .antMatchers("/api/vehicles").permitAll()
                .antMatchers("/api/vehicles/find/").hasAnyAuthority("member","admin")
                .antMatchers("/api/users/create").permitAll()
                .antMatchers("/api/manufacturers").permitAll()/*hasAnyAuthority("VIP", "admin")*/
                .antMatchers("/api/manufacturers/create").permitAll()
                .antMatchers("/api/vehicles/available").hasAnyAuthority("VIP", "member")
                .antMatchers("/api/users").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }


}
