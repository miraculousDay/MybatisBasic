create table `T_EMP`
(
  `empno`      int not null,
  `ename`      VARCHAR(50),
  `job`        VARCHAR(500),
  `mgr`         int,
  `hiredate`    TIMESTAMP,
  `sal`        int,
  `comm`       int,
  `deptno`     int,
  primary  key (`empno`)
)