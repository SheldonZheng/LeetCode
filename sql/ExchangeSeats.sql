SELECT
    IF(id % 2 = 0,id - 1,IF(id = (SELECT COUNT(DISTINCT id) FROM seat),id,id + 1)) AS id,
    student
FROM
    seat
ORDER BY id;
