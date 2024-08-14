public class Main {
    public static int soln(String a) {
        // 2진수로 변환
        int[] binaryA = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            binaryA[i] = a.charAt(i) - '0';
        }

        // 0인 자리를 1로 바꾸어 만들 수 있는 가장 큰 수 찾기
        int maxNum = 0;
        for (int i = 0; i < binaryA.length; i++) {
            if (binaryA[i] == 0) {
                binaryA[i] = 1;
                int num = convertToDecimal(binaryA);
                maxNum = Math.max(maxNum, num);
                binaryA[i] = 0;
            }
        }

        // 입력이 "1"일 때는 0을 반환
        if (a.equals("1")) {
            return 0;
        }

        return maxNum;
    }

    private static int convertToDecimal(int[] binaryArray) {
        int decimal = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            decimal = decimal * 2 + binaryArray[i];
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(soln("1")); // 0
        System.out.println(soln("1010")); // 14
    }
}