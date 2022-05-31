# Write your MySQL query statement below
UPDATE 
    Salary
    SET
    `sex` = CASE `SEX`
    WHEN 'f' THEN 'm'
    ELSE 'f' END;
