class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else  {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < m || j < n) {
                if (i >= m && j < n) {
                    merged[k++] = nums2[j++];
                }
                if (j >= n && i < m) {
                    merged[k++] = nums1[i++];
                }
                if (i < m && j < n && nums1[i] < nums2[j]) {
                    merged[k++] = nums1[i++];
                } else if (j < n){
                    merged[k++] = nums2[j++];
                }
            }
        }
        for (int i = 0; i < merged.length; i++) {
            nums1[i] = merged[i];
        }
    }
}