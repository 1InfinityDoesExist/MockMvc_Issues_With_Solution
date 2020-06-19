package com.junit.unittesting.controller.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

  String actualResponse = "{\"id\":1,\"name\":\"Avinash\",\"price\":10,\"quantity\":14}";

  @Test
  public void jsonAssert_StrictTrue() throws JSONException {
    String expectedResponse = "{\"id\":1,\"name\":\"Avinash\",\"price\":10,\"quantity\":14}";
    JSONAssert.assertEquals(expectedResponse, actualResponse, true);
  }

  @Test
  public void jsonAssert_StrictFalse() throws JSONException {
    String expectedResponse = "{\"id\":1,\"name\":\"Avinash\", \"quantity\":14}";
    JSONAssert.assertEquals(expectedResponse, actualResponse, false);
  }
}
