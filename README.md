# Android版Gyaim using AndroidStudio

### 覚え

* テストでJSONを扱うとき、何故かbuild.gradleに以下の記述が必要

   * testCompile 'org.json:json:20140107'
   * 出典: https://stackoverflow.com/questions/29402155/android-unit-test-not-mocked

   
### わからないところ

* 署名したりAndroidManifestのバージョン番号を変えるには?