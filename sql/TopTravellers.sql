SELECT
    u.name,
    COALESCE(sum(r.distance),0) AS travelled_distance
FROM users u LEFT JOIN rides r ON r.user_id = u.id
GROUP BY user_id
ORDER BY travelled_distance DESC , u.name ASC;
