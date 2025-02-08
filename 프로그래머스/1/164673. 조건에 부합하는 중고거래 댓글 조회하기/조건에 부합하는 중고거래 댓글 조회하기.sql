-- 코드를 입력하세요
SELECT A.TITLE
        , A.BOARD_ID
        , B.REPLY_ID
        , B.WRITER_ID
        , B.CONTENTS
        , DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') AS CRAETED_DATE
from USED_GOODS_BOARD as a
inner join USED_GOODS_REPLY as b
on a.board_id = b. board_id
where Year(a.created_date) = '2022' and Month(a.created_date) = '10'
order by b.CREATED_DATE asc, a.title asc;