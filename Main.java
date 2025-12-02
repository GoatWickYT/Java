import java.util.ArrayList;

public class Main {

  public static String puzzle = "000930481231008069084000237300090870009200000700600043508010004000809005160050308";
  public static String solution = "657932481231748569984165237316594872849273156725681943598316724473829615162457398";

  public static int getShortestLine(ArrayList<String> rows) {
    int shortestRowIndex = 0;
    for (String row : rows) {
      if (row.replaceAll("0", "").length() > (rows.toArray()[shortestRowIndex].toString().replaceAll("0", "").length())
          && row.replaceAll("0", "").length() != 9) {
        shortestRowIndex = rows.indexOf(row);
      }
    }
    return shortestRowIndex;
  }

  public static ArrayList<String> getMissingNumbers(String line) {
    ArrayList<String> numbers = new ArrayList<String>();
    for (int i = 1; i <= 9; i++) {
      numbers.add("" + i);
    }
    for (String character : line.split("")) {
      numbers.remove(character);
    }
    return numbers;
  }

  public static void trySolveLine(String line, Boolean row) {
    getMissingNumbers(line);
  }

  public static void solveSudokuWittner(String sudoku) {
    ArrayList<String> rows = new ArrayList<String>();
    ArrayList<String> cols = new ArrayList<String>();

    for (int i = 0; i < sudoku.split("").length; i += 9) {
      rows.add(sudoku.substring(i, i + 9));
    }

    for (int i = 0; i < rows.toArray().length; i++) {
      String col = "";
      for (String row : rows) {
        col += row.charAt(i);
      }
      cols.add(col);
    }

    String shortestRow = rows.get(getShortestLine(rows)).toString();
    String shortestCol = cols.get(getShortestLine(cols)).toString();
    if (shortestRow.replaceAll("0", "").length() > shortestCol.replaceAll("0", "").length()) {
      trySolveLine(shortestRow, true);
    } else {
      trySolveLine(shortestCol, false);
    }
  }

  public static void main(String args[]) {
    long startTime = System.nanoTime();

    solveSudokuWittner(puzzle);

    long endTime = System.nanoTime();
    long durationInMs = (endTime - startTime) / 1_000_000;
    System.out.println("Runtime: " + durationInMs + " ms");
  }
}