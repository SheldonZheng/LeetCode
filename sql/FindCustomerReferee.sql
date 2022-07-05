SELECT
    name
FROM customer
WHERE referee_id IS null OR referee_id != 2;
