package algo.nocategory;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
Flatten a Dictionary
A dictionary is a type of data structure that is supported natively in all major interpreted languages such as
JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively.
In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of any
primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
However, for this exercise assume that values are either a string or another dictionary.

Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it.
input:  dict = {
    "Key1" : "1",
    "Key2" : {
        "a" : "2",
        "b" : "3",
        "c" : {
            "d" : "3",
            "e" : "1"
        }
    }
}

output: {
    "Key1" : "1",
    "Key2.a" : "2",
    "Key2.b" : "3",
    "Key2.c.d" : "3",
    "Key2.c.e" : "1"
    }
 */
public class FlattenADictionary {
    public static Map<String, String> flattenDict(Map<String, Object> dict) {
        return flattenDictHelper(new HashMap<String, String>(), "", dict);
    }

    private static Map<String, String> flattenDictHelper(Map<String, String> m,
                                                         String key,
                                                         Object dict) {
        if (dict instanceof Map) {
            for (Object e : ((Map) dict).entrySet()) {
                Entry<String, Object> ee = (Entry<String, Object>) e;
                if (key.equals("")) {
                                    flattenDictHelper(m, ee.getKey(), ee.getValue());
                } else {
                    flattenDictHelper(m, key + "." + ee.getKey(), ee.getValue());
                }
            }
        } else {
            m.put(key, (String) dict);
        }
        return m;
    }

    public static void main(String[] args) {
        Map<String, Object> m =
                ImmutableMap.of(
                "key1", "1",
                "key2",
                    ImmutableMap.of(
                    "a", "2",
                    "b", "3",
                    "c",
                            ImmutableMap.of(
                                    "d", "3",
                                    "e", "1")));
        System.out.println(flattenDict(m));
    }
}
