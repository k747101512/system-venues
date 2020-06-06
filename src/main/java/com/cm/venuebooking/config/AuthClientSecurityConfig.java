package com.cm.venuebooking.config;

import com.cm.common.config.properties.OauthProperties;
import com.cm.common.plugin.converter.ClientUserAccessTokenConverter;
import com.cm.common.plugin.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName: AuthClientSecurityConfig
 * @Description: 场馆预订系统认证配置
 * @Author: WenG
 * @Date: 2020-04-07
 **/
@EnableWebSecurity
@EnableOAuth2Sso
public class AuthClientSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OauthProperties authServer;
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private OauthProperties oauthProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/authorize", true)
                .and()
                .logout().logoutSuccessUrl(authServer.getOauthLogout())
                .and()
                .authorizeRequests().antMatchers("/app/**", "/route/file/**", "/assets/**", "/wxminiapp/**", "/route/register/**", "/api/file/**", "/api/webregister/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .access("@clientRbacService.hasPermission(request, authentication)")
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .cors()
                .and()
                .csrf().disable();
    }

    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jwtTokenStore());
        return defaultTokenServices;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(new ClientUserAccessTokenConverter(this.oauthProperties, this.restTemplateUtil));
        jwtAccessTokenConverter.setSigningKey("cmxx");
        return jwtAccessTokenConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
