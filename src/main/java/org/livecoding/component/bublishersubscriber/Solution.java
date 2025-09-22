package org.livecoding.component.bublishersubscriber;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
//    public int solution(int[] A) {
//        int n = A.length;
//
//        Set<Integer> set = Arrays.stream(A)
//                .boxed()
//                .filter(nn -> nn > 0)
//                .collect(Collectors.toCollection(HashSet::new));
//
//        for (int i = 1; i <= n + 1; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//
//        return 1;
//    }

    public void main(/*int[] A*/) {
        int[] A = {51, 71, 17, 42};
        int n = A.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i < n; i++ ) {
            var sum = Arrays.stream(String.valueOf(A[i]).chars().toArray()).sum();
            map.computeIfAbsent(sum, s -> new ArrayList<>()).add(A[i]);
        }

        var ff = map
                .values()
                .stream()
                .filter(gg -> gg.size() >= 2)
                .map(comb -> {
                    int max = comb.get(0);
                    for (int i = 0; i < A.length; i++) {
                        for (int j = i + 1; j < A.length; j++) {
                            var sum = A[i] + A[j];
                            if (sum > max) {
                                max = sum;
                            }
                        }
                    }
                    return max;
                })
                .max(Integer::compare)
                .orElse(-1);


        System.out.println(ff);
//        return map
//                .values()
//                .stream()
//                .filter(gg -> gg.size() >= 2)
//                .map(comb -> {
//                    int max = comb.get(0);
//                    for (int i = 0; i < A.length; i++) {
//                        for (int j = i + 1; j < A.length; j++) {
//                            var sum = A[i] + A[j];
//                            if (sum > max) {
//                                max = sum;
//                            }
//                        }
//                    }
//                    return max;
//                })
//                .max(Integer::compare)
//                .orElse(-1);

    }
}
