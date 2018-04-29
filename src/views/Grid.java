/**
 *
 * @author Nicolas 25.05.2016
 *
Greedy Pathfinding is a tool for visualizing the greedy algorithm.
Copyright (C) 2016  Nicolas Raube
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package views;

import java.awt.*;
import java.util.ArrayList;

public class Grid {

    public static final int LINE_COUNT = 15;
    private ArrayList<Line> lines = new ArrayList<>();
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    public static final int LINE_GAP = 50;
    private final static String LINE_COLOR_HEX = "#D1D1D1";

    public Grid() {
        initLines();
    }

    private void initLines() {

        for (int line = 1; line <= LINE_COUNT; line++) {
            lines.add(new Line(0, line * LINE_GAP, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), line * LINE_GAP, Color.decode(LINE_COLOR_HEX)));
            lines.add(new Line(line * LINE_GAP, 0, line * LINE_GAP, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(), Color.decode(LINE_COLOR_HEX)));
        }

        for (int x = -LINE_GAP / 2; x <= LINE_COUNT * LINE_GAP; x += LINE_GAP) {

            for (int y = -LINE_GAP / 2; y <= LINE_COUNT * LINE_GAP; y += LINE_GAP) {

                rectangles.add(new Rectangle(x, y, LINE_GAP, LINE_GAP));

            }

        }

    }

    public void paint(Graphics graphics) {
        for (Line line : lines) {
            line.paint(graphics);
        }
    }

    public Point getCoordsFor(Rectangle rect) {

        for (Rectangle rectangle : rectangles) {

            if(rect.intersects(rectangle))
                return new Point((int) rectangle.getLocation().getX() + LINE_GAP / 4, (int) rectangle.getLocation().getY() + LINE_GAP / 4);

        }

        return new Point(0, 0);

    }

}
