1.加载驱动
Class.forName(“orcle.jdbc.driver.OrcaleDriver”); //orcle的
Class.forName(“com.mysql.jdbc.Driver.”); //mysql的
2.创建连接
Connection con = DrriverManager.getConnection(“jdbc:orcale:thin:@localhost:1521:数据库名”，用户名，密码);
3.创建语句
PreparedStatement ps = con.prepareStatement(“select * from emp where sal between ? and ?”);
ps.setIn(1,1000);
Ps.setString(2,”你”);
4.执行语句
ResultSet  rs = ps.excuteQuery();
5.处理结果
while(rs.next()){
Sys.out.println(rs.getInt(“empno”)+”-”+rs,getString(“ename”));
}
6.关闭资源
rs.close();
ps.close();
Con.close();
