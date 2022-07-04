SELECT
    d.name AS 'Department',
    e.name AS 'Employee',
    e.salary AS 'Salary'
FROM employee e JOIN department d ON e.departmentId = d.id
WHERE
    (SELECT
        COUNT(DISTINCT e2.salary)
    FROM
        employee e2
    WHERE
        e2.salary > e.salary
        AND e.departmentId = e2.departmentId
    ) < 3;
