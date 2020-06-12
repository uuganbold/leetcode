# Write your MySQL query statement below
select w.Id from Weather w left join Weather p 
    on w.RecordDate=Date_add(p.RecordDate, interval 1 day) 
    where w.Temperature>p.Temperature;