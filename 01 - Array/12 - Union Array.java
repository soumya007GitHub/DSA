import java.util.*;
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(nums1[i] == nums2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]){
                list.add(nums1[i]);
                }
                ++i;
                ++j;
            }else if(nums1[i] > nums2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != nums2[j]){
                list.add(nums2[j]);
                }
                ++j;
            }else{
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]){
                list.add(nums1[i]);
                }
                ++i;
            }
        }
        while(i < m){
            if(list.isEmpty() || list.get(list.size()-1) != nums1[i]){
                list.add(nums1[i]);
            }
                ++i;
        }
        while(j < n){
            if(list.isEmpty() || list.get(list.size()-1) != nums2[j]){
                list.add(nums2[j]);
            }
                ++j;
        }
        int index = 0;
        int[] answer = new int[list.size()];
        for(int item: list){
            answer[index] = item;
            ++index;
        }
        return answer;
    }
}