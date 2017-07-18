# Android版Gyaim
AndroidStudioでもEmacs+Makeでも開発できるようになった

* AndroidStudioでビルド/テスト
* Emacsで編集 / ```make```, ```make test```


### 覚え

* テストでJSONを扱うとき、何故かbuild.gradleに以下の記述が必要

   * `testCompile 'org.json:json:20140107'`
   * 出典: https://stackoverflow.com/questions/29402155/android-unit-test-not-mocked

   
### わからないところ

* 自動的に署名したりAndroidManifestのバージョン番号を変えるには?
* `make`でやってしまおう

### Issues

* Searchクラスの構造のリファクタリング


