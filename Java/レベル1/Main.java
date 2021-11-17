package レベル1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.transform.stax.StAXResult;

class Main {
    public static void main(String[] args) {
        // no5();
        // no18();
        // no21();
        no24();
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
            }
        }
        System.out.println(max);
    }

    // No.18 うーさー暗号
    private static void no18() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 入力値
        String input = "";

        char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        try {
            input = reader.readLine();
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        char[] inputs = input.toCharArray();

        StringBuilder output = new StringBuilder();

        for (int i = 0, j = 1; i < inputs.length; i++, j++) {
            // 1周したら移動距離jを初期化
            if (i % 26 == 0) {
                j = 1;
            }
            for (int k = 0; k < alphabet.length; k++) {
                if (alphabet[k] == inputs[i]) {
                    // 暗号化後のalphabetのindexを求める
                    int target = k - j;
                    if (target < 0) {
                        output.append(alphabet[26 + target]);
                    } else {
                        output.append(alphabet[target]);
                    }
                }
            }
        }
        System.out.println(output.toString());
    }

    // No.21 平均の差
    private static void no21() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 数字の個数
        int totalNumber;
        // グループ数
        String groups;
        // 数字
        String[] inputNumbers;

        try {
            String tn = reader.readLine();
            totalNumber = Integer.parseInt(tn);

            groups = reader.readLine();

            inputNumbers = new String[totalNumber];

            for (int i = 0; i < totalNumber; i++) {
                inputNumbers[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        int[] numbers = Stream.of(inputNumbers).mapToInt(Integer::parseInt).sorted().toArray();

        // 平均の差を求める
        System.out.println(numbers[totalNumber - 1] - numbers[0]);
    }

    // No.24 数当てゲーム
    private static void no24() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ターン数
        int turn;
        // 数字
        String[] inputNumbers;

        try {
            String tn = reader.readLine();
            turn = Integer.parseInt(tn);

            inputNumbers = new String[turn];

            for (int i = 0; i < turn; i++) {
                String line = reader.readLine();
                inputNumbers[i] = line;
            }
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}