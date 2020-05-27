select c.name as 'Customers' from Customers c where id not in (select distinct CustomerId from Orders)

select c.name as 'Customers' from Customers c left join Orders o on c.id=o.CustomerId where o.id is null