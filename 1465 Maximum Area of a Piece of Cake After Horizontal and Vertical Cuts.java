class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
        long maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length-1]);
        
        for (int i = 0; i < horizontalCuts.length-1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i+1] - horizontalCuts[i]);
        }
        
        for (int i = 0; i < verticalCuts.length-1; i++) {
            maxW = Math.max(maxW, verticalCuts[i+1] - verticalCuts[i]);
        }
        
        System.out.println("maxH " + maxH);
        System.out.println("maxW " + maxW);
        
        return (int)((maxH*maxW)%(1000000007));
    }
}