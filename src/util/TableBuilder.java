package util;

public class TableBuilder {

    private static final String HORIZONTAL_LINE = "---------------------------------------------------";

    public static String buildTable(String[] headers, String[][] data) {
        StringBuilder table = new StringBuilder();

        // Add headers
        for (String header : headers) {
            table.append(String.format("%-20s", header)).append(" | ");
        }
        table.append("\n").append(HORIZONTAL_LINE).append("\n");

        // Add data rows
        for (String[] row : data) {
            for (String col : row) {
                table.append(String.format("%-20s", col)).append(" | ");
            }
            table.append("\n");
        }

        return table.toString();
    }
}
