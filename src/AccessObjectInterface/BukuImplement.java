/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccessObjectInterface;
import java.util.List;
import Model.*;

/**
 *
 * @author aryaz
 */
public interface BukuImplement {
    public void insert(DataBuku db);
    public void update(DataBuku db);
    public void delete(String id);
    public List<DataBuku> getAll();
}
