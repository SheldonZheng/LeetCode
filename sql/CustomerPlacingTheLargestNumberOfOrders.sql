SELECT
    customer_number
FROM
    orders
GROUP BY customer_number
HAVING COUNT(*) = (
    SELECT
        COUNT(*) AS 'cnt'
    FROM
        orders
    GROUP BY customer_number
    ORDER BY cnt DESC
    LIMIT 1
);
