package com.mkyong.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
public class BenchmarkForEach {


    private String[] DATA_FOR_TESTING_ARRAY = createArray();
    private List<String> DATA_FOR_TESTING_LIST = Arrays.asList(createArray());

    public static void main(String[] argv) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkForEach.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        DATA_FOR_TESTING_ARRAY = createArray();
        DATA_FOR_TESTING_LIST = Arrays.asList(createArray());
    }

    @Benchmark
    public void forEachArray(Blackhole bh) {
        for (String i : DATA_FOR_TESTING_ARRAY) {
            bh.consume(i);
        }
    }

    @Benchmark
    public void forEachList(Blackhole bh) {
        for (String i : DATA_FOR_TESTING_LIST) {
            bh.consume(i);
        }
    }
    private static String[] createArray() {
        int N = 10_000_000;

        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = "Array " + i;
        }
        return array;
    }



}
