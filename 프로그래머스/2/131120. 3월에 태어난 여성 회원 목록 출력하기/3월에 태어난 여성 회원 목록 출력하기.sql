-- 코드를 입력하세요
SELECT member_id, member_name, gender, date_format(Date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile
where Month(date_of_birth) = '03' and tlno != 'null' and gender = 'w'
order by member_id