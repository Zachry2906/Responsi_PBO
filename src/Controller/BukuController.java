/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import AccessObjectBuku.ACBuku;
import Model.*;
import java.util.List;
import responsi.MainView1;
import AccessObjectInterface.BukuImplement;

/**
 *
 * @author aryaz
 */
public class BukuController {
    MainView1 frame;
    BukuImplement implement;
    List<DataBuku> lb;

    public BukuController(MainView1 frame) {
        this.frame = frame;
        implement = new ACBuku();
        lb = implement.getAll();
    }

    public void isiTable() {
        lb = implement.getAll();
        ModelTableBuku mtb = new ModelTableBuku(lb);
        frame.getShowTable().setModel(mtb);
    }

    public void insert(){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getTFBuku1().getText());
        db.setPenulis(frame.getTFPenulis1().getText());
        double rating = Double.parseDouble(frame.getTFRating().getText());
        db.setRating(rating);
        double harga = Double.parseDouble(frame.getTFHarga().getText());
        harga = harga + 500 + (rating * 100 );
        db.setHarga(harga);
        implement.insert(db);
    }

    public void update(){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getTFBuku1().getText());
        db.setPenulis(frame.getTFPenulis1().getText());
        double rating = Double.parseDouble(frame.getTFRating().getText());
        db.setRating(rating);
        double harga = Double.parseDouble(frame.getTFHarga().getText());
        harga = harga + 500 + (rating * 100);
        db.setHarga(harga);
        implement.update(db);
    }

    public void delete(){
        DataBuku db = new DataBuku();
        String id = frame.getTFBuku1().getText();
        implement.delete(id);
    }

    
}
