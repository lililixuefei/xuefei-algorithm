/**
链接：https://leetcode-cn.com/problems/combine-two-tables
 */
 select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;


/**
链接：https://leetcode-cn.com/problems/second-highest-salary/
 */
 select ifnull ((select distinct salary as SecondHighestSalary from Employee order by salary desc limit 1,1),null) AS SecondHighestSalary;

/**
https://leetcode-cn.com/problems/nth-highest-salary/solution/mysql-zi-ding-yi-bian-liang-by-luanz/
 */
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
  RETURN (
      SELECT
            salary
      FROM
            employee
      GROUP BY
            salary
      ORDER BY
            salary DESC
      LIMIT N, 1
  );
END

/**
https://leetcode-cn.com/problems/rank-scores/
 */
 SELECT a.Score, COUNT(DISTINCT b.Score) AS `RANK`
FROM Scores a, Scores b
WHERE a.Score <= b.Score
GROUP BY a.Id
ORDER BY `RANK`;
