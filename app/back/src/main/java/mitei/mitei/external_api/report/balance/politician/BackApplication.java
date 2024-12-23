package mitei.mitei.external_api.report.balance.politician;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーション全体起動
 */
@SpringBootApplication
public class BackApplication { // NOPMD

    /**
     * 全体起動
     *
     * @param args 引数
     */
    public static void main(final String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

}
