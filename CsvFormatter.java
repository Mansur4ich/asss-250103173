package task1;

public class CsvFormatter implements ReportFormatter {
    private String csvValue(String value) {
        if (value == null) value = "";
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    @Override
    public String format(String title, String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("# TITLE: ").append(title).append("\n");
        for (int j = 0; j < headers.length; j++) {
            if (j > 0) sb.append(",");
            sb.append(csvValue(headers[j]));
        }
        sb.append("\n");
        for (String[] row : rows) {
            for (int j = 0; j < row.length; j++) {
                if (j > 0) sb.append(",");
                sb.append(csvValue(row[j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
