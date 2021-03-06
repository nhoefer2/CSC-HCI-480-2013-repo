package edu.oswego.csc480_hci521_2013.shared.h2o.json;

import java.util.ArrayList;

/**
 *
 */
public class Inspect extends H2OResponse {

    private String type;
    private String key;
    private int num_rows;
    private int num_cols;
    private int row_size;
    private int value_size_bytes;
    private ArrayList<ColumnDef> cols;
    private ArrayList<InspectRow> rows;

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public int getNumRows() {
        return num_rows;
    }

    public int getNumCols() {
        return num_cols;
    }

    public int getRowSize() {
        return row_size;
    }

    public int getValueSizeBytes() {
        return value_size_bytes;
    }

    public ArrayList<ColumnDef> getCols() {
        return cols;
    }

    public ArrayList<InspectRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "Inspect{" + "type=" + type + ", key=" + key + ", num_rows=" + num_rows + ", num_cols=" + num_cols + ", row_size=" + row_size + ", value_size_bytes=" + value_size_bytes + ", cols=" + cols + ", rows=" + rows + " " + super.toString() + '}';
    }
}
