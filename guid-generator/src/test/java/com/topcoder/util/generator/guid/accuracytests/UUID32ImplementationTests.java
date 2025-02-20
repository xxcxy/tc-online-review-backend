/**
 * GUID Generator 1.0
 *
 * UUID32ImplementationTests.java
 *
 * Copyright � 2004, TopCoder, Inc. All rights reserved
 */

package com.topcoder.util.generator.guid.accuracytests;

import java.util.Arrays;

import com.topcoder.util.generator.guid.AbstractUUID;
import com.topcoder.util.generator.guid.UUID;
import com.topcoder.util.generator.guid.UUID32Implementation;

import junit.framework.TestCase;

/**
 * Accuracy tests for UUID32Implementation Class 
 *
 * @author valeriy
 * @version 1.0
 */

public class UUID32ImplementationTests extends TestCase {

    /**
     * Tests UUID32Implementation.getBitCount() method for accuracy. 
     */
    public void testGetBitCount() throws Exception {
        UUID32Implementation uuid = new UUID32Implementation(new byte[4]);
        assertEquals(uuid.getBitCount(), 32);
    }
    
    /**
     * Tests UUID32Implementation.toByteArray() method for accuracy. 
     */
    public void testToByteArray() throws Exception {
        byte[] bytes = new byte[] {11, 35, 47, 59};
        UUID32Implementation uuid = new UUID32Implementation(bytes);
        byte[] bytes2 = uuid.toByteArray();
        assertTrue(Arrays.equals(bytes, bytes2));
    }
    
    /**
     * Tests UUID32Implementation.toString() method for accuracy. 
     */
    public void testToString() throws Exception {
        UUID32Implementation uuid = new UUID32Implementation(new byte[] {11, 35, 47, 59});
        assertEquals("0b232f3b", uuid.toString().toLowerCase());

        uuid = new UUID32Implementation(new byte[] {0, 0, 0, 0});
        assertEquals("00000000", uuid.toString().toLowerCase());

        uuid = new UUID32Implementation(new byte[] {-1, -1, -1, -1});
        assertEquals("ffffffff", uuid.toString().toLowerCase());
    }
    
    /**
     * Tests UUID32Implementation.parse() method for accuracy. 
     */
    public void testParse() throws Exception {
        UUID uuid = AbstractUUID.parse("0b232f3b");
        assertTrue(uuid instanceof UUID32Implementation);
        assertTrue(Arrays.equals(new byte[] {11, 35, 47, 59}, uuid.toByteArray()));

        uuid = AbstractUUID.parse("00000000");
        assertTrue(uuid instanceof UUID32Implementation);
        assertTrue(Arrays.equals(new byte[] {0, 0, 0, 0}, uuid.toByteArray()));

        uuid = AbstractUUID.parse("FFFFFFFF");
        assertTrue(uuid instanceof UUID32Implementation);
        assertTrue(Arrays.equals(new byte[] {-1, -1, -1, -1}, uuid.toByteArray()));
    }
    
}
