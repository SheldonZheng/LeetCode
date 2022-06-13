SELECT
    stock_name,
    sum(if(operation='Buy',-price,price)) capital_gain_loss
FROM
    stocks
GROUP BY
    stock_name;
