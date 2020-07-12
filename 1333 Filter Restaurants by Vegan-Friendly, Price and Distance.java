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

/**
Key Insights

Sort the array on the basis of ratings. If two restaurants have the same rating, sort them on the basis of their IDs. 
Example: 
    Arrays.sort(restaurants, (a, b) -> { 
        if (a[rating] == b[rating]) { 
            return b[id] - a[id]; 
        } else 
            return b[rating] - a[rating]; });

b - a -> decreasing order sort
a - b -> increasing order sort
*/