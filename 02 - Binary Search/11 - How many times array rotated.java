class Solution {
    public int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int index = 0;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the whole segment is sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                break;
            }

            // Check left sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            // Right sorted
            else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
