# LeetCode 176 Second Highest Salary
# Write your MySQL query statement below

select ifnull((select Salary from Employee group by Salary order by Salary DESC limit 1,1),NULL) as SecondHighestSalary;
