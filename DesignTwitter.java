/**
 * LeetCode 355 Design Twitter
 */
public class Twitter {

    private Map<Integer, Set<Integer>> userFollwerList;
    private List<Map.Entry<Integer, Integer>> tweetList;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userFollwerList = new HashMap<>();
        tweetList = new ArrayList<>();

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new HashMap.SimpleEntry<Integer, Integer>(userId, tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        Set<Integer> follwers = userFollwerList.get(userId);
        for (int i = tweetList.size() - 1; i >= 0 && news.size() < 10; i--) {
            Map.Entry<Integer, Integer> userMapTweet = tweetList.get(i);
            if ((follwers != null ? follwers.contains(userMapTweet.getKey()) : false) || userMapTweet.getKey().equals(userId)) {
                news.add(userMapTweet.getValue());
            }
        }

        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> follwers = userFollwerList.getOrDefault(followerId, new HashSet<>());
        follwers.add(followeeId);
        userFollwerList.put(followerId,follwers);
        return ;
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        userFollwerList.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
        return;
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
