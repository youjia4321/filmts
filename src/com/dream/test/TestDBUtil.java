package com.dream.test;

import com.dream.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;

public class TestDBUtil {

    @Test
    public void testDB() throws Exception {
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
    }

}
