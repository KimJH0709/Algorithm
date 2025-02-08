-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(u.city, ' ', u.street_address1, ' ', u.street_address2) as '전체주소', concat(LEFT(tlno,3), '-', MID(tlno,4,4),'-', RIGHT(tlno,4)) AS 전화번호
from USED_GOODS_BOARD b
    join USED_GOODS_USER u
    on b.writer_id = u.user_id
group by writer_id
having count(writer_id) >= 3
order by u.user_id desc