package io.getarrayus.securecapita;
import org.keycloak.adapters.authorization.integration.jakarta.ServletPolicyEnforcerFilter;
import org.keycloak.adapters.authorization.spi.ConfigurationResolver;
import org.keycloak.adapters.authorization.spi.HttpRequest;
import org.keycloak.representations.adapters.config.PolicyEnforcerConfig;
import org.keycloak.util.JsonSerialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(t -> t.disable());
        http.authorizeHttpRequests(authorize -> {
            authorize
                    //.requestMatchers(HttpMethod.POST, "/zamowienie/zapis").permitAll()
                    .requestMatchers(HttpMethod.POST, "/pay").permitAll()
                    .requestMatchers(HttpMethod.GET, "/cancel").permitAll()
                    .requestMatchers(HttpMethod.GET, "/success").permitAll()
                  //  .requestMatchers(HttpMethod.GET, "/zamowienie/odczyt").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/essa/zamowienie").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/essa/").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/essa/zamowienie2").permitAll()
                    //.requestMatchers(HttpMethod.POST, "/calosc2/d").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/essa/zamowienie2").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/api/v1/klient").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/api/v1/klient2").permitAll()
//                    .requestMatchers(HttpMethod.GET, "/api/v1/klient3").permitAll()
                    .requestMatchers(HttpMethod.GET, "/diety/*").permitAll()
                   // .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                    .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                   .anyRequest().authenticated();

        });
        http.oauth2ResourceServer(t-> {
            t.jwt(Customizer.withDefaults());
        });
        http.sessionManagement(
                t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        return http.build();
    }

    @Bean
    public DefaultMethodSecurityExpressionHandler msecurity() {
        DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        defaultMethodSecurityExpressionHandler.setDefaultRolePrefix("");
        return defaultMethodSecurityExpressionHandler;
    }

//    @Bean
//    public JwtAuthenticationConverter con() {
//        JwtAuthenticationConverter c = new JwtAuthenticationConverter();
//        JwtGrantedAuthoritiesConverter cv = new JwtGrantedAuthoritiesConverter();
//        cv.setAuthorityPrefix(""); // Default "SCOPE_"
//        cv.setAuthoritiesClaimName("roles"); // Default "scope" or "scp"
//        c.setJwtGrantedAuthoritiesConverter(cv);
//        return c;
//    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//            throws Exception {
//        http.csrf(t -> t.disable());
//        http.addFilterAfter(createPolicyEnforcerFilter(),
//                BearerTokenAuthenticationFilter.class);
//
//        http.sessionManagement(
//                t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        );
//        return http.build();
//    }
//
//
//    private ServletPolicyEnforcerFilter createPolicyEnforcerFilter() {
//        return new ServletPolicyEnforcerFilter(new ConfigurationResolver() {
//            @Override
//            public PolicyEnforcerConfig resolve(HttpRequest request) {
//                try {
//                    return JsonSerialization.readValue(getClass().getResourceAsStream("/policy-enforcer.json"),
//                            PolicyEnforcerConfig.class);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//    }



}
