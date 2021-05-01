package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import model.Notification;

public class NotificationService
{

    private static final NotificationService SINGLETON = new NotificationService();
    private NotificationService(){}
    public static NotificationService getInstance()
    {
        return SINGLETON;
    }

    private static final String DIRECTORY_PATH = "resources/notifications";
    private static final String FILE_PATH = DIRECTORY_PATH + "/notifications.csv";

    public void sendNotification (Notification notification)
    {
        if(!Files.exists(Paths.get(DIRECTORY_PATH)))
        {
            try
            {
                Files.createDirectories(Paths.get(DIRECTORY_PATH));
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if(!Files.exists(Paths.get(FILE_PATH)))
        {
            try
            {
                Files.createFile(Paths.get(FILE_PATH));
                BufferedWriter writer  = Files.newBufferedWriter((Paths.get(FILE_PATH)), StandardOpenOption.APPEND);
                writer.write( "action name" + "," +  "timestamp" +"\n");
                writer.flush();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

        try
        {
            BufferedWriter writer  = Files.newBufferedWriter((Paths.get(FILE_PATH)), StandardOpenOption.APPEND);
            writer.write( notification.getMessage() + "," +  notification.getTimeStamp() +"\n");
            writer.flush();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void viewNotifications(String filename)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader((Paths.get(filename)));
            String line = "";
            while ((line = reader.readLine())!= null)
            {
                System.out.println(line);
            }
            }
        catch (NoSuchFileException var4) {
            System.out.println("The file with the name " + filename + " doesn't exist.");
        } catch (IOException var5) {
            PrintStream var10000 = System.out;
            Class var10001 = var5.getClass();
            var10000.println(var10001 + " " + var5.getMessage());
    }
    }
}
