# external_api

外部のAPIにアクセスしないとできない機能に対して、仮にAPIを想定するためのRepository

## プロジェクト構成

### 1.pure_dto

- シミュレートされたAPIを簡単に使えるよう、接続用のDtoだけを提供するMavenプロジェクト。
- 他システムのBack側からWebClientで接続するときは、そのプロジェクトにも導入必要(導入ファイルを最小限に抑える方向で)

### 2.back

- 実際にリクエストをうけてレスポンスを返すSpring Bootプロジェクト。
- ダミーなので機能は適当
- pure_dtoをライブラリとして取り込んでいる

## 起動

- backディレクトリからPowerShellを起動し `./mvn spring-boot:run`
- 起動ポートは作成側とも調査側ともかぶらない7080
- CorsCinfigでフロント側受け入れポートの設定が必要
