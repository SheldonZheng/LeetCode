SELECT 
    DISTINCT l1.num AS 'ConsecutiveNums'
FROM logs l1,logs l2,logs l3
WHERE l2.id = l1.id - 1
AND   l3.id = l2.id - 1
AND   l2.num = l1.num
AND   l3.num = l2.num;
