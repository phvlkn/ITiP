import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopyAllErrors {

    public static void main(String[] args) {

        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            // открываем файлы
            input = new FileInputStream("input.txt");
            output = new FileOutputStream("output.txt");

            int data;
            // чтение и запись данных
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            System.out.println("Файл успешно скопирован.");

        }
        catch (FileNotFoundException e) {
            // ошибки открытия
            System.out.println("Ошибка: не удалось открыть один из файлов.");
        }
        catch (IOException e) {
            // ошибка чтения или записи
            System.out.println("Ошибка чтения или записи файла.");
        }
        catch (Exception e) {
            // все остальное
            System.out.println("Произошла непредвиденная ошибка.");
        }
        finally {
            //закрыввем файлы
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            }
            catch (IOException e) {
                System.out.println("Ошибка при закрытии файла.");
            }
        }
    }
}