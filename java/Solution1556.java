class Solution1556 {

    /*
     * T: O(N) S: O(N) N<10
     */
    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        StringBuilder ans = new StringBuilder();

        int numOfDot = num.length() / 3;
        int firstDot = num.length() % 3;

        if (firstDot == 0) {
            numOfDot--;
            firstDot = 3;
        }

        ans.append(num.substring(0, firstDot));

        int i = firstDot;
        while (numOfDot > 0) {
            ans.append(".");
            ans.append(num.substring(i, i + 3));
            i += 3;
            numOfDot--;
        }

        return ans.toString();
    }
}