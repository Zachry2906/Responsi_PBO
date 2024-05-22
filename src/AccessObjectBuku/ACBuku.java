/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccessObjectBuku;
import AccessObjectInterface.BukuImplement;
import Model.DataBuku;
import Koneksi.Connector;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author aryaz
 */
public class ACBuku implements BukuImplement{
    Connection connection;

    public ACBuku() {
        connection = Connector.getConnection();
    }

    @Override
    public void insert(DataBuku db) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?)");
            ps.setString(1, db.getJudul());
            ps.setString(2, db.getPenulis());
            ps.setDouble(3, db.getRating());
            ps.setDouble(4, db.getHarga());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ACBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DataBuku db) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("UPDATE buku SET judul = ?, penulis = ?, rating = ?, harga = ? WHERE judul = ?");
            ps.setString(1, db.getJudul());
            ps.setString(2, db.getPenulis());
            ps.setDouble(3, db.getRating());
            ps.setDouble(4, db.getHarga());
            ps.setString(5, db.getJudul());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ACBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void delete(String id) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("DELETE FROM buku WHERE judul = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ACBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<DataBuku> getAll() {
        List<DataBuku> lb = new ArrayList<>();
        Statement s;
        ResultSet rs;
        try {
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM buku");
            while (rs.next()){
                DataBuku db = new DataBuku();
                db.setJudul(rs.getString("judul"));
                db.setPenulis(rs.getString("penulis"));
                db.setRating(rs.getDouble("rating"));
                db.setHarga(rs.getInt("harga"));
                lb.add(db);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ACBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
        return lb;
    }
    
    
}
