package com.example.spring0607.config.jwt;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                //토큰을 사용하는 경우만 접근 가능하도록 함
                .anyRequest().permitAll().and()
                //토큰으로 security를 적용하기 때문에 session은 stateless로 막아줌
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //form기반의 로그인은 허용 X
                .formLogin().disable();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        //BCrypt 해시 함수를 사용하여 비밀번호를 암호화함
        return new BCryptPasswordEncoder();
    }
}
