// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
// Code partially developed by Dr. Curtis Dyreson of Utah State University

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConwaysLife {
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TextGraphics graphics = screen.newTextGraphics();

            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());
            simulation.insertPattern(new PatternBlock(), 10,10);
            simulation.insertPattern(new PatternBlinker(), 0, 10);
            simulation.insertPattern(new PatternGlider(), 0, 0);


            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 50; i++) {
                render(simulation, screen, graphics);// Render the current state of the simulation
                Thread.yield();                         // Let the JVM have some time to update other things
                Thread.sleep(1000);                // Sleep for a bit to make for a nicer paced animation
                simulation.update();                    // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }

    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {
        screen.clear();
        for (int row1 = 0; row1 < simulation.getSizeY(); row1++) {
            for (int column1 = 0; column1 < simulation.getSizeX(); column1++) {
                if (simulation.getCell(column1, row1)) {
                    graphics.setCharacter(column1, row1, 'X');
                }
            }
        }
        // This is what causes the console to render the new state, it is required
        try {
            screen.refresh();
        } catch (Exception ex) {
        }
    }
}