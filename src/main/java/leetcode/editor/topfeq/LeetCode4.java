package leetcode.editor.topfeq;


//todo

public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1,2} ;
        int[] nums2 = {3,4};

        LeetCode4 solution=new LeetCode4();
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int low1=0;
        int high1=nums1.length-1;
        int mid1=(low1+high1)/2;

        int low2=0;
        int high2=nums2.length-1;
        int mid2=(low2+high2)/2;

        while (    0<= mid1 && mid1<= nums1.length-1
                && 0<= mid2 && mid2<= nums2.length-1){


            if (nums1[mid1]!=nums2[mid2]  ){
                return nums1[mid1];
            }
            else if (nums2[mid2]>nums1[mid1]){
                low1=mid1+1;
                high2=mid2-1;
            }else if (nums2[mid2]<nums1[mid1]){
                high1=mid1-1;
                low2=mid2+1;
            }
            mid1=(low1+high1)/2;

            mid2=(low2+high2)/2;
        }


        int result=(mid1+mid2)/2;

        return 0;
    }
}
