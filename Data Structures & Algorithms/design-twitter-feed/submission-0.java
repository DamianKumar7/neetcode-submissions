class Twitter {
    private int timestamp = 0;
    private Map<Integer, Set<Integer>> followeeMap; // userId -> set of people they follow
    private Map<Integer, List<int[]>> tweets;        // userId -> list of {timestamp, tweetId}

    public Twitter() {
        followeeMap = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // by timestamp, descending

        Set<Integer> peopleToCheck = new HashSet<>();
        peopleToCheck.add(userId); // include your own tweets
        if (followeeMap.containsKey(userId)) {
            peopleToCheck.addAll(followeeMap.get(userId));
        }

        for (int person : peopleToCheck) {
            List<int[]> userTweets = tweets.get(person);
            if (userTweets == null) continue;
            // only need to look at the last 10 tweets of each person at most,
            // since older ones can never outrank 10 newer ones from elsewhere
            int start = Math.max(0, userTweets.size() - 10);
            for (int i = start; i < userTweets.size(); i++) {
                maxHeap.add(userTweets.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // optional safety, problem usually guarantees distinct
        followeeMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followeeMap.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}