package util;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    private List<String[]> rows = new ArrayList<>();

    public void addRow(String... cols) {
        rows.add(cols);
    }

    private int[] colWidths() {
        int cols = -1;

        for (String[] row : rows)
            cols = Math.max(cols, row.length);

        int[] widths = new int[cols];

        for (String[] row : rows) {
            for (int colNum = 0; colNum < row.length; colNum++) {
                widths[colNum] = Math.max(widths[colNum], row[colNum].length());
            }
        }

        return widths;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        int[] colWidths = colWidths();

        for (String[] row : rows) {
            for (int colNum = 0; colNum < row.length; colNum++) {
                buf.append(String.format("%-" + colWidths[colNum] + "s  ", row[colNum]));
            }
            buf.append("\n");
        }

        return buf.toString();
    }
}
