package mitei.mitei.external_api.report.balance.politician.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * クロスサイトアクセス設定
 * 
 */
@Configuration
public class CorsConfig {

    /** サイトをまたいでアクセスを許可するURL(作成側) */
    private static final String ALLOW_URL_CREATE = "http://localhost:5173";

    /** サイトをまたいでアクセスを許可するURL(調査側) */
    private static final String ALLOW_URL_INVESTGATE = "http://localhost:5373";
    
    /**
     * クロスサイトアクセスフィルタ
     *
     * @return 許可リストが挿入されたフィルタ
     */
    @Bean
    protected CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(ALLOW_URL_CREATE, ALLOW_URL_INVESTGATE));
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("Set-Cookie");

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}
