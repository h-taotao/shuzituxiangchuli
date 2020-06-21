package com.dgut.mvc.jdbcutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbctools {
    public static Connection connecter() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3307/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "200017";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        if(conn!=null)
            System.out.println("connect success");
        return conn;
    }
    public static <T> List<T> daoSearch(Class<T> clazz,String sql,Object...params) throws SQLException
            {
                List<T> result=new ArrayList<T>();
                Connection connection=null;
                ResultSet resultSet=null;
                PreparedStatement statement=null;
                try {
                    connection=connecter();
                    statement=connection.prepareStatement(sql);
                    for(int i=0;i<params.length;i++)
                    {
                        statement.setObject((i+1),params[i]);
                    }
                    resultSet=statement.executeQuery();
                    ResultSetMetaData rsmd=resultSet.getMetaData();
                    int counm=rsmd.getColumnCount();
                    while(resultSet.next())
                    {
                        T t=clazz.newInstance();
                        for(int i=1;i<=counm;i++) {
                            String lable = rsmd.getColumnLabel(i);
                            Object a = resultSet.getObject(i);
                            BeanUtils.setProperty(t,lable,a);
                        }
                        result.add(t);
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
            close_CSR(connection,statement);
        }
        return  result;
    }
    public static  void close_CSR(Connection connection,Statement statement) throws SQLException
    {
        	if(connection !=null)
        		connection.close();
        	if(statement != null)
        		statement.close();
        
    }
    
    public  static  int table_update(Connection connection, String sql,Object ...params) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        int result=0;
        try {
            statement=connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++)
            {
                statement.setObject((i+1),params[i]);
            }
            result=statement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            statement.close();
        }
        return  result;
    }
    public static void daoUpdata() throws SQLException {
        String sql="UPDATE 学生：student SET studentName=? WHERE classNo=?";
        Connection connection=null;
        try {
            connection=connecter();
            connection.setAutoCommit(false);
            System.out.println();
            table_update(connection,sql,"ttt","1");
            System.out.println("change success");
            connection.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }finally {
            connection.close();
        }
    }
    public static  Connection connectCp30()throws Exception {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String driverClass="com.mysql.cj.jdbc.Driver";
        String connectUrl="jdbc:mysql://localhost:3307/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
        String user="root";
        String password="200017";
        ComboPooledDataSource cdps=new ComboPooledDataSource();
        cdps.setDriverClass(driverClass);
        cdps.setJdbcUrl(connectUrl);
        cdps.setUser(user);
        cdps.setPassword(password);
        return cdps.getConnection();
    }
    public static  void  main(String[] args) throws Exception {
    }

}
