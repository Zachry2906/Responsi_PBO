/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import Model.*;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author aryaz
 */
public class ModelTableBuku extends AbstractTableModel {

    private List<DataBuku> lb;

    public ModelTableBuku(List<DataBuku> lb) {
        this.lb = lb;
    }

    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lb.get(rowIndex).getJudul();
            case 1:
                return lb.get(rowIndex).getPenulis();
            case 2:
                return lb.get(rowIndex).getRating();
            case 3:
                return lb.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    
}
