class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2 + result[i + j + 1];
                result[i + j + 1] = mul % 10;
                result[i + j] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k < result.length && result[k] == 0) k++;
        while (k < result.length) sb.append(result[k++]);

        return sb.toString();
    }
}
