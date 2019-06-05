//LeetCode 811
class Solution {
     public List<String> subdomainVisits(String[] cpdomains) {
        if (null == cpdomains) {
            return null;
        }
        Map<String,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String str = cpdomains[i];
            String[] splitedOne = str.split(" ");
            Integer num = Integer.valueOf(splitedOne[0]);
            String domains = splitedOne[1];

            String[] splitedDomains = domains.split("\\.");

            resultMap.put(domains,resultMap.containsKey(domains) ? resultMap.get(domains) + num : num);

            if (splitedDomains.length > 2) {
                String one = splitedDomains[1].concat(".").concat(splitedDomains[2]);
                String two = splitedDomains[2];

                resultMap.put(one,resultMap.containsKey(one) ? resultMap.get(one) + num : num);
                resultMap.put(two,resultMap.containsKey(two) ? resultMap.get(two) + num : num);
            } else {
                String two = splitedDomains[1];
                resultMap.put(two,resultMap.containsKey(two) ? resultMap.get(two) + num : num);
            }

        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            result.add(sb.toString());
        }
        return result;

    }
}
