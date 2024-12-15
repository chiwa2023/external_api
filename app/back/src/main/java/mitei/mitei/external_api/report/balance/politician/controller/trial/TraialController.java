package mitei.mitei.external_api.report.balance.politician.controller.trial;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 接続テスト用Controller
 */
@Controller
public class TraialController {

    /**
     * 処理を行う
     *
     * @return 接続成功文字列
     */
    @GetMapping("/test")
    public ResponseEntity<String> practice() {

        return ResponseEntity.ok("access ok!");
    }

}
