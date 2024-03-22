import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MadarakaExpress extends MIDlet implements CommandListener {

    private Command exitCommand; // The exit command
    private Display display;     // The display for this MIDlet
    private TextBox textBox;     // The TextBox for initial information

    public MadarakaExpress() {
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.EXIT, 0);

        // Initialize the TextBox
        textBox = new TextBox("Book Ticket", "Book KR Makadara Express\n" +
                "1. Intercounty 8:00 AM\n" +
                "2. Nairobi-Voi-Msa Express\n" +
                "3. Mombasa-Voi-Nrb Express\n" +
                "4. Suswa Train\n\n" +
                "Helpline: 0709388888\n\n" +
                "00. Main\n98. MORE", 256, 0);
        textBox.addCommand(exitCommand);
        textBox.setCommandListener(this);
    }

    public void startApp() {
        // Show the TextBox initially
        display.setCurrent(textBox);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            // Show an Alert when "Exit" command is selected
            Alert alert = new Alert("Exit", "Are you sure you want to exit?", null, AlertType.CONFIRMATION);
            alert.setTimeout(Alert.FOREVER);
            alert.addCommand(new Command("Yes", Command.OK, 0));
            alert.addCommand(new Command("No", Command.CANCEL, 1));
            alert.setCommandListener(this);
            display.setCurrent(alert);
        } else if (c.getCommandType() == Command.OK) {
            // If "Yes" is selected in the confirmation Alert, exit the MIDlet
            destroyApp(false);
            notifyDestroyed();
        } else if (c.getCommandType() == Command.CANCEL) {
            // If "No" is selected in the confirmation Alert, go back to the TextBox
            display.setCurrent(textBox);
        }
    }
}

