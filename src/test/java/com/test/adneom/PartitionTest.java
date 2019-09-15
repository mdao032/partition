package com.test.adneom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;

public class PartitionTest {

    public IOException OkioException = new IOException("test ok");

    public IOException NotOkioException = new IOException("test not ok");

    @Test
    public void testFuncPartitionWithOKResponse() throws IOException{
        try {
            Assert.assertEquals(2,
                    Partition.partition(Arrays.asList(1, 2, 3, 5, 9, 11), 3).length);
            throw new IOException("test ok");
        } catch (IOException e) {
            Assert.assertThat(e.getMessage(), equalTo(OkioException.getMessage()));
        }
    }

    @Test
    public void testFuncPartitionWithNotOKResponse() throws IOException {

        try {
            Assert.assertNotSame(3,
                    Partition.partition(Arrays.asList(1, 2, 3, 5, 9, 11), 3).length);
            throw new IOException("test not ok");
        } catch (IOException e) {
            Assert.assertThat(e.getMessage(), equalTo(NotOkioException.getMessage()));
        }
    }
}
