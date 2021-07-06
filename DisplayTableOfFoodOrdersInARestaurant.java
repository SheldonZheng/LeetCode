/**
 * LeetCode 1418 Display Table of Food Orders in a Restaurant
 */
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        if (orders == null || orders.size() == 0) {
            return orders;
        }
        Set<String> namesSet = new HashSet<>();
        Map<Integer, Map<String,Integer>> foodCountContainer = new HashMap<>();

        for (List<String> order : orders) {
            namesSet.add(order.get(2));
            Integer id = Integer.valueOf(order.get(1));
            Map<String, Integer> foodNums = foodCountContainer.getOrDefault(id, new HashMap<>());
            Integer curNums = foodNums.getOrDefault(order.get(2), 0);
            foodNums.put(order.get(2),curNums + 1);
            foodCountContainer.put(id,foodNums);
        }
        List<String> nameList = namesSet.stream().collect(Collectors.toList());
        Collections.sort(nameList);

        List<Integer> ids = foodCountContainer.keySet().stream().collect(Collectors.toList());
        Collections.sort(ids);

        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String name : nameList) {
            header.add(name);
        }
        result.add(header);

        for (Integer id : ids) {
            List<String> curList = new ArrayList<>();
            curList.add(id.toString());
            Map<String, Integer> foodCount = foodCountContainer.get(id);
            for (String name : nameList) {
                Integer count = foodCount.getOrDefault(name,0);
                curList.add(count.toString());
            }
            result.add(curList);
        }

        return result;
    }
}
