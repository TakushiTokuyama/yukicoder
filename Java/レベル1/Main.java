package レベル1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        no5();
    }

    // No.5 数字のブロック
    private static void no5() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 箱の幅
        String l;
        // ブロックの数
        String n;
        // 各ブロックの幅
        String block;

        try {
            l = reader.readLine();
            n = reader.readLine();
            block = reader.readLine();
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        int[] numbers = Stream.of(block.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int width = Integer.parseInt(l);

        int max = 0;

        for (int i : numbers) {
            if (i <= width) {
                width -= i;
                max++;
            } else {
                break;
            };
        }
        System.out.println(max);
    }
}