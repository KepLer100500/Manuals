from typing import List
import heapq
from collections import defaultdict


class Twitter:

    def __init__(self):
        self.timestamp = 0
        self.tweets = defaultdict(list)  # user_id -> [(time, tweet_id), ...]
        self.following = defaultdict(set)  # follower_id -> {followee_id}

    def post_tweet(self, user_id, tweet_id):
        self.tweets[user_id].append((self.timestamp, tweet_id))
        self.timestamp += 1

    def get_news_feed(self, user_id) -> List[int]:
        # Collect all users whose tweets we need (self + following)
        users = self.following[user_id] | {user_id}

        # Use heap to merge sorted lists
        heap = []
        for uid in users:
            tweets = self.tweets[uid]
            if tweets:
                # Start with the last tweet of each user
                idx = len(tweets) - 1
                time, tweet_id = tweets[idx]
                heapq.heappush(heap, (-time, tweet_id, uid, idx))

        result = []
        while heap and len(result) < 10:
            neg_time, tweet_id, uid, idx = heapq.heappop(heap)
            result.append(tweet_id)
            if idx > 0:
                idx -= 1
                time, tid = self.tweets[uid][idx]
                heapq.heappush(heap, (-time, tid, uid, idx))

        return result

    def follow(self, follower_id, followee_id):
        self.following[follower_id].add(followee_id)

    def unfollow(self, follower_id, followee_id):
        self.following[follower_id].discard(followee_id)


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
twitter = Twitter()
twitter.follow(1, 2)
twitter.follow(1, 3)
twitter.post_tweet(2, 4)
twitter.post_tweet(2, 6)
twitter.post_tweet(3, 2)
twitter.post_tweet(3, 7)
twitter.post_tweet(3, 3)
twitter.post_tweet(3, 8)
twitter.post_tweet(2, 1)
twitter.post_tweet(2, 9)
twitter.follow(1, 4)
twitter.post_tweet(4, 5)
twitter.post_tweet(4, 10)
twitter.unfollow(1, 2)
twitter.post_tweet(5, 11)
twitter.post_tweet(5, 12)
twitter.post_tweet(5, 13)
twitter.post_tweet(6, 14)
twitter.follow(1, 5)
twitter.post_tweet(7, 15)
twitter.post_tweet(7, 16)
twitter.post_tweet(7, 17)
twitter.post_tweet(7, 18)
twitter.follow(1, 7)
print(twitter.get_news_feed(1))
'''
