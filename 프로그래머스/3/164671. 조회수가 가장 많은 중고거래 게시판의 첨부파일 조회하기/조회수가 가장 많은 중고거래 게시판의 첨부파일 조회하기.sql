-- 코드를 입력하세요
SELECT concat('/home/grep/src/', B.board_id, '/'
             , f.file_id, f.file_name, f.file_ext) as file_path
from  USED_GOODS_BOARD b
    left join used_goods_file f
    on b.board_id = f.board_id
where views = (select max(views) from used_goods_board)
order by f.file_id desc