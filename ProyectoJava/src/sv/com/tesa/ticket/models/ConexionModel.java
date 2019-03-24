/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

/**
 *
 * @author vaselinux
 */
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionModel
{
    protected static Connection conexion=null;
    protected PreparedStatement st;
    protected ResultSet rs;
    public ConexionModel() 
    {
       
        this.st = null;
        this.rs = null;
    }
    public static DataSource getMySQLDataSource() 
    {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
                fis = new FileInputStream("db.properties");
                props.load(fis);
                mysqlDS = new MysqlDataSource();
                mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
                mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
                mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) 
        {
            
        }
        return mysqlDS;
    }
    public void conectar() 
    {
        try {
            if(conexion==null || conexion.isClosed()){
            DataSource dataSource = getMySQLDataSource();
            conexion = dataSource.getConnection();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() throws SQLException 
    {
        //Cierro los objetos en el orden inverso del que se crean
        // es decir: primero el resulset, luego el statement
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }

    }
	
}

