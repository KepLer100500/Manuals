import unittest
from solution import Twitter


class TestCleanString(unittest.TestCase):

    def test01(self):
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

        result = twitter.get_news_feed(1)
        self.assertEqual(result, [18, 17, 16, 15, 13, 12, 11, 10, 5, 8])


if __name__ == '__main__':
    unittest.main()
