# Write your MySQL query statement below
select id, 
MAX(case when month='Jan' then revenue else null end) Jan_Revenue,
MAX(case when month='Feb' then revenue else null end) Feb_Revenue,
MAX(case when month='Mar' then revenue else null end) Mar_Revenue,
MAX(case when month='Apr' then revenue else null end) Apr_Revenue,
MAX(case when month='May' then revenue else null end) May_Revenue,
MAX(case when month='Jun' then revenue else null end) Jun_Revenue,
MAX(case when month='Jul' then revenue else null end) Jul_Revenue,
MAX(case when month='Aug' then revenue else null end) Aug_Revenue,
MAX(case when month='Sep' then revenue else null end) Sep_Revenue,
MAX(case when month='Oct' then revenue else null end) Oct_Revenue,
MAX(case when month='Nov' then revenue else null end) Nov_Revenue,
MAX(case when month='Dec' then revenue else null end) Dec_Revenue
from Department
group by id;