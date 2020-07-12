class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            
            return b[1] - a[1];
        });
        
        List<Integer> list = new ArrayList<>();
        for (int[] rest : restaurants) {
            if (veganFriendly == 1 && rest[2] == 0) {
                continue;
            }
            
            if (rest[3] > maxPrice || rest[4] > maxDistance) {
                continue;
            }
            
            list.add(rest[0]);
        }
        
        return list;
    }
}