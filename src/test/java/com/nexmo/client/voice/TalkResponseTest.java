package com.nexmo.client.voice;

import com.nexmo.client.NexmoUnexpectedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*
 * Copyright (c) 2011-2016 Nexmo Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */public class TalkResponseTest {
    private TalkResponse response;

    @Before
    public void setUp() {
        response = TalkResponse.fromJson("{\n" +
                "  \"message\": \"Talk stopped\",\n" +
                "  \"uuid\": \"ssf61863-4a51-ef6b-11e1-w6edebcf93bb\"\n" +
                "}");
    }

    @Test
    public void testBasics() {
        assertEquals("Talk stopped", response.getMessage());
        assertEquals("ssf61863-4a51-ef6b-11e1-w6edebcf93bb", response.getUuid());
    }

    @Test
    public void testNexmoUnexpectedException() {
        try {
            TalkResponse.fromJson("{\n" +
                    "    \"unknownProperty\": \"unknown\"\n" +
                    "}");
            fail("Expected a NexmoUnexpectedException to be thrown");
        } catch (NexmoUnexpectedException e) {
            assertEquals("Failed to produce json from TalkResponse object.", e.getMessage());
        }
    }
}
