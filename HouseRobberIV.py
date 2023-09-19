class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        def solve(mx: int) -> int:
            cnt = i = 0
            while i < len(nums):
                if nums[i] > mx:
                    i += 1
                else:
                    cnt += 1
                    i += 2
            return cnt
        return bisect_left(range(max(nums)), k, key=solve)
