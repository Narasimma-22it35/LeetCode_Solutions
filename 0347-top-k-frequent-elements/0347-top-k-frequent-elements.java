class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        System.out.print(map);

        List<Map.Entry<Integer, Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        int res[] = new int[k];
        int index=0;
        for(int i=list.size()-1;i>=list.size()-k;i--){
            res[index++]= list.get(i).getKey();
        }
        return res;
    }}