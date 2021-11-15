public int[] twoSum(int[] nums, int target) {
      
  HashMap<Integer, Integer> nums_hash = new HashMap<>();
  
  for(int i = 0; i < nums.length; i++) {
    int rem = target - nums[i];
    
    if(nums_hash.containsKey(rem)) {
      return new int[] {nums_hash.get(rem), i};
    } else {
      nums_hash.put(nums[i], i);
    }
  }
  throw new IllegalArgumentException("N/A");
}