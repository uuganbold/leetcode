# Write your MySQL query statement below
select name as Employee from Employee e1 where Salary > (select Salary from Employee where id=e1.ManagerId )

select a.Name as 'Employee' from Employee as a, Employee as b where a.ManagerId=b.Id and a.Salary>b.Salary

SELECT
     a.NAME AS Employee
FROM Employee AS a JOIN Employee AS b
     ON a.ManagerId = b.Id
     AND a.Salary > b.Salary
;