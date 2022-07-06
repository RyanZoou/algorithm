package com.ryan.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法（电台覆盖问题）
 *
 * @author ryanzou
 */
public class Greedy {

    static HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

    static HashSet<String> allAreas = new HashSet<>();

    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);

        ArrayList<String> selects = new ArrayList<>();

        while (allAreas.size() > 0) {
            String maxKey = null;
            for (String key : broadcasts.keySet()) {
                // 求当前集合电台覆盖地区和所有未被覆盖地区的交集
                int currSize = getRetainSize(key);
                int maxKeySize = getRetainSize(maxKey);

                if (currSize > maxKeySize) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("最终选择的电台是：" + selects);
    }

    private static int getRetainSize(String key) {
        int size = 0;
        if (key == null || !broadcasts.containsKey(key)) {
            return size;
        }
        HashSet<String> hashSet = broadcasts.get(key);
        for (String area: hashSet) {
            if (allAreas.contains(area)) {
                size ++;
            }
        }
        return size;
    }

}
