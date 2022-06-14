SELECT
    p.product_id,
    p.product_name
FROM product p
WHERE 
    p.product_id IN (SELECT DISTINCT product_id FROM sales WHERE sale_date >= '2019-01-01' AND sale_date <= '2019-03-31')
    AND p.product_id NOT IN 
    (SELECT product_id FROM sales WHERE sale_date < '2019-01-01' OR sale_date > '2019-03-31');

