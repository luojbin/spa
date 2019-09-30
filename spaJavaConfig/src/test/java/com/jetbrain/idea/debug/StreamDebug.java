package com.jetbrain.idea.debug;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamDebug {
    public static void main(String[] args) {
        int[] arrays = new int[]{5,-5,2,7,9,2,-2,-2,1,-1};
        int[] n2s = Arrays.stream(arrays)
                .flatMap(n -> IntStream.of(n * n))
                .distinct()
                .sorted()
                .toArray();
        System.out.println(n2s);

    }

}

