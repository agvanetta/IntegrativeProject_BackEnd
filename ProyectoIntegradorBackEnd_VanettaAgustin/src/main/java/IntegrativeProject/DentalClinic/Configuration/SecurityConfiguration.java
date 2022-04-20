package IntegrativeProject.DentalClinic.Configuration;

import IntegrativeProject.DentalClinic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
              /*    .authorizeHttpRequests()
                .antMatchers("/user/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin().and()
                .httpBasic();*/
              .authorizeRequests()
                .antMatchers("/dentists/**","/patients/**" ).hasAuthority("ADMIN")
                .antMatchers("/appointments/**").hasAuthority("USER")
                .antMatchers("/dentistsList.html","/dentistNew.html","/patientsList.html","/patientNew.html")
                .hasAuthority("ADMIN")
                .antMatchers("/appointmentsList.html","/appointmentNew.html")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

}
