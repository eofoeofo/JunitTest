package com.koreait.junittest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {

    @Test
    public void test1() {
        assertNotNull(Query.getConn());
    }

}
