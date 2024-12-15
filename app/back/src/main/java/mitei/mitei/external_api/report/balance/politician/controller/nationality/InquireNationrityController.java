package mitei.mitei.external_api.report.balance.politician.controller.nationality;

import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mitei.mitei.external_api.report.balance.politician.dto.relation.RelationPersonDto;

/**
 * 仮想外部API:国籍問い合わせ
 */
@Controller
public class InquireNationrityController {

    /**
     * 処理を行う
     *
     * @return 関連者情報(回答挿入)
     */
    @PostMapping("/inquire-nationarity")
    public ResponseEntity<List<RelationPersonDto>> practice(final @RequestBody List<RelationPersonDto> listPerson) {

        // プロトタイプ用嘘ロジック
        final String kbnForeignText = "外国籍";
        final String kbnForeign = "1";

        final String kbnInfoText = "基礎情報不足";
        final String kbnInfo = "2";

        final String kbnJapanText = "日本国籍";
        final String kbnJapan = "3";

        for (RelationPersonDto personDto : listPerson) {
            // 電話番号が9で始まっていたら外国籍
            if (!Objects.isNull(personDto.getTel1())) {
                if (personDto.getTel1().startsWith("9")) { // NOPMD
                    personDto.setNationalityAnswerKbn(kbnForeign);
                    personDto.setNationalityAnswerKbnText(kbnForeignText);
                }
            }

            // 電話番号が7で始まっていたら基礎情報不足
            if (!Objects.isNull(personDto.getTel1())) {
                if (personDto.getTel1().startsWith("7")) { // NOPMD
                    personDto.setNationalityAnswerKbn(kbnInfo);
                    personDto.setNationalityAnswerKbnText(kbnInfoText);
                }
            }

            // それ以外は日本国籍とする
            if (!Objects.isNull(personDto.getNationalityAnswerKbn())) {
                if (!kbnInfo.equals(personDto.getNationalityAnswerKbn()) // NOPMD
                        && !kbnForeign.equals(personDto.getNationalityAnswerKbn())) {
                    personDto.setNationalityAnswerKbn(kbnJapan);
                    personDto.setNationalityAnswerKbnText(kbnJapanText);
                }
            }

        }

        return ResponseEntity.ok(listPerson);
    }

}
