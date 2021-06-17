package com.koreait.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueryTest {

    @BeforeAll // 모든 Test 이전에 최초 1회 실행
    public static void beforeAll() {
        Query.createTable();
    }

    @AfterAll
    public static void afterAll() {
        Query.dropTable();
    }

    @BeforeEach
    public void beforeEach() {
        Query.boardDelete(0);

        BoardVO vo1 = new BoardVO();
        vo1.setBtitle("E");
        vo1.setBcontent("eee");
        Query.boardInsert(vo1);

        BoardVO vo2 = new BoardVO();
        vo2.setBtitle("F");
        vo2.setBcontent("fff");
        Query.boardInsert(vo2);
    }

    @Test
    public void testA() {
        BoardVO vo1 = Query.getBoardDetail(1);
        assertEquals(vo1.getBtitle(),"E");
        assertEquals(vo1.getBcontent(),"eee");

        BoardVO vo2 = Query.getBoardDetail(1);
        assertEquals(vo2.getBtitle(),"F");
        assertEquals(vo2.getBcontent(),"fff");
    }

    @Test
    public void testB() {
        Query.boardDelete(1);
        assertNotNull(Query.getConn());
    }

    @Test
    public void testC() {
        BoardVO C = Query.getBoardDetail(1);
        Query.boardUpdate(C);

        BoardVO D = Query.getBoardDetail(2);
        Query.boardUpdate(D);
    }
}
