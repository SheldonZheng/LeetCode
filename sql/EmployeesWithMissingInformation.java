SELECT
    employee_id
FROM
    (SELECT employee_id FROM Employees
    UNION ALL
    SELECT employee_id FROM Salaries) 
    as ans
GROUP BY
    ans.employee_id
HAVING
    COUNT(employee_id) = 1
ORDER BY 
    employee_id;

