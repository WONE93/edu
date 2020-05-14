with s as (select department_id, max(salary) as maxsal
		from employees
		where department_id is not null
		group by department_id
		order by department_id)


select e.first_name
	  , e.last_name
	  , e.salary
	  , e.department_id
	  , d.department_name
from employees e
		, s
	  , departments d
where e.department_id = s.department_id
  AND e.salary = s.maxsal
  AND e.department_id = d.department_id
  



select department_id, max(salary) as maxsal
from employees
where department_id is not null
group by department_id
order by department_id
		
		