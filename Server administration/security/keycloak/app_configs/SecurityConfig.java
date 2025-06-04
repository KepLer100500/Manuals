package com.kepler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import java.util.stream.Stream;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new MvcRequestMatcher(introspector, "/"))
                        .permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspector, "/login"))
                        .permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspector, "/VAADIN/**"))
                        .permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspector, "/vaadin/**"))
                        .permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspector, "/images/**"))
                        .permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspector, "/crm/**"))
                        .hasRole("MANAGER")
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable())
                //.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin())
                );

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtAuthenticationConverter.setPrincipalClaimName("preferred_username");
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            var authorities = jwtGrantedAuthoritiesConverter.convert(jwt);
            var roles = jwt.getClaimAsStringList("spring_sec_roles");

            return Stream.concat(authorities.stream(),
                            roles.stream()
                                    .filter(role -> role.startsWith("ROLE_"))
                                    .map(SimpleGrantedAuthority::new)
                                    .map(GrantedAuthority.class::cast))
                    .toList();
        });
        return jwtAuthenticationConverter;
    }

    @Bean
    public OAuth2UserService<OidcUserRequest, OidcUser> oAuth2UserService() {
        var oidcUserService = new OidcUserService();
        return userRequest -> {
            var oidcUser = oidcUserService.loadUser(userRequest);
            var roles = oidcUser.getClaimAsStringList("spring_sec_roles");
            var authorities = Stream.concat(oidcUser.getAuthorities().stream(),
                            roles.stream()
                                    .filter(role -> role.startsWith("ROLE_"))
                                    .map(SimpleGrantedAuthority::new)
                                    .map(GrantedAuthority.class::cast))
                    .toList();

            return new DefaultOidcUser(authorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
        };
    }
}
