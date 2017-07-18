//
// ローカル辞書検索のテスト
//
// * JUnit 4.12を利用
//   - @Test というアノテーションをつけるとテスト関数と解釈される
//   - assertThat() みたいなのが使える
// * 日本語でわかりやすくしてみたり
//

// package com.pitecan.gyaim;

import static org.junit.Assert.*;
import org.junit.Test;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

import com.pitecan.gyaim.LocalDict;
//import com.pitecan.gyaim.SearchTask;
import com.pitecan.gyaim.Search;
//import com.pitecan.gyaim.Gyaim;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class LocalDictTest {
    //static final String 単語辞書ファイル = "app/src/main/assets/dict.txt";
    static final String 単語辞書ファイル = "/Users/masui/GyaimAndroidStudio.java/app/src/main/assets/dict.txt";

    static LocalDict localDict;
    static Search search;
    
    public LocalDictTest(){
        File file = new File(単語辞書ファイル);
        try {
            FileInputStream is = new FileInputStream(file);
            localDict = new LocalDict(is);
        } catch (IOException e) {
            System.out.println("辞書読出し失敗");
            e.printStackTrace();  
        }

        new Search();
    }
    
    @Test
    public void 単語辞書のサイズが充分大きい(){
        assertTrue(localDict.dict.size() > 10000);
    }
    
    @Test
    public void 単語登録チェック(){
        String 必須単語[] = { "漢字", "東京", "増井", "料理" };
        for(String 単語: 必須単語){
            boolean 登録されてる = false;
            for(LocalDict.DictEntry entry: localDict.dict) {
                if(entry.word().equals(単語)) 登録されてる = true;
            }
            assertTrue(登録されてる);
        }
    }

    @Test
    public void 検索テスト(){
        String 変換例リスト[][] = {
            {"kangae", "考える"},
            {"atarashii", "新しい"}
        };
        for (String[] 変換例: 変換例リスト) {
            boolean found = false;
            //LocalDict.search(変換例[0],new SearchTask());
            LocalDict.search(変換例[0]);
            assertTrue(Search.ncands > 0);
            for(String word: Search.words){
                if(word.equals(変換例[1])) found = true;
            }
            /*
            for(Candidate candidate: Search.candidates){
                if(candidate.word.equals(変換例[1])) found = true;
            }
            */
            assertTrue(found);
        }
    }
}
