// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package type.dictionary;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringValueClientTest {

    private final StringValueClient client = new DictionaryClientBuilder().buildStringValueClient();

    @Test
    public void get() {
        Map<String, String> response = client.get();
        Assertions.assertEquals("hello", response.get("k1"));
        Assertions.assertEquals("", response.get("k2"));
    }

    @Test
    public void put() {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "hello");
        map.put("k2", "");
        client.put(map);
    }
}
