SELECT
    d.name AS 'Department',
    e.name AS 'Employee',
    e.salary AS 'Salary'
FROM employee e JOIN department d ON e.departmentId = d.id
WHERE
    (e.departmentId , e.salary) IN 
    (
        SELECT
            departmentId,MAX(salary)
        FROM
            employee
        GROUP BY departmentId
    )
