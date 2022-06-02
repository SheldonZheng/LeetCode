SELECT user_id,CONCAT(Upper(left(`name`,1)),Lower(substring(`name`,2))) as `name`
FROM Users
ORDER BY user_id
