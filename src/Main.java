import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        if (createDir(sb, "Games/src")) {
            if (createDir(sb, "Games/src/main")) {
                createFile(sb, "Games/src/main/Main.java");
                createFile(sb, "Games/src/main/Utils.java");
            }
            createDir(sb, "Games/src/test");
        }
        if (createDir(sb, "Games/res")) {
            createDir(sb, "Games/res/drawables");
            createDir(sb, "Games/res/vectors");
            createDir(sb, "Games/res/icons");
        }
        createDir(sb, "Games/savegames");
        if (createDir(sb, "Games/temp")) {
            if (createFile(sb, "Games/temp/temp.txt")) {
                try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
                    writer.write(sb.toString());
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static boolean createDir(StringBuilder sb, String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdir()) {
            sb.append("Каталог \"" + dirPath + "\" создан успешно\n");
            return true;
        } else {
            sb.append("Каталог \"" + dirPath + "\" не был создан\n");
            return false;
        }
    }

    public static boolean createFile(StringBuilder sb, String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                sb.append("Файл \"" + fileName + "\" создан успешно\n");
                return true;
            }
        } catch (IOException ex) {
            sb.append("Файл \"" + fileName + "\" не был создан\n");
        }
        return false;
    }
}
