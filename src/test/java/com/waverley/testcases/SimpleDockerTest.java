package com.waverley.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;

public class SimpleDockerTest {

    @BeforeMethod
    public void setUp() {
    }

    @Test
    public void openGoogle() {
        getDriverMetaData()._1.get("https://google.com/ncr");
    }

}
