package arrays.two_pointers;

public class ContainerWithMostWater {

    /*
    * Leetcode : 11
    *
    * Technique : 2 Pointers
    *
    * Thought : Water at any level is min(ht[l], ht[r]) * (r - l)
    *
    * Keep track of max, iterate using 2 pointer technique compute water at each level and compare with max.
    * */

    public int maxArea(int[] height) {

        int max = 0;

        int l = 0, r = height.length - 1;

        while(l < r) {

            int hl = height[l];
            int hr = height[r];
            int ht;

            if(hl < hr) {

                ht = (r - l) * hl;

                // anything smaller than or equal to hl will hold less water
                while((l < r) && hl >= height[++l]);

            } else {

                ht = (r - l) * hr;

                // anything smaller than or equal to hr will hold less water
                while((l < r) && ht >= height[--r]);

            }

            max = Math.max(max, ht);

        }

        return max;

    }

    public int maxAreaV0(int[] hts) {
        int l = 0, r = hts.length - 1;
        int maxArea = 0;

        while(l < r) {

            maxArea = Math.max(maxArea, (r - l) * ((hts[l] > hts[r]) ? hts[r--] : hts[l++]));
        }

        return maxArea;
    }

    public int maxAreaV1(int [] hts) {
        int l = 0, r = hts.length - 1;

        int maxArea = 0;

        while(l != r) {

            int distance = (r - l);
            int area = (hts[l] > hts[r]) ? hts[r--] : hts[l++];

            maxArea = Math.max(maxArea, distance * area);
        }

        return maxArea;
    }


    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(cwmw.maxArea(heights));
        System.out.println(cwmw.maxAreaV0(heights));
        System.out.println(cwmw.maxAreaV1(heights));
    }
}
