-- 신고 유형

insert into oi_report_type(rtno, name) values (1, '욕설');
insert into oi_report_type(rtno, name) values (2, '비매너');
insert into oi_report_type(rtno, name) values (3, '부적절한 컨텐츠');


-- 신고

insert into oi_report(rpno, reporter, attacker, rtno, content, stat) values (1, 2, 3, 1, '욕했어요', 0);
insert into oi_report(rpno, reporter, attacker, rtno, content, stat) values (2, 2, 4, 2, '매너가 없어요', 1);
insert into oi_report(rpno, reporter, attacker, rtno, content, stat) values (3, 3, 4, 3, ';;;', 0);
insert into oi_report(rpno, reporter, attacker, rtno, content, stat) values (4, 5, 9, 1, '심한욕했어요', 0);

-- 공지사항분류

insert into oi_notice_type(ntno, name) values (1, '필독');
insert into oi_notice_type(ntno, name) values (2, '공지');

-- 공지사항

insert into oi_notice(nono, ntno, title, content) values (1, 1, '필독사항입니다!', '잘 부탁드립니다.');
insert into oi_notice(nono, ntno, title, content) values (2, 2, '공지사항입니다!', '조만간 오픈합니다.');


select 
  nono,
  n.title,
  n.content,
  nt.name
from
  oi_notice n
  inner join oi_notice_type nt on n.ntno=nt.ntno
  
-- 레시피 상세화면

select
  r.rno,
  r.uno,
  r.title,
  r.content,
  r.photo,
  r.hits,
  r.rcmd,
  r.cdt,
  r.min,
  r.lno,
  c.content commendText,
  c.cdt,
  rs.step,
  rs.photo,
  rs.content
from 
  oi_recipe r
  left outer join oi_comment c on r.rno = c.rno
  inner join oi_recipe_step rs on r.rno = rs.rno
  inner join oi_level l on r.rno = l.rno
where r.rno = 1;

-- 나를 팔로우 하는 팔로워

select
  f.follower,
  u.name,
  u.photo
from
  oi_follow f
  left outer join oi_user u on f.follower = u.uno
where
  following = 1;
  
-- 내가 팔로우 하는 사람들

select
  f.following,
  u.name,
  u.photo
from
  oi_follow f
  left outer join oi_user u on f.following = u.uno
where
  follower = 1;
  
-- 