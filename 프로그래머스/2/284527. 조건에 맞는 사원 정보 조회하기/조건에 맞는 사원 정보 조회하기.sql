select sum(score) as score, g.emp_no, e.emp_name, e.position, e.email
from hr_employees e
    inner join hr_grade g on e.emp_no = g.emp_no
group by year, emp_no
having g.year = '2022'
order by 1 desc
limit 1