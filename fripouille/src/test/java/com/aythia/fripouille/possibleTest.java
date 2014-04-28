package com.aythia.fripouille;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class possibleTest {

    @Test
    public void testAnswer() {
         assertThat(42, is(new Grid().answer()));
    }

    @Test
    public void loadJsonFromResourceFolder()  {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject  = null;
        try {
            String fileFullPAth = getClass().getResource("/loadTest.json").getPath();
            jsonObject = (JSONObject) parser.parse(new FileReader(fileFullPAth));

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(jsonObject, is(notNullValue()));
        assert jsonObject != null;
        assertThat("name", is(equalTo(jsonObject.get("propertyString"))));
        Long longAnswer = (Long) jsonObject.get("propertyInt");
        assertThat(42, is(equalTo(longAnswer.intValue())));
    }

}