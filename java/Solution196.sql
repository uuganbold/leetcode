delete from Person where Id not in 
    (select id from (select min(p.id) as id from Person p group by email) t)