class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key=lambda c : c[1])
        h = []
        day = 0
        for duration, lastDay in courses:
            if day + duration <= lastDay:
                day += duration
                heappush(h, -duration)
            elif h and duration < -h[0]:
                day -= -heapreplace(h, -duration) - duration
        return len(h)
