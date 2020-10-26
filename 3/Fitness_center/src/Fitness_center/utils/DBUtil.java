package Fitness_center.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	Connection con = null;
    boolean isTrans = false;

    public DBUtil() {
        try {
            Context env = (Context) new InitialContext().lookup("java:comp/env");
            DataSource _pool = (DataSource) env.lookup("jdbc/fitness_center");
            if (_pool != null) {
                con = _pool.getConnection();
            }
        } catch (Exception e) {
        }
    }
    public boolean beginTrans() {
        try {
            this.isTrans=false;
            if (con != null) {
                boolean supportsTransactions = con.getMetaData().supportsTransactions();
                if (supportsTransactions) {
                    con.setAutoCommit(false);
                    this.isTrans = true;
                }
            }
        } catch (Exception e) {
            this.isTrans=false;
        }
        return isTrans;
    }

    public Connection getConnection() {
        return con;
    }

    public void commit(){
        this.close(false, null, null);
    }
    public void commit(Statement stm, ResultSet rs){
        this.close(false, stm, rs);
    }
    public void commit(Statement stm){
        this.close(false, stm,null);
    }
    public void rollback(){
        this.close(false, null, null);
    }
    public void rollback(Statement stm, ResultSet rs){
        this.close(true, stm, rs);
    }
    public void rollback(Statement stm){
        this.close(true, stm,null);
    }
    private void close(boolean isrollback, Statement stm, ResultSet rs) {
        try {
            if (isTrans) {
                if (isrollback) {
                    con.rollback();
                } else {
                    con.commit();
                }
                con.setAutoCommit(true);
            }
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
