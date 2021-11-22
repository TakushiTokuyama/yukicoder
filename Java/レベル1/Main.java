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

class Main {
    public static void main(String[] args) {
        // no5();
        // no18();
        // no21();
        // no24();
        // no26();
        // no29();
        // no32();
        // no35();
        no46();
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

    // No.26 シャッフルゲーム
    private static void no26() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // カップの位置
        int correct;
        // 回数
        int turn;
        // 入れ替え位置
        int[][] replacement;

        try {
            String co = reader.readLine();
            correct = Integer.parseInt(co);

            String tn = reader.readLine();
            turn = Integer.parseInt(tn);

            replacement = new int[turn][];

            for (int i = 0; i < turn; i++) {
                String line = reader.readLine();
                replacement[i] = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        String[] cups = new String[3];

        cups[correct - 1] = String.valueOf(correct);

        for (int i = 0; i < replacement.length; i++) {
            String cup = cups[replacement[i][0] - 1];
            cups[replacement[i][0] - 1] = cups[replacement[i][1] - 1];
            cups[replacement[i][1] - 1] = cup;
        }

        for (int i = 0; i < cups.length; i++) {
            if (cups[i] != null) {
                System.out.println(i + 1);
            }
        }
    }

    // No.29 パワーアップ
    private static void no29() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 敵を倒す回数
        int turn;
        // もらえるアイテム
        int[] itemList;

        try {
            String co = reader.readLine();
            turn = Integer.parseInt(co);

            int[][] items = new int[turn][];

            itemList = new int[turn * 3];

            for (int i = 0, k = 0; i < turn; i++) {
                String line = reader.readLine();
                items[i] = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < 3; j++) {
                    itemList[k] = items[i][j];
                    k++;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        Arrays.sort(itemList);

        // レベルアップ回数
        int count = 0;

        // 重複値と任意の値をカウントする
        for (int i = 0, j = 0; i < itemList.length; i++) {

            if (i == itemList.length - 1) {
                j++;
                count += (j / 4);
                break;
            }

            if (itemList[i] == itemList[i + 1]) {
                count++;
                i++;
                if (i == itemList.length - 1) {
                    count += (j / 4);
                    break;
                }
            } else {
                j++;
            }
        }

        System.out.println(count);
    }

    // No.32 貯金箱の憂鬱
    private static void no32() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 100円硬貨
        int $100;
        // 25円硬貨
        int $25;
        // 1円硬貨
        int $1;

        try {
            String L = reader.readLine();
            $100 = Integer.parseInt(L);
            String M = reader.readLine();
            $25 = Integer.parseInt(M);
            String N = reader.readLine();
            $1 = Integer.parseInt(N);

            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        int total = 0;

        total += $1 - 25 * ($1 / 25);
        $25 += $1 / 25;
        total += $25 - 4 * ($25 / 4);
        $100 += $25 / 4;
        total += $100 - 10 * ($100 / 10);

        System.out.println(total);
    }

    // タイパー高橋
    private static void no35() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 100円硬貨
        int n;
        // 時間
        int[] t;
        // 文字列
        String[] m;

        try {
            String L = reader.readLine();
            n = Integer.parseInt(L);

            t = new int[n];
            m = new String[n];

            for (int i = 0; i < n; i++) {
                String tm = reader.readLine();
                String[] array = tm.split(" ");
                t[i] = Integer.parseInt(array[0]);
                m[i] = array[1];
            }

            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        // 一文字あたりの入力時間
        double inputTime = 1000d / 12d;

        // 成功
        int typeOk = 0;

        // 打ち漏らし
        int typeMiss = 0;

        for (int i = 0; i < n; i++) {
            int typeCorrect = (int) (t[i] / inputTime);

            if (typeCorrect == 0) {
                typeMiss += m[i].length();
                continue;
            }

            if (m[i].length() <= typeCorrect) {
                typeOk += m[i].length();
            } else {
                typeOk += typeCorrect;
                typeMiss += m[i].length() - typeCorrect;
            }
        }

        System.out.println(typeOk + " " + typeMiss);
    }

    // はじめのn歩
    private static void no46() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 一歩
        int a;
        // 区間
        int b;

        try {
            String line = reader.readLine();
            String[] lines = line.split(" ");

            a = Integer.parseInt(lines[0]);
            b = Integer.parseInt(lines[1]);

            reader.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        System.out.println((b / a) + (b % a == 0 ? 0 : 1));
    }
}