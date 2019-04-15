package com.example.gson;

import com.mkyong.json.Gson2Example;
import com.mkyong.json.GsonExample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        String[] args  = {};
//        GsonExample.main(args);
        Gson2Example.main(args);
    }
}