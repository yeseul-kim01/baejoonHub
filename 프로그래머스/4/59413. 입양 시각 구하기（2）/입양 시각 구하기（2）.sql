-- 코드를 입력하세요
-- 입양 순으로 테이블 정렬한 뒤에 datetime 으로 그룹화하고 카운트하기
SET @HOUR := -1;

SELECT (@HOUR := @HOUR + 1) AS HOUR,
       (SELECT COUNT(*) 
        FROM ANIMAL_OUTS 
        WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;