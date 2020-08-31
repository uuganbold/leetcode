public class Solution1286 {
    class CombinationIterator {

        private String characters;
        private char[] currentCombinations;
        private int[] currentIndexes;
        private int combinationLength;
        private int diff;

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            this.combinationLength = combinationLength;
            this.diff = characters.length() - combinationLength;
        }

        /*
         * T: O(M) S: O(M)
         */
        public String next() {
            if (currentCombinations == null) {
                currentCombinations = new char[combinationLength];
                currentIndexes = new int[combinationLength];
                for (int i = 0; i < combinationLength; i++) {
                    currentIndexes[i] = i;
                    currentCombinations[i] = characters.charAt(i);
                }
            } else {
                int i = currentIndexes.length - 1;
                while (currentIndexes[i] == i + diff) {
                    i--;
                }

                int oldIndex = currentIndexes[i];
                for (int j = 0; i + j < combinationLength; j++) {
                    currentIndexes[i + j] = oldIndex + j + 1;
                    currentCombinations[i + j] = characters.charAt(currentIndexes[i + j]);
                }
            }

            return new String(currentCombinations);
        }

        /*
         * O(1)
         */
        public boolean hasNext() {
            if (currentCombinations == null || currentIndexes[0] < diff) {
                return true;
            }
            return false;
        }
    }

    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters,
     * combinationLength); String param_1 = obj.next(); boolean param_2 =
     * obj.hasNext();
     */
}