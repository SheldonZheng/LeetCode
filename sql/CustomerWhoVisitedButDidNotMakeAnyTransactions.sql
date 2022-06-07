SELECT
    v.customer_id,COUNT(v.customer_id) AS count_no_trans
FROM
    visits v 
LEFT JOIN transactions t on t.visit_id = v.visit_id
WHERE t.amount IS NULL
GROUP BY v.customer_id;
